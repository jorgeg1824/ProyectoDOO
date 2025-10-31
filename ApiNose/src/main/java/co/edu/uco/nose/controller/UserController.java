package co.edu.uco.nose.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.nose.business.business.facade.impl.UserFacadeImpl;
import co.edu.uco.nose.controller.dto.Response;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.dto.UserDTO;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@GetMapping("/dummy")
	public UserDTO getUserDTODummy() {
		return new UserDTO();
	}
	
	@GetMapping
	public ResponseEntity<Response<UserDTO>> findAllUsers() {
		
		Response<UserDTO> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
		try {
			var facade = new UserFacadeImpl();
			responseObjectData.setData(facade.findAllUsers());
			responseObjectData.addMessage("All users filtered seccesfully!");
			
		}catch (final NoseException exception) {
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(exception.getUserMessage());
			responseStatusCode = HttpStatus.BAD_REQUEST;
			exception.printStackTrace();
		}catch (Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_DAO_UNEXPECTED_ERROR_FINDING_ALL_USERS;
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(userMessage.toString());
			responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			exception.printStackTrace();
		}

		return new ResponseEntity<>(responseObjectData, responseStatusCode);
	}
	
	@PostMapping("/filter")
	public ResponseEntity<Response<UserDTO>> findByFilter(@RequestBody final UserDTO filter) {

	    Response<UserDTO> responseObjectData = Response.createSuccededResponse();
	    HttpStatusCode responseStatusCode = HttpStatus.OK;

	    try {
	        var facade = new UserFacadeImpl();
	        responseObjectData.setData(facade.findUsersByFilter(filter));
	        responseObjectData.addMessage("Users filtered successfully!");

	    } catch (final NoseException exception) {
	        responseObjectData = Response.createFailedResponse();
	        responseObjectData.addMessage(exception.getUserMessage());
	        responseStatusCode = HttpStatus.BAD_REQUEST;
	        exception.printStackTrace();
	    } catch (final Exception exception) {
	        var userMessage = MessagesEnum.USER_ERROR_DAO_FINDING_USER_BY_FILTER;
	        responseObjectData = Response.createFailedResponse();
	        responseObjectData.addMessage(userMessage.toString());
	        responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
	        exception.printStackTrace();
	    }

	    return new ResponseEntity<>(responseObjectData, responseStatusCode);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<UserDTO>> findById(@PathVariable("id") final UUID id) {

	    Response<UserDTO> responseObjectData = Response.createSuccededResponse();
	    HttpStatusCode responseStatusCode = HttpStatus.OK;

	    try {
	        var facade = new UserFacadeImpl();
	        var user = facade.findSpecificUser(id);

	        if (user != null) {
	            responseObjectData.setData(Collections.singletonList(user));
	            responseObjectData.addMessage("User fetched successfully!");
	        } else {
	            responseObjectData.setData(new ArrayList<>());
	            responseObjectData = Response.createFailedResponse();
	            responseObjectData.addMessage("No se encontró el usuario con id: " + id);
	            responseStatusCode = HttpStatus.NOT_FOUND;
	        }

	    } catch (final NoseException exception) {
	        responseObjectData = Response.createFailedResponse();
	        responseObjectData.addMessage(exception.getUserMessage());
	        responseStatusCode = HttpStatus.BAD_REQUEST;
	        exception.printStackTrace();
	    } catch (final Exception exception) {
	        var userMessage = MessagesEnum.USER_ERROR_DAO_FINDING_USER_BY_ID;
	        responseObjectData = Response.createFailedResponse();
	        responseObjectData.addMessage(userMessage.toString());
	        responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
	        exception.printStackTrace();
	    }

	    return new ResponseEntity<>(responseObjectData, responseStatusCode);
	}
	
	@PostMapping
	public ResponseEntity<Response<UserDTO>> registerNewUserInformation(@RequestBody final UserDTO user) {

	    Response<UserDTO> responseObjectData = Response.createSuccededResponse();
	    HttpStatusCode responseStatusCode = HttpStatus.CREATED;

	    try {
	        var facade = new UserFacadeImpl();
	        facade.registerNewUserInformation(user);
	        responseObjectData.addMessage("User registered successfully!");

	    } catch (final NoseException exception) {
	        responseObjectData = Response.createFailedResponse();
	        responseObjectData.addMessage(exception.getUserMessage());
	        responseStatusCode = HttpStatus.BAD_REQUEST;
	        exception.printStackTrace();
	    } catch (final Exception exception) {
	        var userMessage = MessagesEnum.USER_ERROR_FACADE_REGISTERING_USER;
	        responseObjectData = Response.createFailedResponse();
	        responseObjectData.addMessage(userMessage.toString());
	        responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
	        exception.printStackTrace();
	    }

	    return new ResponseEntity<>(responseObjectData, responseStatusCode);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Response<UserDTO>> updateUserInformation(@PathVariable("id") final UUID id, @RequestBody final UserDTO user) {

	    Response<UserDTO> responseObjectData = Response.createSuccededResponse();
	    HttpStatusCode responseStatusCode = HttpStatus.OK;

	    try {
	        var facade = new UserFacadeImpl();
	        facade.updateUserInformation(id, user);
	        responseObjectData.addMessage("User updated successfully!");

	    } catch (final NoseException exception) {
	        responseObjectData = Response.createFailedResponse();
	        responseObjectData.addMessage(exception.getUserMessage());
	        responseStatusCode = HttpStatus.BAD_REQUEST;
	        exception.printStackTrace();
	    } catch (final Exception exception) {
	        var userMessage = MessagesEnum.USER_ERROR_FACADE_UPDATING_USER;
	        responseObjectData = Response.createFailedResponse();
	        responseObjectData.addMessage(userMessage.toString());
	        responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
	        exception.printStackTrace();
	    }

	    return new ResponseEntity<>(responseObjectData, responseStatusCode);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response<UserDTO>> dropUserInformation(@PathVariable("id") final UUID id) {

	    Response<UserDTO> responseObjectData = Response.createSuccededResponse();
	    HttpStatusCode responseStatusCode = HttpStatus.OK;

	    try {
	        var facade = new UserFacadeImpl();
	        facade.dropUserInformation(id);
	        responseObjectData.addMessage("User removed successfully!");

	    } catch (final NoseException exception) {
	        responseObjectData = Response.createFailedResponse();
	        responseObjectData.addMessage(exception.getUserMessage());
	        responseStatusCode = HttpStatus.BAD_REQUEST;
	        exception.printStackTrace();
	    } catch (final Exception exception) {
	        var userMessage = MessagesEnum.USER_ERROR_FACADE_DELETING_USER;
	        responseObjectData = Response.createFailedResponse();
	        responseObjectData.addMessage(userMessage.toString());
	        responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
	        exception.printStackTrace();
	    }

	    return new ResponseEntity<>(responseObjectData, responseStatusCode);
	}

}
