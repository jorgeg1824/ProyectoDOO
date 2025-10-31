package co.edu.uco.nose.business.business.facade.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.business.assembler.dto.impl.UserDTOAssembler;
import co.edu.uco.nose.business.business.facade.UserFacade;
import co.edu.uco.nose.business.business.impl.UserBusinessImpl;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.factory.DAOFactory;
import co.edu.uco.nose.dto.UserDTO;

public final class UserFacadeImpl implements UserFacade {

    @Override
    public void registerNewUserInformation(final UserDTO userDto) {

        var daoFactory = DAOFactory.getFactory();
        var business = new UserBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();

            var domain = UserDTOAssembler.getUserDTOAssembler().toDomain(userDto);
            business.registerNewUserInformation(domain);

            daoFactory.commitTransaction();

        } catch (final NoseException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();

            var userMessage = MessagesEnum.USER_ERROR_FACADE_REGISTERING_USER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACADE_REGISTERING_USER.getContent();

            throw NoseException.create(exception, userMessage, technicalMessage);

        } finally {
            daoFactory.closeConnection();
        }

    }

    @Override
    public void dropUserInformation(final UUID id) {
        var daoFactory = DAOFactory.getFactory();
        var business = new UserBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();
            business.dropUserInformation(id);
            daoFactory.commitTransaction();
        } catch (final NoseException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();

            var userMessage = MessagesEnum.USER_ERROR_FACADE_DELETING_USER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACADE_DELETING_USER.getContent();

            throw NoseException.create(exception, userMessage, technicalMessage);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void updateUserInformation(final UUID id, final UserDTO userDto) {
        var daoFactory = DAOFactory.getFactory();
        var business = new UserBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();

            var domain = UserDTOAssembler.getUserDTOAssembler().toDomain(userDto);
            business.updateUserInformation(id, domain);

            daoFactory.commitTransaction();
        } catch (final NoseException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();

            var userMessage = MessagesEnum.USER_ERROR_FACADE_UPDATING_USER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACADE_UPDATING_USER.getContent();

            throw NoseException.create(exception, userMessage, technicalMessage);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<UserDTO> findAllUsers() {
        var daoFactory = DAOFactory.getFactory();
        var business = new UserBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();
            var domains = business.findAllUsers();
            daoFactory.commitTransaction();

            var dtos = new ArrayList<UserDTO>();
            var assembler = UserDTOAssembler.getUserDTOAssembler();
            if (domains != null) {
                for (var d : domains) {
                    dtos.add(assembler.toDTO(d));
                }
            }
            return dtos;

        } catch (final NoseException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();

            var userMessage = MessagesEnum.USER_ERROR_FACADE_FINDING_ALL_USERS.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACADE_FINDING_ALL_USERS.getContent();

            throw NoseException.create(exception, userMessage, technicalMessage);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<UserDTO> findUsersByFilter(final UserDTO userFilters) {
        var daoFactory = DAOFactory.getFactory();
        var business = new UserBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();

            var filterDomain = UserDTOAssembler.getUserDTOAssembler().toDomain(userFilters);
            var domains = business.findUsersByFilter(filterDomain);

            daoFactory.commitTransaction();

            var dtos = new ArrayList<UserDTO>();
            var assembler = UserDTOAssembler.getUserDTOAssembler();
            if (domains != null) {
                for (var d : domains) {
                    dtos.add(assembler.toDTO(d));
                }
            }
            return dtos;

        } catch (final NoseException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();

            var userMessage = MessagesEnum.USER_ERROR_FACADE_FINDING_USER_BY_FILTER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACADE_FINDING_USER_BY_FILTER.getContent();

            throw NoseException.create(exception, userMessage, technicalMessage);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public UserDTO findSpecificUser(final UUID id) {
        var daoFactory = DAOFactory.getFactory();
        var business = new UserBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();

            // Reuse findUsersByFilter in business to get the specific user by id
            var filterDomain = new UserDomain();
            filterDomain.setId(id);
            var results = business.findUsersByFilter(filterDomain);

            daoFactory.commitTransaction();

            if (results == null || results.isEmpty()) {
                return null;
            }

            return UserDTOAssembler.getUserDTOAssembler().toDTO(results.get(0));

        } catch (final NoseException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();

            var userMessage = MessagesEnum.USER_ERROR_FACADE_FINDING_USER_BY_ID.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACADE_FINDING_USER_BY_ID.getContent();

            throw NoseException.create(exception, userMessage, technicalMessage);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void confirmPhoneNumber(final UUID id, final int confirmationCode) {
        var daoFactory = DAOFactory.getFactory();
        var business = new UserBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();
            business.confirmPhoneNumber(id, confirmationCode);
            daoFactory.commitTransaction();
        } catch (final NoseException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();

            var userMessage = MessagesEnum.USER_ERROR_FACADE_CONFIRMING_PHONE_NUMBER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACADE_CONFIRMING_PHONE_NUMBER.getContent();

            throw NoseException.create(exception, userMessage, technicalMessage);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void confirmEmail(final UUID id, final int confirmationCode) {
        var daoFactory = DAOFactory.getFactory();
        var business = new UserBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();
            business.confirmEmail(id, confirmationCode);
            daoFactory.commitTransaction();
        } catch (final NoseException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();

            var userMessage = MessagesEnum.USER_ERROR_FACADE_CONFIRMING_EMAIL.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACADE_CONFIRMING_EMAIL.getContent();

            throw NoseException.create(exception, userMessage, technicalMessage);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void sendPhoneNumberConfirmation(final UUID id) {
        var daoFactory = DAOFactory.getFactory();
        var business = new UserBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();
            business.sendPhoneNumberConfirmation(id);
            daoFactory.commitTransaction();
        } catch (final NoseException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();

            var userMessage = MessagesEnum.USER_ERROR_FACADE_SENDING_PHONE_CONFIRMATION.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACADE_SENDING_PHONE_CONFIRMATION.getContent();

            throw NoseException.create(exception, userMessage, technicalMessage);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void sendEmailConfirmation(final UUID id) {
        var daoFactory = DAOFactory.getFactory();
        var business = new UserBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();
            business.sendEmailConfirmation(id);
            daoFactory.commitTransaction();
        } catch (final NoseException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();

            var userMessage = MessagesEnum.USER_ERROR_FACADE_SENDING_EMAIL_CONFIRMATION.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACADE_SENDING_EMAIL_CONFIRMATION.getContent();

            throw NoseException.create(exception, userMessage, technicalMessage);
        } finally {
            daoFactory.closeConnection();
        }
    }

}
