package edu.fst.m2.ipii.carpooling.presentation.model;


import edu.fst.m2.ipii.carpooling.transverse.constraints.FieldMatch;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Created by Dimitri on 29/11/14.
 */
@FieldMatch.List({ @FieldMatch(first = "newPassword", second = "confirmation", message = "Le mot de passe doit correspondre à la confirmation") })
public class UserModificationModel {

    /**
     * The login.
     */
    @NotBlank
    private String login;

    /** The email. */
    @NotBlank
    @Email
    private String email;

    /** The previous password. */
    @NotBlank
    @Size(min = 7, max = 25)
    private String password;

    /**
     * The password.
     */
    private String newPassword;

    /** The confirmation. */
    private String confirmation;

    /** The address id. */
    private int addressId;

    /** The line3. */
    private String line3;

    /** The zip. */
    private String zip;

    /** The line1. */
    private String line1;

    /** The line2. */
    private String line2;

    /** The city. */
    private String city;

    /**
     * Instantiates a new user modification model.
     */
    public UserModificationModel() {

    }

    /**
     * Instantiates a new user modification model.
     *
     * @param userDto the user dto
     */
    public UserModificationModel(UserDto userDto) {
        this.login = userDto.getLogin();
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();
        this.addressId = userDto.getMailingAddress().getId();
        this.line2 = userDto.getMailingAddress().getLine2();
        this.line1 = userDto.getMailingAddress().getLine1();
        this.line3 = userDto.getMailingAddress().getLine3();
        this.zip = userDto.getMailingAddress().getZip();
        this.city = userDto.getMailingAddress().getCity();
    }

    /**
     * Gets the login.
     *
     * @return the login
     */
    public String getLogin() {
	return login;
    }

    /**
     * Sets the login.
     *
     * @param login the new login
     */
    public void setLogin(String login) {
	this.login = login;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
	return email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
	this.email = email;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
	return password;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
	this.password = password;
    }

    /**
     * Gets the confirmation.
     *
     * @return the confirmation
     */
    public String getConfirmation() {
	return confirmation;
    }

    /**
     * Sets the confirmation.
     *
     * @param confirmation the new confirmation
     */
    public void setConfirmation(String confirmation) {
	this.confirmation = confirmation;
    }

    /**
     * Gets the line3.
     *
     * @return the line3
     */
    public String getLine3() {
	return line3;
    }

    /**
     * Sets the line3.
     *
     * @param line3 the new line3
     */
    public void setLine3(String line3) {
	this.line3 = line3;
    }

    /**
     * Gets the zip.
     *
     * @return the zip
     */
    public String getZip() {
	return zip;
    }

    /**
     * Sets the zip.
     *
     * @param zip the new zip
     */
    public void setZip(String zip) {
	this.zip = zip;
    }

    /**
     * Gets the line1.
     *
     * @return the line1
     */
    public String getLine1() {
	return line1;
    }

    /**
     * Sets the line1.
     *
     * @param line1 the new line1
     */
    public void setLine1(String line1) {
	this.line1 = line1;
    }

    /**
     * Gets the line2.
     *
     * @return the line2
     */
    public String getLine2() {
	return line2;
    }

    /**
     * Sets the line2.
     *
     * @param line2 the new line2
     */
    public void setLine2(String line2) {
	this.line2 = line2;
    }

    /**
     * Gets the city.
     *
     * @return the city
     */
    public String getCity() {
	return city;
    }

    /**
     * Sets the city.
     *
     * @param city the new city
     */
    public void setCity(String city) {
	this.city = city;
    }

    /**
     * Gets the address id.
     *
     * @return the address id
     */
    public int getAddressId() {
	return addressId;
    }

    /**
     * Sets the address id.
     *
     * @param addressId the new address id
     */
    public void setAddressId(int addressId) {
	this.addressId = addressId;
    }

    /**
     * Gets the new password.
     *
     * @return the newPassword
     */
    public String getNewPassword() {
	return newPassword;
    }

    /**
     * Sets the new password.
     *
     * @param newPassword the newPassword to set
     */
    public void setNewPassword(String newPassword) {
	this.newPassword = newPassword;
    }

}
