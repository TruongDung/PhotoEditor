package photoeditor.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import photoeditor.domainclasses.Photo;
import photoeditor.repositories.PhotoRepository;
import photoeditor.services.PhotoService;

@Service
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	private PhotoRepository photoRepository;
	
	@Override
	public Photo save(Photo entity) {
		return photoRepository.save(entity);
	}

	@Override
	public Photo update(Photo entity) {
		return photoRepository.save(entity);
	}

	@Override
	public void delete(Photo entity) {
		photoRepository.delete(entity);
	}

	@Override
	public void delete(int id) {
		photoRepository.delete(id);
	}

	@Override
	public void deleteInBatch(List<Photo> entities) {
		photoRepository.deleteInBatch(entities);
	}

	@Override
	public Photo find(int id) {
		return photoRepository.findOne(id);
	}

	@Override
	public List<Photo> findAll() {
		return photoRepository.findAll();
	}

	@Override
	public List<Photo> findByUserId(int userId) {
		return photoRepository.findByUserId(userId);
	}

	@Override
	public void deleteAllInBatch() {
		photoRepository.deleteAllInBatch();
	}

}
