package co.edu.uco.nose.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Country")
public final class CountryEntity {
	
	@Id
	@Column(name = "name", nullable = false, updatable = false)
	private UUID id;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	public CountryEntity() {
	}
	
	public CountryEntity(final UUID id, final String name) {
		setId(id);
		setName(name);
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

}
