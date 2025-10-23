package co.edu.uco.nose.test;

import co.edu.uco.nose.business.business.facade.impl.UserFacadeImpl;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.dto.UserDTO;

public class TestUserRegistration {
	
	public static void main(String[] args) {
		
		try {
			var user = new UserDTO();
			
			// Colocar todos los parametros, menos el id
			
			var facade = new UserFacadeImpl();
			facade.registerNewUserInformation(user);
			
			System.out.println("Gané el semestre!!!");
		}catch(NoseException e) {
			System.out.println(e.getUserMessage());
			System.out.println(e.getTechnicalMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
