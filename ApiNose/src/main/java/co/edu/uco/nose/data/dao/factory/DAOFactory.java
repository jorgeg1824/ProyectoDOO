package co.edu.uco.nose.data.dao.factory;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
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
		
		if (FactoryEnum.POSTGRESQL.equals(factory)) {
			return new PostgresqlDAOFactory();
		} else {
			var userMessage = MessagesEnum.USER_ERROR_DAOFACTORY_NO_VALID_FACTORY.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DAOFACTORY_NO_VALID_FACTORY.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}

	}
	
	public abstract CityDAO getCityDAO();
	
	public abstract CountryDAO getCountryDAO();
	
	public abstract IdentificationTypeDAO getIdentificationTypeDAO();
	
	public abstract DepartmentDAO getDepartmentDAO();
	
	public abstract UserDAO getUserDAO();
	
	protected abstract void openConnection();
	
	public final void initTransaction() {
		SqlConnectionHelper.ensureTransactionIsNotStarted(connection);
		
		try {
			connection.setAutoCommit(false);
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_INITIALIZING_TRANSACTION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_INITIALIZING_TRANSACTION.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_INITIALIZING_TRANSACTION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_INITIALIZING_TRANSACTION.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
	}
	
	public final void commitTransaction() {
		SqlConnectionHelper.ensureTransactionIsStarted(connection);
		
		try {
			connection.commit();
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_COMMITING_TRANSACTION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_COMMITING_TRANSACTION.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_COMMITING_TRANSACTION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_COMMITING_TRANSACTION.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
	}
	
	public final void rollbackTransaction() {
		SqlConnectionHelper.ensureTransactionIsStarted(connection);
		
		try {
			connection.rollback();
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_ROLLING_BACK_TRANSACTION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ROLLING_BACK_TRANSACTION.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_ROLLING_BACK_TRANSACTION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_ROLLING_BACK_TRANSACTION.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
	}
	
	public final void closeConnection() {
		SqlConnectionHelper.ensureConnectionIsOpen(connection);
		
		try {
			connection.close();
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_CLOSING_CONNECTION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_CLOSING_CONNECTION.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_CLOSING_CONNECTION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_CLOSING_CONNECTION.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
	}

}
