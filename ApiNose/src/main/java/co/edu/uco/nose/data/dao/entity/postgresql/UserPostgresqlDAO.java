package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.entity.UserDAO;
import co.edu.uco.nose.data.dao.entity.mapper.UserEntityMapper;
import co.edu.uco.nose.data.dao.entity.postgresql.builder.UserSqlBuilder;
import co.edu.uco.nose.crosscuting.helper.PreparedStatementHelper;
import co.edu.uco.nose.entity.UserEntity;

public final class UserPostgresqlDAO extends SqlConnection implements UserDAO {

    private final UserSqlBuilder sqlBuilder;
    
    public UserPostgresqlDAO(final Connection connection) {
        super(connection);
        this.sqlBuilder = new UserSqlBuilder();
        new UserEntityMapper();
    }

    @Override
    public void create(final UserEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = sqlBuilder.buildInsert();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setUserParametersForInsert(ps, entity);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw NoseException.createDaoException(e,
                    MessagesEnum.USER_ERROR_DAO_CREATING_USER,
                    MessagesEnum.TECHNICAL_ERROR_DAO_CREATING_USER);
        }
    }
    
    @Override
    public List<UserEntity> findAll() {
        final var sql = sqlBuilder.buildSelectAll();
        final var users = new ArrayList<UserEntity>();

        try (var ps = getConnection().prepareStatement(sql);
             var rs = ps.executeQuery()) {

            while (rs.next()) {
                users.add(UserEntityMapper.map(rs));
            }

        } catch (SQLException e) {
            throw NoseException.createDaoException(e,
                    MessagesEnum.USER_ERROR_DAO_FINDING_ALL_USERS,
                    MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_ALL_USERS);
        }

        return users;
    }

    @Override
    public List<UserEntity> findByFilter(final UserEntity filter) {
        final var params = new ArrayList<Object>();
        final var sql = sqlBuilder.buildSelectByFilter(filter, params);
        final var users = new ArrayList<UserEntity>();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setParameters(ps, params);

            try (var rs = ps.executeQuery()) {
                while (rs.next()) {
                    users.add(UserEntityMapper.map(rs));
                }
            }

        } catch (SQLException e) {
            throw NoseException.createDaoException(e,
                    MessagesEnum.USER_ERROR_DAO_FINDING_USER_BY_FILTER,
                    MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_USER_BY_FILTER);
        }

        return users;
    }

    @Override
    public UserEntity findById(final UUID id) {
        final var sql = sqlBuilder.buildSelectById();
        UserEntity user = null;

        try (var ps = getConnection().prepareStatement(sql)) {
            ps.setObject(1, id);

            try (var rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = UserEntityMapper.map(rs);
                }
            }
        } catch (final SQLException exception) {
            throw NoseException.createDaoException(
                    exception,
                    MessagesEnum.USER_ERROR_DAO_FINDING_USER_BY_ID,
                    MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_USER_BY_ID
            );
        }

        return user;
    }

    @Override
    public void update(final UserEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = sqlBuilder.buildUpdate();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setUserParametersForUpdate(ps, entity);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw NoseException.createDaoException(e,
                    MessagesEnum.USER_ERROR_DAO_UPDATING_USER,
                    MessagesEnum.TECHNICAL_ERROR_DAO_UPDATING_USER);
        }
    }

    @Override
    public void delete(final UUID id) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = sqlBuilder.buildDelete();

        try (var ps = getConnection().prepareStatement(sql)) {
            ps.setObject(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw NoseException.createDaoException(e,
                    MessagesEnum.USER_ERROR_DAO_DELETING_USER,
                    MessagesEnum.TECHNICAL_ERROR_DAO_DELETING_USER);
        }
    }
}
