package photoeditor.domainclasses;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String oauthProvider;
	
	private String oauthUid;
	
	private String firstName;
	
	private String lastName;
	
	private String displayName;

	private String email;
	
	private String gender;

	private String picture;
	
	private LocalDateTime created;
	
	private LocalDateTime modified;
	
	public User() {
		
	}
	
	public User(String oauthProvider, String oauthUid, String displayName, String email, String photoUrl) {
		this.oauthProvider = oauthProvider;
		this.oauthUid = oauthUid;
		this.displayName = displayName;
		this.email = email;
		this.picture = photoUrl;
		this.created = this.modified = LocalDateTime.now();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOAuthProvider() {
		return oauthProvider;
	}

	public void setOAuthProvider(String oauthProvider) {
		this.oauthProvider = oauthProvider;
	}

	public String getOAuthUID() {
		return oauthUid;
	}

	public void setOAuthUID(String oauthUid) {
		this.oauthUid = oauthUid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}
}
