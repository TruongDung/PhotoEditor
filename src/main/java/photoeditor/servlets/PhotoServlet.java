package photoeditor.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import photoeditor.domainclasses.Photo;
import photoeditor.domainclasses.Token;
import photoeditor.services.PhotoService;
import photoeditor.services.TokenService;
import photoeditor.services.UserService;
import photoeditor.utilities.TokenValidator;

@WebServlet("/photo")
public class PhotoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Autowired
    private PhotoService photoService;
	
	@Autowired
	private TokenService tokenService;
	
    public PhotoServlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
        //https://stackoverflow.com/questions/43654488/spring-boot-inject-bean-into-httpservlet
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("photo do get");
    }
    
    private String saveImage(int userId, int photoId, String photoTitle, String imageBase64) throws ServletException, IOException {
    	
		Photo photo = photoService.find(photoId);
		if (photo == null) {
			photo = new Photo(userId, imageBase64, photoTitle);
		}
		else {
			photo.setImageData(imageBase64);
		}
		
		JSONObject json = null;
		try {
			photoService.save(photo);
			json = new JSONObject("{'result':'Success', 'photoId':'" + photo.getId() + "'}");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return (json != null) ? json.toString() : "{ \"result\":\"Error\" }";
    }
    
    private String deleteImage(int userId, int photoId) throws ServletException, IOException {
    	
    	JSONObject json = null;
    	try {
    		Photo photo = photoService.find(photoId);
    		if (photo != null && photo.getUserId() == userId) {
    			photoService.delete(photoId);
    			json = new JSONObject("{'result':'Success'}");
    		}
    		else {
    			json = new JSONObject("{'result':'Error', 'error':'Photo does not exist or it's not your photo'}");	
    		}
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
		
		// Validate token
		int userId = Integer.parseInt(request.getParameter("userId"));
		String token = request.getParameter("token");
		List<Token> activeTokens = tokenService.findByToken(token);
		Token activeToken = (activeTokens != null && activeTokens.size() > 0) ? activeTokens.get(0) : null;
		
		if (activeToken == null ||
				!activeToken.isActive() ||
				activeToken.getUserId() != userId || 
				!TokenValidator.validate(activeToken, request) || 
				!TokenValidator.verifyTokenFromFirebase(activeToken.getToken())) {
			errorMsg = "Unauthorized or Invalid token";
			writer.print("{ \"result\":\"Error\", \"error\":\"" + errorMsg + "\" }");
			return;
		}
		
		String action = request.getParameter("action");
		String result = "{ \"result\":\"Error\", \"error\": \"Unsupported action\" }";
		
		if(action != null) {
			if (action.toUpperCase().equals("POST")) {
				int photoId = Integer.parseInt(request.getParameter("photoId"));
				String photoTitle = request.getParameter("photoTitle");
				String imageBase64 = request.getParameter("imageData");
				result = saveImage(userId, photoId, photoTitle, imageBase64);
			}
			else if (action.toUpperCase().equals("DELETE")) {
				int photoId = Integer.parseInt(request.getParameter("id"));
				result = deleteImage(userId, photoId);
			} 
		}
		
		writer.print(result);
	}
}
