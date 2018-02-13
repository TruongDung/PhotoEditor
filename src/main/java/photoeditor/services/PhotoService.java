package photoeditor.services;

import java.util.List;

import photoeditor.domainclasses.Photo;

public interface PhotoService extends GenericService<Photo> {
	List<Photo> findByUserId(int userId);
}
