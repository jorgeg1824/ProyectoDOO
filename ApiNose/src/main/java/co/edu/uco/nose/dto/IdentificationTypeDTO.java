package co.edu.uco.nose.dto;

import java.util.UUID;

public final class IdentificationTypeDTO {
	
	private UUID id;
	private String name;
	
	public IdentificationTypeDTO() {
		this.id = null;
		this.name = "";
	}
	
	public IdentificationTypeDTO(final UUID id, final String name) {
		this.id = id;
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
