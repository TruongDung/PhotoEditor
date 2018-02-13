package photoeditor.services;

import photoeditor.domainclasses.User;

public interface UserService extends GenericService<User> {
	User findByOauthUid(String oauthUid);
}
