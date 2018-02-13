package photoeditor.repositories;

import org.springframework.stereotype.Repository;
import photoeditor.domainclasses.User;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByOauthUid(String oauthUid);
}
