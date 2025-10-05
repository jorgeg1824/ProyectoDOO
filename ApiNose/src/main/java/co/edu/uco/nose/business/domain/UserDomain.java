package co.edu.uco.nose.business.domain;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.BooleanHelper;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class UserDomain extends Domain {
	
	private IdentificationTypeDomain identificationType;
	private String identificationNumber;
	private String firstName;
	private String midedleName;
	private String lastName;
	private String secondLastName;
	private CityDomain residenceCity;
	private String email;
	private String phone;
	private boolean emailConfirmed;
	private boolean phoneConfirmed;
	
	public UserDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setIdentificationType(new IdentificationTypeDomain());
		setIdentificationNumber(TextHelper.getDefault());
		setFirstName(TextHelper.getDefault());
		setMidedleName(TextHelper.getDefault());
		setLastName(TextHelper.getDefault());
		setSecondLastName(TextHelper.getDefault());
		setResidenceCity(new CityDomain());
		setEmail(TextHelper.getDefault());
		setPhone(TextHelper.getDefault());
		setEmailConfirmed(BooleanHelper.getDefault());
		setPhoneConfirmed(BooleanHelper.getDefault());
	}
	
	public UserDomain(final UUID id) {
		super(id);
		setIdentificationType(new IdentificationTypeDomain());
		setIdentificationNumber(TextHelper.getDefault());
		setFirstName(TextHelper.getDefault());
		setMidedleName(TextHelper.getDefault());
		setLastName(TextHelper.getDefault());
		setSecondLastName(TextHelper.getDefault());
		setResidenceCity(new CityDomain());
		setEmail(TextHelper.getDefault());
		setPhone(TextHelper.getDefault());
		setEmailConfirmed(BooleanHelper.getDefault());
		setPhoneConfirmed(BooleanHelper.getDefault());
	}
	
	public UserDomain(final UUID id, 
					  final IdentificationTypeDomain identificationType, 
					  final String identificationNumber, 
					  final String firstName, 
					  final String midedleName, 
					  final String lastName, 
					  final String secondLastName, 
					  final CityDomain residenceCity, 
					  final String email, 
					  final String phone, 
					  final boolean emailConfirmed, 
					  final boolean phoneConfirmed) {
		super(id);
		setIdentificationType(identificationType);
		setIdentificationNumber(identificationNumber);
		setFirstName(firstName);
		setMidedleName(midedleName);
		setLastName(lastName);
		setSecondLastName(secondLastName);
		setResidenceCity(residenceCity);
		setEmail(email);
		setPhone(phone);
		setEmailConfirmed(emailConfirmed);
		setPhoneConfirmed(phoneConfirmed);
	}

	public IdentificationTypeDomain getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(final IdentificationTypeDomain identificationType) {
		this.identificationType = ObjectHelper.getDefault(identificationType, new IdentificationTypeDomain());
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

	public void setFirstName(String firstName) {
		this.firstName = TextHelper.getDefaultWithTrim(firstName);
	}

	public String getMidedleName() {
		return midedleName;
	}

	public void setMidedleName(String midedleName) {
		this.midedleName = TextHelper.getDefaultWithTrim(midedleName);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = TextHelper.getDefaultWithTrim(lastName);
	}

	public String getSecondLastName() {
		return secondLastName;
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName = TextHelper.getDefaultWithTrim(secondLastName);
	}

	public CityDomain getResidenceCity() {
		return residenceCity;
	}

	public void setResidenceCity(CityDomain residenceCity) {
		this.residenceCity = ObjectHelper.getDefault(residenceCity, new CityDomain());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = TextHelper.getDefaultWithTrim(email);
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = TextHelper.getDefaultWithTrim(phone);
	}

	public boolean isEmailConfirmed() {
		return emailConfirmed;
	}

	public void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = BooleanHelper.getDefault(emailConfirmed);
	}

	public boolean isPhoneConfirmed() {
		return phoneConfirmed;
	}

	public void setPhoneConfirmed(boolean phoneConfirmed) {
		this.phoneConfirmed = BooleanHelper.getDefault(phoneConfirmed);
	}
	
}
