package co.edu.uco.nose.business.business.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.dto.UserDTO;

public interface UserFacade {
	
	void registerNewUserInformation(UserDTO userDto);
	
	void dropUserInformation(UUID id);
	
	void updateUserInformation(UUID id, UserDTO userDto);
	
	List<UserDTO> findAllUsers();
	
	List<UserDTO> findUsersByFilter(UserDTO userFilters);
	
	UserDTO findSpecificUser(UUID id);
	
	void confirmPhoneNumber(UUID id, int confirmationCode);
	
	void confirmEmail(UUID id, int confirmationCode);
	
	void sendPhoneNumberConfirmation(UUID id);
	
	void sendEmailConfirmation(UUID id);
	
}
