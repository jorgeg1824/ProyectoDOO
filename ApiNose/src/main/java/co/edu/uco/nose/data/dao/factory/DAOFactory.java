package co.edu.uco.nose.data.dao.factory;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.CountryDAO;
import co.edu.uco.nose.data.dao.entity.DepartmentDAO;
import co.edu.uco.nose.data.dao.entity.IdentificationTypeDAO;
import co.edu.uco.nose.data.dao.entity.UserDAO;
import co.edu.uco.nose.data.dao.factory.postgresql.PostgresqlDAOFactory;

public abstract class DAOFactory {
	
	protected Connection connection; 
	protected static FactoryEnum factory = FactoryEnum.POSTGRESQL;
	
	public static DAOFactory getFactory() {
		switch (factory) {
		case POSTGRESQL:
			return new PostgresqlDAOFactory();
		
		default:
			var userMessage = "Factoría no iniciada";
			var technicalMessage = "Factoria no valida";
			throw NoseException.create(userMessage, technicalMessage);
		}

	}
	
	public abstract CityDAO getCityDAO();
	
	public abstract CountryDAO getCountryDAO();
	
	public abstract IdentificationTypeDAO getIdentificationTypeDAO();
	
	public abstract DepartmentDAO getDepartmentDAO();
	
	public abstract UserDAO getUserDAO();
	
	protected abstract void openConnection();
	
	protected final void initTransaction() {
		SqlConnectionHelper.ensureTransactionIsNotStarted(connection);
		
		try {
			connection.setAutoCommit(false);
		} catch (final SQLException exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
	}
	
	protected final void commitTransaction() {
		SqlConnectionHelper.ensureTransactionIsStarted(connection);
		
		try {
			connection.commit();
		} catch (final SQLException exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
	}
	
	protected final void rollbackTransaction() {
		SqlConnectionHelper.ensureTransactionIsStarted(connection);
		
		try {
			connection.rollback();
		} catch (final SQLException exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw NoseException.create(exception, userMessage, technicalMessage);
	}
	
	protected final void closeConnection() {
		SqlConnectionHelper.ensureConnectionIsClosed(connection);
		
		try {
			connection.close();
		} catch (final SQLException exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
	}

}
