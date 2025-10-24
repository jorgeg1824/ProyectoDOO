package co.edu.uco.nose.test;

import java.util.List;

import co.edu.uco.nose.business.business.facade.impl.UserFacadeImpl;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.data.dao.factory.DAOFactory;
import co.edu.uco.nose.dto.CityDTO;
import co.edu.uco.nose.dto.IdentificationTypeDTO;
import co.edu.uco.nose.dto.UserDTO;
import co.edu.uco.nose.entity.CityEntity;
import co.edu.uco.nose.entity.IdentificationTypeEntity;

public class TestUserRegistration {

    public static void main(String[] args) {

        DAOFactory daoFactory = null;
        try {
            daoFactory = DAOFactory.getFactory();
            daoFactory.initTransaction();

            List<IdentificationTypeEntity> idTypes = daoFactory.getIdentificationTypeDAO().findAll();
            if (idTypes == null || idTypes.isEmpty()) {
                System.out.println("No identification types found in DB. Please insert at least one and retry.");
                daoFactory.rollbackTransaction();
                return;
            }
            IdentificationTypeEntity idTypeEntity = idTypes.get(0);

            // Try to find an existing city
            List<CityEntity> cities = daoFactory.getCityDAO().findAll();
            if (cities == null || cities.isEmpty()) {
                System.out.println("No cities found in DB. Please insert at least one and retry.");
                daoFactory.rollbackTransaction();
                return;
            }
            CityEntity cityEntity = cities.get(0);

            daoFactory.commitTransaction();

            // Build a UserDTO with the found ids
            var user = new UserDTO();

            var idTypeDto = new IdentificationTypeDTO();
            idTypeDto.setId(idTypeEntity.getId());
            user.setIdentificationType(idTypeDto);

            user.setIdentificationNumber("TEST-" + System.currentTimeMillis());

            user.setFirstName("Jorge");
            user.setMidedleName("Alpidio");
            user.setLastName("Garcia");
            user.setSecondLastName("Echeverri");

            var cityDto = new CityDTO();
            cityDto.setId(cityEntity.getId());
            user.setResidenceCity(cityDto);

            // Use a unique-ish email to avoid collisions
            user.setEmail("test.user+" + System.currentTimeMillis() + "@example.com");

            user.setPhone("3174664127");
            user.setEmailConfirmed(false);
            user.setPhoneConfirmed(false);

            // Call facade to register (it will open its own DAOFactory and transaction)
            var facade = new UserFacadeImpl();
            facade.registerNewUserInformation(user);

            System.out.println("Gané el semestre!!!");

        } catch (NoseException e) {
            System.out.println("NoseException (user): " + e.getUserMessage());
            System.out.println("NoseException (technical): " + e.getTechnicalMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (daoFactory != null) {
                try {
                    daoFactory.closeConnection();
                } catch (Exception ex) {
                    // ignore
                }
            }
        }
    }

}
