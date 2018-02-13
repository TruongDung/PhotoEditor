package photoeditor.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import photoeditor.domainclasses.User;
import photoeditor.repositories.UserRepository;
import photoeditor.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User save(User entity) {
		return userRepository.save(entity);
	}

	@Override
	public User update(User entity) {
		return userRepository.save(entity);
	}

	@Override
	public void delete(User entity) {
		userRepository.delete(entity);
	}

	@Override
	public void delete(int id) {
		userRepository.delete(id);
	}

	@Override
	public void deleteInBatch(List<User> entities) {
		userRepository.deleteInBatch(entities);
	}

	@Override
	public User find(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findByOauthUid(String oauthUid) {
		return userRepository.findByOauthUid(oauthUid);
	}

	@Override
	public void deleteAllInBatch() {
		userRepository.deleteAllInBatch();	
	}

}
