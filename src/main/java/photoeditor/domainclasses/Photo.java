package photoeditor.domainclasses;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name="photos")
public class Photo {
	
	static String formatString = "MM-dd-yyyy";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Lob
	//@Column(length=500000)
	private String imageData;
	
	private int userId;
	
	private String title;

	private LocalDateTime created;

	private LocalDateTime modified;
	
	public Photo() { }
	
	public Photo(int userId, String imageData, String title) {
		this.userId = userId;
		this.imageData = imageData;
		this.title = title;
		this.created = this.modified = LocalDateTime.now();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageData() {
		return imageData;
	}

	public void setImageData(String imageData) {
		this.imageData = imageData;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public LocalDateTime getCreated() {
		return created;
	}
	
	public String getCreatedFormat() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatString);
		return String.format("Created Date: %s", this.created.format(formatter));
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
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
