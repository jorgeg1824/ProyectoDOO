package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.entity.UserDAO;
import co.edu.uco.nose.entity.CityEntity;
import co.edu.uco.nose.entity.CountryEntity;
import co.edu.uco.nose.entity.DepartmentEntity;
import co.edu.uco.nose.entity.IdentificationTypeEntity;
import co.edu.uco.nose.entity.UserEntity;

public final class UserPostgresqlDAO extends SqlConnection implements UserDAO {
	
	public UserPostgresqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public void create(final UserEntity entity) {
		
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		final var sql = new StringBuilder();
		sql.append("INSERT INTO Usuario (id, tipoIdentificacion, numeroIdentificacion, primerNombre, segundoNombre, primerApellido, segundoApellido, "
				+ "ciudadResidencia, correoElectronico, numeroTelefonoMovil, correoElectronicoConfirmado, numeroTelefonoMovilConfirmado) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
			
			preparedStatement.setObject(1, entity.getId());
			preparedStatement.setObject(2, entity.getIdentificationType().getId());
			preparedStatement.setString(3, entity.getIdentificationNumber());
			preparedStatement.setString(4, entity.getFirstName());
			preparedStatement.setString(5, entity.getMiddleName());
			preparedStatement.setString(6, entity.getLastName());
			preparedStatement.setString(7, entity.getSecondLastName());
			preparedStatement.setObject(8, entity.getResidenceCity().getId());
			preparedStatement.setString(9, entity.getEmail());
			preparedStatement.setString(10, entity.getPhone());
			preparedStatement.setBoolean(11, entity.isEmailConfirmed());
			preparedStatement.setBoolean(12, entity.isPhoneConfirmed());
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_DAO_CREATING_USER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DAO_CREATING_USER.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_DAO_UNEXPECTED_ERROR_CREATING_USER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DAO_UNEXPECTED_ERROR_CREATING_USER.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		
	}

	@Override
	public List<UserEntity> findAll() {

		final var sql = new StringBuilder();
		sql.append("SELECT id, identificationType, identificationNumber, firstName, secondName, firstSurname, secondSurname, email, phone, address, city, birthDate ");
		sql.append("FROM public.user ");
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
			
			try (var resultSet = preparedStatement.executeQuery()) {
				
				var results = new java.util.ArrayList<UserEntity>();
				
				while (resultSet.next()) {
					var entity = new UserEntity();
					entity.setId((UUID) resultSet.getObject("id"));
					//entity.setIdentificationType(new IdentificationTypeEntity(resultSet.getObject("identificationType")));
					entity.setIdentificationNumber(resultSet.getString("identificationNumber"));
					entity.setFirstName(resultSet.getString("firstName"));
					entity.setSecondName(resultSet.getString("secondName"));
					entity.setFirstSurname(resultSet.getString("firstSurname"));
					entity.setSecondSurname(resultSet.getString("secondSurname"));
					entity.setEmail(resultSet.getString("email"));
					entity.setPhone(resultSet.getString("phone"));
					entity.setAddress(resultSet.getString("address"));
					//entity.setCity(new CityEntity(resultSet.getObject("city")));
					entity.setBirthDate(resultSet.getDate("birthDate").toLocalDate());
					
					results.add(entity);
				}
				
				return results;
			}
			
			
		} catch (final SQLException exception) {
			var userMessage = "No se ha podido consultar la información de los usuarios. Por favor contacte al administrador del sistema";
			var technicalMessage = "Se ha presentado un problema inesperado mientras se intentaba consultar la información de los usuarios. Por favor valide la traza completa del error";
			throw NoseException.create(exception, technicalMessage, userMessage);
		} catch (final Exception exception) {
			var userMessage = "No se ha podido consultar la información de los usuarios. Por favor contacte al administrador del sistema";
			var technicalMessage = "Se ha presentado un problema inesperado mientras se intentaba consultar la información de los usuarios. Por favor valide la traza completa del error";
			throw NoseException.create(exception, technicalMessage, userMessage);
		}
		
	}

	@Override
	public List<UserEntity> findByFilter(UserEntity filterEntity) {
		
		final var sql = new StringBuilder();
		sql.append("SELECT id, identificationType, identificationNumber, firstName, secondName, firstSurname, secondSurname, email, phone, address, city, birthDate ");
		sql.append("FROM public.user ");
		sql.append("WHERE 1=1 ");
		
		
	}

	@Override
	public UserEntity findById(final UUID id) {
		
		var user = new UserEntity();
		
		final var sql = new StringBuilder();
		sql.append("SELECT 		u.id, ");
		sql.append("	   		ti.id AS idTipoIdentificacion, ");
		sql.append("	   		ti.nombre AS nombreTipoIdentificacion, ");
		sql.append("	   		u.numeroIdentificacion, ");
		sql.append("	   		u.primerNombre, ");
		sql.append("	   		u.segundoNombre, ");
		sql.append("	   		u.primerApellido, ");
		sql.append("	   		u.segundoApellido, ");
		sql.append("	   		c.id AS idCiudadResidencia, ");
		sql.append("	   		c.nombre AS nombreCuidadResidencia, ");
		sql.append("	   		d.id AS idDepartamentoCiudadResidencia, ");
		sql.append("	   		d.nombre AS nombreDepartamentoCiudadResidencia, ");
		sql.append("	   		p.id AS idPaisDepartamentoCiudadResidencia, ");
		sql.append("	   		p.nombre AS nombrePaisDepartamentoCiudadResidencia, ");
		sql.append("	   		u.correoElectronico, ");
		sql.append("	   		u.numeroTelefonoMovil, ");
		sql.append("	   		u.correoElectronicoConfirmado, ");
		sql.append("	   		u.numeroTelefonoMovilConfirmado ");
		sql.append("FROM   		Usuario AS u ");
		sql.append("INNER JOIN  TipoIdentificacion AS ti ");
		sql.append("ON     		u.tipoIdentificacion = ti.id ");
		sql.append("INNER JOIN  Ciudad AS c ");
		sql.append("ON     		u.ciudadResidencia = c.id ");
		sql.append("INNER JOIN  Departamento AS d ");
		sql.append("ON     		c.departamento = d.id ");
		sql.append("INNER JOIN  Pais AS p ");
		sql.append("ON 			d.pais = p.id ");
		sql.append("WHERE  		u.id = ?");
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
			
			preparedStatement.setObject(1, id);
			
			try (var resultSet = preparedStatement.executeQuery()) {
				
				if (resultSet.next()) {
					
					var identificationType = new IdentificationTypeEntity();
					identificationType.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idTipoIdentificacion")));
					identificationType.setName(resultSet.getString("nombreTipoIdentificacion"));
		
					var country = new CountryEntity();
					country.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idPaisDepartamentoCiudadResidencia")));
					country.setName(resultSet.getString("nombrePaisDepartamentoCiudadResidencia"));
					
					var department = new DepartmentEntity();
					department.setCountry(country);
					department.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idDepartamentoCiudadResidencia")));
					department.setName(resultSet.getString("nombreDepartamentoCiudadResidencia"));
					
					var city = new CityEntity();
					city.setDepartment(department);
					city.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idCiudadResidencia")));
					city.setName(resultSet.getString("nombreCiudadResidencia"));
					
					user.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
					user.setIdentificationType(identificationType);
					user.setIdentificationNumber(resultSet.getString("numeroIdentificacion"));
					user.setFirstName(resultSet.getString("primerNombre"));
					user.setMiddleName(resultSet.getString("segundoNombre"));
					user.setLastName(resultSet.getString("primerApellido"));
					user.setSecondLastName(resultSet.getString("segundoApellido"));
					user.setResidenceCity(city);
					user.setEmail(resultSet.getString("correoElectronico"));
					user.setPhone(resultSet.getString("numeroTelefonoMovil"));
					user.setEmailConfirmed(resultSet.getBoolean("correoElectronicoConfirmado"));
					user.setPhoneConfirmed(resultSet.getBoolean("numeroTelefonoMovilConfirmado"));
				}
			}
			
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_DAO_FINDING_USER_BY_ID.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_USER_BY_ID.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_DAO_UNEXPECTED_ERROR_FINDING_USER_BY_ID.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DAO_UNEXPECTED_ERROR_FINDING_USER_BY_ID.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		
		return user;
	}
		

	@Override
	public void update(final UserEntity entity) {
		
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		final var sql = new StringBuilder();
		sql.append("UPDATE Usuario ");
		sql.append("SET 	tipoIdentificacion = ?, ");
		sql.append("		numeroIdentificacion = ?, ");
		sql.append("		primerNombre = ?, ");	
		sql.append("		segundoNombre = ?, ");	
		sql.append("		primerApellido = ?, ");	
		sql.append("		segundoApellido = ?, ");	
		sql.append("		ciudadResidencia = ?, ");	
		sql.append("		correoElectronico = ?, ");	
		sql.append("		numeroTelefonoMovil = ?, ");	
		sql.append("		correoElectronicoConfirmado = ?, ");	
		sql.append("		numeroTelefonoMovilConfirmado = ? ");	
		sql.append("WHERE id = ?");
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
			
			preparedStatement.setObject(1, entity.getIdentificationType().getId());
			preparedStatement.setString(2, entity.getIdentificationNumber());
			preparedStatement.setString(3, entity.getFirstName());
			preparedStatement.setString(4, entity.getMiddleName());
			preparedStatement.setString(5, entity.getLastName());
			preparedStatement.setString(6, entity.getSecondLastName());
			preparedStatement.setObject(7, entity.getResidenceCity().getId());
			preparedStatement.setString(8, entity.getEmail());
			preparedStatement.setString(9, entity.getPhone());
			preparedStatement.setBoolean(10, entity.isEmailConfirmed());
			preparedStatement.setBoolean(11, entity.isPhoneConfirmed());
			preparedStatement.setObject(12, entity.getId());
			
			preparedStatement.executeUpdate();
			
			
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_DAO_UPDATING_USER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DAO_UPDATING_USER.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_DAO_UNEXPECTED_ERROR_UPDATING_USER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DAO_UNEXPECTED_ERROR_UPDATING_USER.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		
	}

	@Override
	public void delete(final UUID id) {
		
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		final var sql = new StringBuilder();
		sql.append("DELETE FROM Usuario ");
		sql.append("WHERE id = ?");
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
			
			preparedStatement.setObject(1, id);
			
			preparedStatement.executeUpdate();
			
			
		} catch (final SQLException exception) {
	        var userMessage = MessagesEnum.USER_ERROR_DAO_DELETING_USER.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DAO_DELETING_USER.getContent();
	        throw NoseException.create(exception, userMessage, technicalMessage);
	    } catch (final Exception exception) {
	        var userMessage = MessagesEnum.USER_ERROR_DAO_UNEXPECTED_ERROR_DELETING_USER.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DAO_UNEXPECTED_ERROR_DELETING_USER.getContent();
	        throw NoseException.create(exception, userMessage, technicalMessage);
	    }
	}

}
