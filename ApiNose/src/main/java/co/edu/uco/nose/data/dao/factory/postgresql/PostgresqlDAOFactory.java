package co.edu.uco.nose.data.dao.factory.postgresql;

import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.CountryDAO;
import co.edu.uco.nose.data.dao.entity.DepartmentDAO;
import co.edu.uco.nose.data.dao.entity.IdentificationTypeDAO;
import co.edu.uco.nose.data.dao.entity.UserDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.CityPostgresqlDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.CountryPostgresqlDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.DepartmentPosgresqlDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.IdentificationTypePosgresqlDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.UserPostgresqlDAO;
import co.edu.uco.nose.data.dao.factory.DAOFactory;

public final class PostgresqlDAOFactory extends DAOFactory {
	
	public PostgresqlDAOFactory() {
		openConnection();
	}
	
	@Override
	protected void openConnection() {
	    try {
	        String url = "jdbc:postgresql://localhost:5432/DOO"; 
	        String user = "postgres";
	        String password = "jorgealpidio1442"; 

	        Class.forName("org.postgresql.Driver");

	        this.connection = DriverManager.getConnection(url, user, password);

	    } catch (final SQLException exception) {
	        var userMessage = MessagesEnum.USER_ERROR_OPENING_CONNECTION.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_OPENING_CONNECTION.getContent();
	        throw NoseException.create(exception, userMessage, technicalMessage);

	    } catch (final Exception exception) {
	        var userMessage = MessagesEnum.USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_OPENING_CONNECTION.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_OPENING_CONNECTION.getContent();
	        throw NoseException.create(exception, userMessage, technicalMessage);
	    }
	}

	@Override
	public CityDAO getCityDAO() {
		return new CityPostgresqlDAO(connection);
	}

	@Override
	public CountryDAO getCountryDAO() {
		return new CountryPostgresqlDAO(connection);
	}

	@Override
	public IdentificationTypeDAO getIdentificationTypeDAO() {
		return new IdentificationTypePosgresqlDAO(connection);
	}

	@Override
	public DepartmentDAO getDepartmentDAO() {
		return new DepartmentPosgresqlDAO(connection);
	}

	@Override
	public UserDAO getUserDAO() {
		return new UserPostgresqlDAO(connection);
	}

}