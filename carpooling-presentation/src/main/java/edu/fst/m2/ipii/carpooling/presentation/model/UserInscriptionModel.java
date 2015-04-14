package edu.fst.m2.ipii.carpooling.presentation.model;

import edu.fst.m2.ipii.carpooling.transverse.constraints.FieldMatch;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Created by Dimitri on 29/11/14.
 */
@FieldMatch.List({
    @FieldMatch(first = "password", second = "passwordConfirmation", message = "Le mot de passe doit correspondre à la confirmation"),
    @FieldMatch(first = "email", second = "emailConfirmation", message = "L'adresse email doit correspondre à la confirmation") })
public class UserInscriptionModel {



    /**
     * The login.
     */
    @NotBlank
    private String login;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    /** The email. */
    @NotBlank
    @Email
    private String email;

    /** The email confirmation. */
    @NotBlank
    @Email
    private String emailConfirmation;

    /** The password. */
    @NotBlank
    @Size(min = 7, max = 25)
    private String password;

    /** The password confirmation. */
    @NotBlank
    @Size(min = 7, max = 25)
    private String passwordConfirmation;

    /** The line3. */
    private String line3;

    /** The line1. */
    private String line1;

    /** The line2. */
    private String line2;

    /** The zip. */
    private String zip;

    /** The city. */
    private String city;



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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
     * Gets the email confirmation.
     *
     * @return the email confirmation
     */
    public String getEmailConfirmation() {
	return emailConfirmation;
    }

    /**
     * Sets the email confirmation.
     *
     * @param emailConfirmation the new email confirmation
     */
    public void setEmailConfirmation(String emailConfirmation) {
	this.emailConfirmation = emailConfirmation;
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
     * Gets the password confirmation.
     *
     * @return the password confirmation
     */
    public String getPasswordConfirmation() {
	return passwordConfirmation;
    }

    /**
     * Sets the password confirmation.
     *
     * @param passwordConfirmation the new password confirmation
     */
    public void setPasswordConfirmation(String passwordConfirmation) {
	this.passwordConfirmation = passwordConfirmation;
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
}
