package photoeditor.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import photoeditor.domainclasses.Token;
import photoeditor.domainclasses.User;
import photoeditor.services.TokenService;
import photoeditor.services.UserService;
import photoeditor.utilities.HeaderParser;
import photoeditor.utilities.TokenValidator;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
    private UserService userService;
	
	@Autowired 
	private TokenService tokenService;
	
    public UserServlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
        //https://stackoverflow.com/questions/43654488/spring-boot-inject-bean-into-httpservlet
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.write("User Servlet");
	}
    
    private String doSignIn(HttpServletRequest request, String token, String oauthProvider, String oauthUid, String displayName, String email, String photoUrl, String fbToken) throws IOException {
    	
		User user = userService.findByOauthUid(oauthUid);
		List<Token> activeTokens = tokenService.findByToken(token);
		Token activeToken = (activeTokens != null && activeTokens.size() > 0) ? activeTokens.get(0) : null;
		
		// Validate token from our side (restrict a bad guy to send used token)
		if (activeToken != null) {
			int userId = (user != null) ?  user.getId() : -1;
			if (!activeToken.isActive() || 
				activeToken.getUserId() != userId || 
				!TokenValidator.validate(activeToken, request)) {
				return "{ \"result\":\"Error\", \"error\":\"Unauthorized or Invalid token\" }";
			}				
		}
		
		if(user == null) { // new user, new token
			user = new User(oauthProvider, oauthUid, displayName, email, photoUrl);
			userService.save(user);
			activeToken = new Token(user.getId(), token, true, HeaderParser.getOs(request), HeaderParser.getBrowser(request), HeaderParser.getIp(request));
			tokenService.save(activeToken);
		}
		else { // existed user, update new token if needed
			if (activeToken == null) {
				activeToken = new Token(user.getId(), token, true, HeaderParser.getOs(request), HeaderParser.getBrowser(request), HeaderParser.getIp(request));
				tokenService.save(activeToken);						
			}
		}
		
		if (request.getSession(false) == null) {
			request.getSession();
		}
		
		request.getSession(false).setAttribute("userId", user.getId());
		if (fbToken != null && !fbToken.isEmpty() && !fbToken.toLowerCase().equals("null")) {
			request.getSession(false).setAttribute("fbToken", fbToken);	
		}

		JSONObject json = null;
		try {
			Object fbTokenObj = request.getSession(false).getAttribute("fbToken");
			if (fbTokenObj != null) {
				fbToken = String.valueOf(fbTokenObj);
			}
			json = new JSONObject("{ 'result':'Success', 'userId':'" + user.getId() + "', 'fbToken':'" + fbToken + "' }");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return (json != null) ? json.toString() : "{ \"result\":\"Error\" }";
    }
    
    private String doSignOut(HttpServletRequest request, int userId, String token) throws IOException {
    	
    	// Kill current session
    	HttpSession session = request.getSession(false);
    	session.invalidate();
    	
		// Validate token from our side
		List<Token> activeTokens = tokenService.findByToken(token);
		Token activeToken = (activeTokens != null && activeTokens.size() > 0) ? activeTokens.get(0) : null;
		
		if (activeToken == null ||
				!activeToken.isActive() ||
				activeToken.getUserId() != userId || 
				!TokenValidator.validate(activeToken, request)) {
			return "{ \"result\":\"Error\", \"error\":\"Unauthorized or Invalid token\" }";
		}
		
		JSONObject json = null;
		try {
			tokenService.deleteInBatch(activeTokens);
			json = new JSONObject("{ 'result':'Success' }");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return (json != null) ? json.toString() : "{ \"result\":\"Error\" }";
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		String errorMsg = "";
		PrintWriter writer = response.getWriter();
		
		// Verify token against Firebase
		String token = request.getParameter("token");
		if (!TokenValidator.verifyTokenFromFirebase(token)) {
			errorMsg = "Unauthorized or Invalid token";
			writer.print("{ \"result\":\"Error\", \"error\":\"" + errorMsg + "\" }");
			return;
		}
		
		String action = request.getParameter("action");
		String result = "{ \"result\":\"Error\", \"error\": \"Unsupported action\" }";
		
		if (action != null) {
			if (action.toUpperCase().equals("SIGNIN")) {
				String oauthProvider = request.getParameter("oauthProvider");
				String oauthUid = request.getParameter("oauthUid");
				String displayName = request.getParameter("displayName");
				String email = request.getParameter("email");
				String photoUrl = request.getParameter("photoUrl");
				String fbToken = request.getParameter("fbToken");
				result = doSignIn(request, token, oauthProvider, oauthUid, displayName, email, photoUrl, fbToken);
			} else if (action.toUpperCase().equals("SIGNOUT")) {
				int userId = Integer.parseInt(request.getParameter("userId"));
				result = doSignOut(request, userId, token);
			}
		}
		
		writer.print(result);
	}
}
