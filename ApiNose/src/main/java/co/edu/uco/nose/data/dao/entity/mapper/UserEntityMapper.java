package co.edu.uco.nose.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.CityEntity;
import co.edu.uco.nose.entity.CountryEntity;
import co.edu.uco.nose.entity.DepartmentEntity;
import co.edu.uco.nose.entity.IdentificationTypeEntity;
import co.edu.uco.nose.entity.UserEntity;

public final class UserEntityMapper {

    public UserEntityMapper() {
    }

    public static UserEntity map(final ResultSet rs) throws SQLException {
        var identificationType = new IdentificationTypeEntity();
        identificationType.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("idTipoIdentificacion")));
        identificationType.setName(rs.getString("nombreTipoIdentificacion"));

        var country = new CountryEntity();
        country.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("idPaisDepartamentoCiudadResidencia")));
        country.setName(rs.getString("nombrePaisDepartamentoCiudadResidencia"));

        var department = new DepartmentEntity();
        department.setCountry(country);
        department.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("idDepartamentoCiudadResidencia")));
        department.setName(rs.getString("nombreDepartamentoCiudadResidencia"));

        var city = new CityEntity();
        city.setDepartment(department);
        city.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("idCiudadResidencia")));
        city.setName(rs.getString("nombreCiudadResidencia"));

        var user = new UserEntity();
        user.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("id")));
        user.setIdentificationType(identificationType);
        user.setIdentificationNumber(rs.getString("numeroIdentificacion"));
        user.setFirstName(rs.getString("primerNombre"));
        user.setMiddleName(rs.getString("segundoNombre"));
        user.setLastName(rs.getString("primerApellido"));
        user.setSecondLastName(rs.getString("segundoApellido"));
        user.setResidenceCity(city);
        user.setEmail(rs.getString("correoElectronico"));
        user.setPhone(rs.getString("numeroTelefonoMovil"));
        user.setEmailConfirmed(rs.getBoolean("correoElectronicoConfirmado"));
        user.setPhoneConfirmed(rs.getBoolean("numeroTelefonoMovilConfirmado"));

        return user;
    }
}
