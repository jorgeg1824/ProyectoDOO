package co.edu.uco.nose.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "User")
public final class UserEntity {
	
	@Id
	@Column(name = "id", nullable = false, updatable = false)
	private UUID id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "identification_type_id", nullable = false)
	private IdentificationTypeEntity identificationType;
	
	@Column(name = "identification_number", nullable = false, length = 25, unique = true)
	private String identificationNumber;
	
	@Column(name = "first_name", nullable = false, length = 20)
	private String firstName;
	
	@Column(name = "middle_name", nullable = true, length = 20)
	private String middleName;
	
	@Column(name = "last_name", nullable = false, length = 20)
	private String lastName;
	
	@Column(name = "second_last_name", nullable = true, length = 20)
	private String secondLastName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id", nullable = false)
	private CityEntity residenceCity;
	
	@Column(name = "email", nullable = false, length = 250, unique = true)
	private String email;
	
	@Column(name = "phone", nullable = true, length = 20)
	private String phone;
	
	@Column(name = "email_confirmed", nullable = false)
	private boolean emailConfirmed;
	
	@Column(name = "phone_confirmed", nullable = false)
	private boolean phoneConfirmed;
	
	public UserEntity() {
	}
	
	public UserEntity(final UUID id, 
					  final IdentificationTypeEntity identificationType, 
					  final String identificationNumber, 
					  final String firstName, 
					  final String middleName, 
					  final String lastName, 
					  final String secondLastName, 
					  final CityEntity residenceCity, 
					  final String email, 
					  final String phone, 
					  final boolean emailConfirmed, 
					  final boolean phoneConfirmed) {
		setId(id);
		setIdentificationType(identificationType);
		setIdentificationNumber(identificationNumber);
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
		setSecondLastName(secondLastName);
		setResidenceCity(residenceCity);
		setEmail(email);
		setPhone(phone);
		setEmailConfirmed(emailConfirmed);
		setPhoneConfirmed(phoneConfirmed);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public IdentificationTypeEntity getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(final IdentificationTypeEntity identificationType) {
		this.identificationType = identificationType;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(final String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(final String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getSecondLastName() {
		return secondLastName;
	}

	public void setSecondLastName(final String secondLastName) {
		this.secondLastName = secondLastName;
	}

	public CityEntity getResidenceCity() {
		return residenceCity;
	}

	public void setResidenceCity(final CityEntity residenceCity) {
		this.residenceCity = residenceCity;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(final String phone) {
		this.phone = phone;
	}

	public boolean isEmailConfirmed() {
		return emailConfirmed;
	}

	public void setEmailConfirmed(final boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	public boolean isPhoneConfirmed() {
		return phoneConfirmed;
	}

	public void setPhoneConfirmed(final boolean phoneConfirmed) {
		this.phoneConfirmed = phoneConfirmed;
	}
	
}
