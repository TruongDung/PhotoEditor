package photoeditor.domainclasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="tokens")
public class Token {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	private int userId;
	
	@Column(name="token", length=2000)
	private String token;
	
	private String os;
	
	private String browser;
	
	private String ip;
	
	private boolean isActive;

	public Token() {
		
	}
	
	public Token(int userId, String token, boolean isActive, String os, String browser, String ip) {
		this.userId = userId;
		this.token = token;
		this.isActive = isActive;
		this.os = os;
		this.browser = browser;
		this.ip = ip;
	}
	
	public Token(int userId, String token, boolean isActive) {
		this.userId = userId;
		this.token = token;
		this.isActive = isActive;
	}
	
	public Token(int userId, String token) {
		this.userId = userId;
		this.token = token;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
