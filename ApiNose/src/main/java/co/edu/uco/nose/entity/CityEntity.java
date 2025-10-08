package co.edu.uco.nose.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "City")
public class CityEntity {
	
	@Id
	@Column(name = "id", nullable = false, updatable = false)
	private UUID id;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id", nullable = false)
	private DepartmentEntity department;
	
	public CityEntity() {
	}
	
	public CityEntity(final UUID id, final String name, final DepartmentEntity department) {
		setId(id);
		setName(name);
		setDepartment(department);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(final DepartmentEntity department) {
		this.department = department;
	}
}
