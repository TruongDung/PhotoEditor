package photoeditor.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;

import photoeditor.domainclasses.Token;

public final class TokenValidator {
	
	private TokenValidator() {}
	private static FileInputStream serviceAccount;
	private static FirebaseOptions options;
	
	static {
		try {
			URL filePath = TokenValidator.class.getResource("/photo-editor-11bc2-firebase-adminsdk-taa2f-914df805c5.json");
			serviceAccount = new FileInputStream(filePath.getPath().replace("%20" , " "));
			options = new FirebaseOptions.Builder()
					  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
					  .setDatabaseUrl("https://photo-editor-11bc2.firebaseio.com")
					  .build();
			FirebaseApp.initializeApp(options);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean validate(Token token, HttpServletRequest request) {
		
		String os = HeaderParser.getOs(request);
		String browser = HeaderParser.getBrowser(request);
		String ip = HeaderParser.getIp(request);
		
		return (token.getOs() != null && token.getOs().equals(os) &&
				token.getBrowser() != null && token.getBrowser().equals(browser) &&
				token.getIp() != null && token.getIp().equals(ip));
	}
	
	public static boolean verifyTokenFromFirebase(String idToken)  {
		
		try {
			FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get();
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		} catch (ExecutionException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
