package photoeditor.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import photoeditor.domainclasses.Token;
import photoeditor.repositories.TokenRepository;
import photoeditor.services.TokenService;

@Service
public class TokenServiceImpl implements TokenService {

	@Autowired
	private TokenRepository activeTokenRepository;
	
	@Override
	public Token save(Token entity) {
		return activeTokenRepository.save(entity);
	}

	@Override
	public Token update(Token entity) {
		return activeTokenRepository.save(entity);
	}

	@Override
	public void delete(Token entity) {
		activeTokenRepository.delete(entity);
	}

	@Override
	public void delete(int id) {
		activeTokenRepository.delete(id);
	}

	@Override
	public void deleteInBatch(List<Token> entities) {
		activeTokenRepository.deleteInBatch(entities);
	}

	@Override
	public Token find(int id) {
		return activeTokenRepository.findOne(id);
	}

	@Override
	public List<Token> findAll() {
		return activeTokenRepository.findAll();
	}

	@Override
	public List<Token> findByUserId(int userId) {
		return activeTokenRepository.findByUserId(userId);
	}

	@Override
	public List<Token> findByUserIdAndIsActive(int userId, boolean isActive) {
		return activeTokenRepository.findByUserIdAndIsActive(userId, isActive);
	}

	@Override
	public List<Token> findByToken(String token) {
		return activeTokenRepository.findByToken(token);
	}

	@Override
	public void deleteToken(String token) {
		activeTokenRepository.deleteToken(token);
	}

	@Override
	public void deleteAllInBatch() {
		activeTokenRepository.deleteAllInBatch();
	}
	
}
