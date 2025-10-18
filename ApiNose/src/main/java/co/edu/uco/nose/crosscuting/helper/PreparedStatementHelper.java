package co.edu.uco.nose.crosscuting.helper;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import co.edu.uco.nose.entity.UserEntity;

public final class PreparedStatementHelper {

    private PreparedStatementHelper() {
    }

    public static void setParameters(final PreparedStatement ps, final List<Object> params) throws SQLException {
        for (int i = 0; i < params.size(); i++) {
            ps.setObject(i + 1, params.get(i));
        }
    }
    
    public static void setUserParametersForInsert(final PreparedStatement ps, final UserEntity entity) throws SQLException {
        ps.setObject(1, entity.getId());
        ps.setObject(2, entity.getIdentificationType().getId()); 
        ps.setString(3, entity.getIdentificationNumber());
        ps.setString(4, entity.getFirstName());
        ps.setString(5, entity.getMiddleName());
        ps.setString(6, entity.getLastName());
        ps.setString(7, entity.getSecondLastName());
        ps.setObject(8, entity.getResidenceCity().getId());
        ps.setString(9, entity.getEmail());
        ps.setString(10, entity.getPhone());
        ps.setBoolean(11, entity.isEmailConfirmed());
        ps.setBoolean(12, entity.isPhoneConfirmed());
    }
    
    public static void setUserParametersForUpdate(final PreparedStatement ps, final UserEntity entity) throws SQLException {
        ps.setObject(1, entity.getIdentificationType().getId());
        ps.setString(2, entity.getIdentificationNumber());
        ps.setString(3, entity.getFirstName());
        ps.setString(4, entity.getMiddleName());
        ps.setString(5, entity.getLastName());
        ps.setString(6, entity.getSecondLastName());
        ps.setObject(7, entity.getResidenceCity().getId());
        ps.setString(8, entity.getEmail());
        ps.setString(9, entity.getPhone());
        ps.setBoolean(10, entity.isEmailConfirmed());
        ps.setBoolean(11, entity.isPhoneConfirmed());
        ps.setObject(12, entity.getId());
    }
}
