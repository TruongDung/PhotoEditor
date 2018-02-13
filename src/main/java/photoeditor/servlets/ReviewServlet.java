package photoeditor.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import photoeditor.domainclasses.Photo;
import photoeditor.services.PhotoService;

@WebServlet("/review")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
    private PhotoService photoService;
    
    public ReviewServlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	 SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = (int)request.getSession(false).getAttribute("userId");
		List<Photo> photos = photoService.findByUserId(userId);
		request.setAttribute("photos", photos);
		request.getRequestDispatcher("/WEB-INF/jsp/review.jsp").forward(request, response);
	}
}
