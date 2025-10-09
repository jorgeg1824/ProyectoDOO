package co.edu.uco.nose.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Department")
public final class DepartmentEntity {
	
	@Id
	@Column(name = "id", nullable = false, updatable = false)
	private UUID id;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id", nullable = false)
	private CountryEntity country;
	
	public DepartmentEntity() {
	}
	
	public DepartmentEntity(final UUID id, final String name, final CountryEntity country) {
		setId(id);
		setName(name);
		setCountry(country);
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

	public CountryEntity getCountry() {
		return country;
	}
	
	public void setCountry(final CountryEntity country) {
		this.country = country;
	}
	
}
