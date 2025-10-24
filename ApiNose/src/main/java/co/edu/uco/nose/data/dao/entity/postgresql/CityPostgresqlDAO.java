package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.entity.CityEntity;
import co.edu.uco.nose.entity.DepartmentEntity;

public final class CityPostgresqlDAO extends SqlConnection implements CityDAO {
	
	public CityPostgresqlDAO(final Connection connection) {
		super(connection);
	}
	
	@Override
	public List<CityEntity> findAll() {
	    var cities = new ArrayList<CityEntity>();
	    String sql = "SELECT id, nombre, departamento FROM public.\"Ciudad\"";

	    try (var preparedStatement = getConnection().prepareStatement(sql);
	         var resultSet = preparedStatement.executeQuery()) {

	        while (resultSet.next()) {
	            var city = new CityEntity();
	            city.setId((UUID) resultSet.getObject("id"));
	            city.setName(resultSet.getString("nombre"));
	            
	            var department = new DepartmentEntity();
	            department.setId((UUID) resultSet.getObject("departamento"));
	            city.setDepartment(department);

	            cities.add(city);
	        }

	    } catch (SQLException exception) {
	        exception.printStackTrace();
	    }

	    return cities;
	}


	@Override
	public List<CityEntity> findByFilter(CityEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CityEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
