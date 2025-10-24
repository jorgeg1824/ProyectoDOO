package co.edu.uco.nose.business.business.impl; 

import java.util.List; 
import java.util.UUID; 
import co.edu.uco.nose.business.assembler.entity.impl.UserEntityAssembler; 
import co.edu.uco.nose.business.business.UserBusiness; 
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.factory.DAOFactory;
import co.edu.uco.nose.entity.IdentificationTypeEntity;
import co.edu.uco.nose.entity.UserEntity; 

public final class UserBusinessImpl implements UserBusiness { 
	
	private DAOFactory daoFactory; 
	
	public UserBusinessImpl(final DAOFactory daoFactory) { 
		
		this.daoFactory = daoFactory;
	}
	
	@Override
	public void registerNewUserInformation(final UserDomain userDomain) {

	    try {
	        // 1. Validar información básica (tipo, obligatoriedad, longitud, formato)
	        var domain = ObjectHelper.getDefault(userDomain, new UserDomain(UUIDHelper.getUUIDHelper().generateNewUUID()));

	        // Validate identification type and number
	        if (domain.getIdentificationType() == null ||
	            domain.getIdentificationType().getId() == null ||
	            domain.getIdentificationType().getId().equals(UUID.fromString("00000000-0000-0000-0000-000000000000"))) {

	            var userMessage = "Tipo de identificación inválido o no informado.";
	            var techMessage = "El campo identificationType.id del UserDomain es nulo o tiene el UUID por defecto.";
	            throw NoseException.create(userMessage, techMessage);
	        }

	        if (TextHelper.isEmpty(domain.getIdentificationNumber()) ||
	            domain.getIdentificationNumber().length() > 30) {

	            var userMessage = "Número de identificación inválido o no informado.";
	            var techMessage = "El campo identificationNumber es nulo, vacío o excede la longitud máxima permitida (30).";
	            throw NoseException.create(userMessage, techMessage);
	        }

	        // Validate basic name fields (ejemplo de longitud)
	        if (TextHelper.isEmpty(domain.getFirstName()) ||
	            domain.getFirstName().length() > 100) {

	            var userMessage = "Primer nombre inválido o no informado.";
	            var techMessage = "El campo firstName es nulo, vacío o excede la longitud máxima permitida (100).";
	            throw NoseException.create(userMessage, techMessage);
	        }

	        // Email (opcional): longitud y formato simple
	        if (!TextHelper.isEmpty(domain.getEmail()) && domain.getEmail().length() > 150) {
	            var userMessage = "Correo electrónico demasiado largo.";
	            var techMessage = "El campo email excede la longitud máxima permitida (150).";
	            throw NoseException.create(userMessage, techMessage);
	        }

	        if (!TextHelper.isEmpty(domain.getEmail())) {
	            var email = domain.getEmail().trim();
	            var emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	            if (!email.matches(emailRegex)) {
	                var userMessage = "Formato de correo electrónico inválido.";
	                var techMessage = "El correo '" + email + "' no cumple el formato esperado.";
	                throw NoseException.create(userMessage, techMessage);
	            }
	        }

	        // Phone (opcional): dígitos y longitud
	        if (!TextHelper.isEmpty(domain.getPhone())) {
	            var phone = domain.getPhone().trim();
	            if (!phone.matches("^[0-9]{7,20}$")) {
	                var userMessage = "Número de teléfono móvil inválido.";
	                var techMessage = "El teléfono '" + phone + "' no cumple el formato esperado (solo dígitos, entre 7 y 20).";
	                throw NoseException.create(userMessage, techMessage);
	            }
	        }

	        // 2,3,4. Validar unicidad: identificación, correo, teléfono
	        var userDao = daoFactory.getUserDAO();

	        // (2) Check existing by identificationType + identificationNumber
	        {
	            var filterById = new UserEntity();
	            var idTypeEntity = new IdentificationTypeEntity();
	            idTypeEntity.setId(domain.getIdentificationType().getId());
	            filterById.setIdentificationType(idTypeEntity);
	            filterById.setIdentificationNumber(domain.getIdentificationNumber());

	            var foundById = userDao.findByFilter(filterById);
	            if (foundById != null && !foundById.isEmpty()) {
	                var userMessage = "Ya existe un usuario con el mismo tipo y número de identificación.";
	                var techMessage = "Se encontró al menos un usuario con tipoIdentificacion=" + domain.getIdentificationType().getId()
	                        + " y numeroIdentificacion='" + domain.getIdentificationNumber() + "'.";
	                throw NoseException.create(userMessage, techMessage);
	            }
	        }

	        // (3) Check existing by email (si fue suministrado)
	        if (!TextHelper.isEmpty(domain.getEmail())) {
	            var filterByEmail = new UserEntity();
	            filterByEmail.setEmail(domain.getEmail());

	            var foundByEmail = userDao.findByFilter(filterByEmail);
	            if (foundByEmail != null && !foundByEmail.isEmpty()) {
	                for (var e : foundByEmail) {
	                    if (!TextHelper.isEmpty(e.getEmail())
	                            && e.getEmail().equalsIgnoreCase(domain.getEmail())) {

	                        var userMessage = "Ya existe un usuario con ese correo electrónico.";
	                        var techMessage = "Se encontró un usuario con correoElectronico='" + domain.getEmail() + "'.";
	                        throw NoseException.create(userMessage, techMessage);
	                    }
	                }
	            }
	        }

	        // (4) Check existing by phone (si fue suministrado)
	        if (!TextHelper.isEmpty(domain.getPhone())) {
	            var filterByPhone = new UserEntity();
	            filterByPhone.setPhone(domain.getPhone());

	            var foundByPhone = userDao.findByFilter(filterByPhone);
	            if (foundByPhone != null && !foundByPhone.isEmpty()) {
	                for (var e : foundByPhone) {
	                    if (!TextHelper.isEmpty(e.getPhone())
	                            && e.getPhone().equals(domain.getPhone())) {

	                        var userMessage = "Ya existe un usuario con ese número de teléfono móvil.";
	                        var techMessage = "Se encontró un usuario con numeroTelefonoMovil='" + domain.getPhone() + "'.";
	                        throw NoseException.create(userMessage, techMessage);
	                    }
	                }
	            }
	        }

	        // 5. Generar un identificador para el nuevo usuario si no existe (y asegurar)
	        if (domain.getId() == null || domain.getId().equals(UUID.fromString("00000000-0000-0000-0000-000000000000"))) {
	            domain.setId(UUIDHelper.getUUIDHelper().generateNewUUID());
	        }

	        // 6. Registrar la información del nuevo usuario
	        var userEntityToCreate = UserEntityAssembler.getUserEntityAssembler().toEntity(domain);
	        userDao.create(userEntityToCreate);

	    } catch (NoseException exception) {
	        // relanzar para que la capa facade maneje rollback y mensajes
	        throw exception;
	    } catch (final Exception exception) {
	        var userMessage = MessagesEnum.USER_ERROR_DAO_CREATING_USER.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DAO_CREATING_USER.getContent();
	        throw NoseException.create(exception, userMessage, technicalMessage);
	    }
	}
	
	@Override 
	public void dropUserInformation(UUID id) { 
		// TODO Auto-generated method stub 
	} 
	
	@Override 
	public void updateUserInformation(UUID id, UserDomain userDomain) { 
		// TODO Auto-generated method stub 
	} 
	
	@Override 
	public List<UserDomain> findAllUsers() { 
		// TODO Auto-generated method stub 
		return null; 
	} 
	@Override public List<UserDomain> findUsersByFilter(UserDomain userFilters) { 
		// TODO Auto-generated method stub 
		return null; 
	} 
	
	@Override public UserDomain findSpecificUser(UUID id) { 
		// TODO Auto-generated method stub 
		return null; 
	} 
	
	@Override public void confirmPhoneNumber(UUID id, int confirmationCode) {
		// TODO Auto-generated method stub 
	} 
	
	@Override public void confirmEmail(UUID id, int confirmationCode) { 
		// TODO Auto-generated method stub 
	} 
	
	@Override public void sendPhoneNumberConfirmation(UUID id) { 
		// TODO Auto-generated method stub 
	} 
	
	@Override
	public void sendEmailConfirmation(UUID id) { 
		// TODO Auto-generated method stub 
	}

}