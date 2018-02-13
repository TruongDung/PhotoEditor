package photoeditor.services;

import java.util.List;

import javax.transaction.Transactional;

import photoeditor.domainclasses.Token;

public interface TokenService extends GenericService<Token> {
	List<Token> findByUserId(int userId);
	List<Token> findByUserIdAndIsActive(int userId, boolean isActive);
	List<Token> findByToken(String token);
	void deleteToken(String token);
}
