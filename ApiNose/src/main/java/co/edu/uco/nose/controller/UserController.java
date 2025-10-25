package co.edu.uco.nose.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping
	public String registerNewUserInformation() {
		return "POST: User registered!";
	}
	
	@PutMapping
	public String updateUserInformation() {
		return "UPDATE: User updated!";
	}
	
	@DeleteMapping
	public String dropUserInformation() {
		return "DELETE: User deleted";
	}

}
