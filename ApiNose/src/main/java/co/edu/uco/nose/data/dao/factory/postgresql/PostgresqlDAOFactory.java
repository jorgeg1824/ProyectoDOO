package co.edu.uco.nose.data.dao.factory.postgresql;

import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.nose.crosscuting.exception.NoseException;
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

	@Override
	protected void openConnection() {
	    try {
	        String url = "jdbc:postgresql://localhost:5432/mi_basedatos"; 
	        String user = "postgres";
	        String password = "mi_contraseña"; 

	        Class.forName("org.postgresql.Driver");

	        this.connection = DriverManager.getConnection(url, user, password);

	    } catch (SQLException exception) {
	        var userMessage = "Ocurrió un error al conectar con la base de datos.";
	        var technicalMessage = "Error SQL al intentar establecer la conexión con PostgreSQL.";
	        throw NoseException.create(exception, userMessage, technicalMessage);

	    } catch (Exception exception) {
	        var userMessage = "Ocurrió un error inesperado al conectar con la base de datos.";
	        var technicalMessage = "Error general al abrir la conexión.";
	        throw NoseException.create(exception, userMessage, technicalMessage);
	    }
	}


}