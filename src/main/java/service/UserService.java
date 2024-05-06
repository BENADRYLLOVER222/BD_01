package service;

import bean.*;

public interface UserService {

	User signIn(AuthInfo authInfo);

	boolean registration(RegInfo regInfo);

	boolean blockUser(int id);

	Profile userProfile(int id);

}
