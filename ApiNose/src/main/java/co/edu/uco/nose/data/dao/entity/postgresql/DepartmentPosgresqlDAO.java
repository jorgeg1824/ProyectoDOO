package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.data.dao.entity.DepartmentDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.entity.CountryEntity;
import co.edu.uco.nose.entity.DepartmentEntity;

public final class DepartmentPosgresqlDAO extends SqlConnection implements DepartmentDAO {
	
	public DepartmentPosgresqlDAO(final Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<DepartmentEntity> findAll() {
	    var departments = new ArrayList<DepartmentEntity>();
	    String sql = "SELECT id, nombre, pais FROM public.\"Departamento\"";

	    try (var preparedStatement = getConnection().prepareStatement(sql);
	         var resultSet = preparedStatement.executeQuery()) {

	        while (resultSet.next()) {
	            var department = new DepartmentEntity();
	            department.setId((UUID) resultSet.getObject("id"));
	            department.setName(resultSet.getString("nombre"));
	            
	            var country = new CountryEntity();
	            country.setId((UUID) resultSet.getObject("pais"));
	            department.setCountry(country);

	            departments.add(department);
	        }

	    } catch (SQLException exception) {
	        exception.printStackTrace();
	    }

	    return departments;
	}


	@Override
	public List<DepartmentEntity> findByFilter(DepartmentEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartmentEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
