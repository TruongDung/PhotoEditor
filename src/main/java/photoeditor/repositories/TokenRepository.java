package photoeditor.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import photoeditor.domainclasses.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {
	List<Token> findByUserId(int userId);
	List<Token> findByUserIdAndIsActive(int userId, boolean isActive);
	
	@Transactional
	List<Token> findByToken(String token);
	
	@Modifying
	@Transactional
	@Query("DELETE from Token t where t.token = ?1")
	void deleteToken(String token);
}
