package co.edu.uco.nose.entity;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.BooleanHelper;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class UserEntity {
	
	private UUID id;
	private IdentificationTypeEntity identificationType;
	private String identificationNumber;
	private String firstName;
	private String middleName;
	private String lastName;
	private String secondLastName;
	private CityEntity residenceCity;
	private String email;
	private String phone;
	private boolean emailConfirmed;
	private boolean phoneConfirmed;
	private boolean emailConfirmedIsDefaultValue;
	private boolean phoneConfirmedIsDefaultValue;
	
	public UserEntity() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setIdentificationType(new IdentificationTypeEntity());
		setIdentificationNumber(TextHelper.getDefault());
		setFirstName(TextHelper.getDefault());
		setMiddleName(TextHelper.getDefault());
		setLastName(TextHelper.getDefault());
		setSecondLastName(TextHelper.getDefault());
		setResidenceCity(new CityEntity());
		setEmail(TextHelper.getDefault());
		setPhone(TextHelper.getDefault());
		setEmailConfirmed(false);
		setEmailConfirmedIsDefaultValue(true);
		setPhoneConfirmed(false);
		setPhoneConfirmedIsDefaultValue(true);
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
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}

	public IdentificationTypeEntity getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(final IdentificationTypeEntity identificationType) {
		this.identificationType = ObjectHelper.getDefault(identificationType, new IdentificationTypeEntity());
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(final String identificationNumber) {
		this.identificationNumber = TextHelper.getDefaultWithTrim(identificationNumber);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = TextHelper.getDefaultWithTrim(firstName);
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(final String middleName) {
		this.middleName = TextHelper.getDefaultWithTrim(middleName);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = TextHelper.getDefaultWithTrim(lastName);
	}

	public String getSecondLastName() {
		return secondLastName;
	}

	public void setSecondLastName(final String secondLastName) {
		this.secondLastName = TextHelper.getDefaultWithTrim(secondLastName);
	}

	public CityEntity getResidenceCity() {
		return residenceCity;
	}

	public void setResidenceCity(final CityEntity residenceCity) {
		this.residenceCity = ObjectHelper.getDefault(residenceCity, new CityEntity());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = TextHelper.getDefaultWithTrim(email);
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(final String phone) {
		this.phone = TextHelper.getDefaultWithTrim(phone);
	}

	public boolean isEmailConfirmed() {
		return emailConfirmed;
	}

	public void setEmailConfirmed(final boolean emailConfirmed) {
		this.emailConfirmed = BooleanHelper.getDefault(emailConfirmed);
		setEmailConfirmedIsDefaultValue(false);
	}

	public boolean isPhoneConfirmed() {
		return phoneConfirmed;
	}

	public void setPhoneConfirmed(final boolean phoneConfirmed) {
		this.phoneConfirmed = phoneConfirmed;
		setPhoneConfirmedIsDefaultValue(false);
	}

	public boolean isEmailConfirmedIsDefaultValue() {
		return emailConfirmedIsDefaultValue;
	}

	private void setEmailConfirmedIsDefaultValue(boolean emailConfirmedIsDefaultValue) {
		this.emailConfirmedIsDefaultValue = emailConfirmedIsDefaultValue;
	}

	public boolean isPhoneConfirmedIsDefaultValue() {
		return phoneConfirmedIsDefaultValue;
	}

	private void setPhoneConfirmedIsDefaultValue(boolean phoneConfirmedIsDefaultValue) {
		this.phoneConfirmedIsDefaultValue = phoneConfirmedIsDefaultValue;
	}
	
}
