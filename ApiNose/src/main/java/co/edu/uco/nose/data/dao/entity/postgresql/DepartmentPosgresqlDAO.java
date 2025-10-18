package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.data.dao.entity.DepartmentDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.entity.DepartmentEntity;

public final class DepartmentPosgresqlDAO extends SqlConnection implements DepartmentDAO {
	
	public DepartmentPosgresqlDAO(final Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<DepartmentEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
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
