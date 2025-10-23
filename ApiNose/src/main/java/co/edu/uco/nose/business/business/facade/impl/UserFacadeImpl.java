package co.edu.uco.nose.business.business.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.business.assembler.dto.impl.UserDTOAssembler;
import co.edu.uco.nose.business.business.facade.UserFacade;
import co.edu.uco.nose.business.business.impl.UserBusinessImpl;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.factory.DAOFactory;
import co.edu.uco.nose.dto.UserDTO;

public final class UserFacadeImpl implements UserFacade {

	@Override
	public void registerNewUserInformation(final UserDTO userDto) {
		
		var daoFactory = DAOFactory.getFactory();
		var business = new UserBusinessImpl(daoFactory);
		
		try {
			daoFactory.initTransaction();
			
			var domain = UserDTOAssembler.getUserDTOAssembler().toDomain(userDto);
			business.registerNewUserInformation(domain);
			
			daoFactory.commitTransaction();
			
		} catch(final NoseException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch(final Exception exception) {
			daoFactory.rollbackTransaction();
			
			var userMessage = MessagesEnum.USER_ERROR_FACADE_REGISTERING_USER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACADE_REGISTERING_USER.getContent();
			
			throw NoseException.create(exception, userMessage, technicalMessage);
			
		} finally {
			daoFactory.closeConnection();
		}
		
	}

	@Override
	public void dropUserInformation(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserInformation(UUID id, UserDTO userDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserDTO> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> findUsersByFilter(UserDTO userFilters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO findSpecificUser(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void confirmPhoneNumber(UUID id, int confirmationCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmEmail(UUID id, int confirmationCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendPhoneNumberConfirmation(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendEmailConfirmation(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
