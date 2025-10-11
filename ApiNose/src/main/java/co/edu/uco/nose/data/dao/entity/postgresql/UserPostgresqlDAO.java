package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.entity.UserDAO;
import co.edu.uco.nose.entity.UserEntity;

public final class UserPostgresqlDAO extends SqlConnection implements UserDAO {
	
	public UserPostgresqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public void create(UserEntity entity) {
		
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		final var sql = new StringBuilder();
		sql.append("INSERT INTO public.user( ");
		sql.append("");
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
			
			preparedStatement.setObject(1, entity.getId());
			preparedStatement.setObject(2, entity.getIdentificationType().getId());
			preparedStatement.setString(3, entity.getIdentificationNumber());
			preparedStatement.setString(4, entity.getFirstName());
			preparedStatement.setString(5, entity.getSecondName());
			preparedStatement.setString(6, entity.getFirstSurname());
			preparedStatement.setString(7, entity.getSecondSurname());
			preparedStatement.setObject(8, entity.getEmail());
			preparedStatement.setObject(9, entity.getPhone());
			preparedStatement.setObject(10, entity.getAddress());
			preparedStatement.setObject(11, entity.getCity().getId());
			preparedStatement.setObject(12, entity.getBirthDate());
			
			preparedStatement.executeUpdate();
			
			
		} catch (final SQLException exception) {
			var userMessage = "No se ha podido registrar la información del usuario. Por favor contacte al administrador del sistema";
			var technicalMessage = "Se ha presentado un problema inesperado mientras se intentaba registrar la información del usuario. Por favor valide la traza completa del error";
			throw NoseException.create(exception, technicalMessage, userMessage);
		} catch (final Exception exception) {
			var userMessage = "No se ha podido registrar la información del usuario. Por favor contacte al administrador del sistema";
			var technicalMessage = "Se ha presentado un problema inesperado mientras se intentaba registrar la información del usuario. Por favor valide la traza completa del error";
			throw NoseException.create(exception, technicalMessage, userMessage);
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
		sql.append("SELECT id, identificationType, identificationNumber, firstName, secondName, firstSurname, secondSurname, email, phone, address, city, birthDate ");
		sql.append("FROM public.user ");
		sql.append("WHERE id=?");
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
			
			preparedStatement.setObject(1, id);
			
			try (var resultSet = preparedStatement.executeQuery()) {
				
				if (resultSet.next()) {
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
					
					return entity;
				} else {
					return null;
				}
			}
			
			try (var resultSet = preparedStatement.executeQuery()) {
				
				if (resultSet.next()) {
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
					
					return entity;
				} else {
					return null;
				}
			}
			
			
		} catch (final SQLException exception) {
			var userMessage = "No se ha podido consultar la información del usuario. Por favor contacte al administrador del sistema";
			var technicalMessage = "Se ha presentado un problema inesperado mientras se intentaba consultar la información del usuario. Por favor valide la traza completa del error";
			throw NoseException.create(exception, technicalMessage, userMessage);
		} catch (final Exception exception) {
			var userMessage = "No se ha podido consultar la información del usuario. Por favor contacte al administrador del sistema";
			var technicalMessage = "Se ha presentado un problema inesperado mientras se intentaba consultar la información del usuario. Por favor valide la traza completa del error";
			throw NoseException.create(exception, technicalMessage, userMessage);
		}
		
	}

	@Override
	public void update(final UserEntity entity) {
		
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		final var sql = new StringBuilder();
		sql.append("UPDATE public.user ");
		sql.append("SET identificationType=?, identificationNumber=?, firstName=?, secondName=?, firstSurname=?, secondSurname=?, email=?, phone=?, address=?, city=?, birthDate=? ");
		sql.append("WHERE id=?");
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
			
			preparedStatement.setObject(1, entity.getIdentificationType().getId());
			preparedStatement.setString(2, entity.getIdentificationNumber());
			preparedStatement.setString(3, entity.getFirstName());
			preparedStatement.setString(4, entity.getSecondName());
			preparedStatement.setString(5, entity.getFirstSurname());
			preparedStatement.setString(6, entity.getSecondSurname());
			preparedStatement.setObject(7, entity.getEmail());
			preparedStatement.setObject(8, entity.getPhone());
			preparedStatement.setObject(9, entity.getAddress());
			preparedStatement.setObject(10, entity.getCity().getId());
			preparedStatement.setObject(11, entity.getBirthDate());
			preparedStatement.setObject(12, entity.getId());
			
			preparedStatement.executeUpdate();
			
			
		} catch (final SQLException exception) {
			var userMessage = "No se ha podido actualizar la información del usuario. Por favor contacte al administrador del sistema";
			var technicalMessage = "Se ha presentado un problema inesperado mientras se intentaba actualizar la información del usuario. Por favor valide la traza completa del error";
			throw NoseException.create(exception, technicalMessage, userMessage);
		} catch (final Exception exception) {
			var userMessage = "No se ha podido actualizar la información del usuario. Por favor contacte al administrador del sistema";
			var technicalMessage = "Se ha presentado un problema inesperado mientras se intentaba actualizar la información del usuario. Por favor valide la traza completa del error";
			throw NoseException.create(exception, technicalMessage, userMessage);
		}
		
	}

	@Override
	public void delete(final UUID id) {
		
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		final var sql = new StringBuilder();
		sql.append("DELETE FROM public.user ");
		sql.append("WHERE id=?");
		
		try (var preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
			
			preparedStatement.setObject(1, id);
			
			preparedStatement.executeUpdate();
			
			
		} catch (final SQLException exception) {
			var userMessage = "No se ha podido eliminar la información del usuario. Por favor contacte al administrador del sistema";
			var technicalMessage = "Se ha presentado un problema inesperado mientras se intentaba eliminar la información del usuario. Por favor valide la traza completa del error";
			throw NoseException.create(exception, technicalMessage, userMessage);
		} catch (final Exception exception) {
			var userMessage = "No se ha podido eliminar la información del usuario. Por favor contacte al administrador del sistema";
			var technicalMessage = "Se ha presentado un problema inesperado mientras se intentaba eliminar la información del usuario. Por favor valide la traza completa del error";
			throw NoseException.create(exception, technicalMessage, userMessage);
		}
		
	}

}
