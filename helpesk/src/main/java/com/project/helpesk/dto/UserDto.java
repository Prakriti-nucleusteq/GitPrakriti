package com.project.helpesk.dto;

import java.util.Objects;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @author opera_ao6omsd
 *
 */

public final class UserDto {

    /**
     * int.
     */
    private int id;

    /**
     * String first name.
     */
    @NotEmpty
    private String firstName;

    /**
     * String last name.
     */
    @NotEmpty
    private String lastName;

    /**
     * int employee id.
     */
    private int employeeId;

    /**
     * String.
     */
    @NotEmpty
    @Column(unique = true)
    @Pattern(regexp = ".+@.+\\.[a-z]+", message = "Invalid Email")
    private String email;
    /**
     * password.
     */
    @NotEmpty
    // @Pattern(regexp =
    // "^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[@$!%?&])[A-Za-z\\d@$!%?&]{8,}$", message =
    // "Password Must Contain Minimum eight characters, at least one uppercase
    // letter, one lowercase letter, one number and one special character")
    private String password;

    /**
     * contact.
     */
    @NotEmpty
    @Pattern(regexp = "^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$", message = "Invalid Contact Number")
    private String contact;

    /**
     * role.
     */
    @NotEmpty
    private String role;
    /**
     * dob.
     */
    @NotEmpty
    private String dob;
    /**
     * String gender.
     */
    @NotEmpty
    private String gender;
    /**
     * city.
     */
    private String city;


    /**
     * country.
     */
    private String country;
    /**
     * state.
     */
    private String state;
    /**
     * designation.
     */
    private String designation;

    /**
     * userdto.
     */
    public UserDto() {
    }

    /**
     * @param city        city.
     * @param country     country.
     * @param state       state.
     * @param designation designation.
     */
    public UserDto(final String city, final String country, final String state, final String designation) {
        super();
        this.city = city;
        this.country = country;
        this.state = state;
        this.designation = designation;
    }

    /**
     * @return city.
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city city.
     */
    public void setCity(final String city) {
        this.city = city;
    }

    /**
     * @return country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country country.
     */
    public void setCountry(final String country) {
        this.country = country;
    }

    /**
     * @return state.
     */
    public String getState() {
        return state;
    }

    /**
     * @param state state.
     */
    public void setState(final String state) {
        this.state = state;
    }

    /**
     * @return designation.
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation designation.
     */
    public void setDesignation(final String designation) {
        this.designation = designation;
    }

    /**
     * @return employee id.
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId set employee id.
     */
    public void setEmployeeId(final int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * @param id set id.
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @return email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName set first name.
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName set last name.
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return dob.
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob set dob.
     */
    public void setDob(final String dob) {
        this.dob = dob;
    }

    /**
     * @return gender.
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender set gender.
     */
    public void setGender(final String gender) {
        this.gender = gender;
    }

    /**
     * @param email set email.
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * @return password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password set password.
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @return contact.
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact set contact.
     */
    public void setContact(final String contact) {
        this.contact = contact;
    }

    /**
     * @return role.
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role set role.
     */
    public void setRole(final String role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, contact, country, designation, dob, email, employeeId, firstName, gender, id,
                lastName, password, role, state);
    }

    /**
     * boolean.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        UserDto other = (UserDto) obj;
        return Objects.equals(city, other.city) && Objects.equals(contact, other.contact)
                && Objects.equals(country, other.country) && Objects.equals(designation, other.designation)
                && Objects.equals(dob, other.dob) && Objects.equals(email, other.email)
                && employeeId == other.employeeId && Objects.equals(firstName, other.firstName)
                && Objects.equals(gender, other.gender) && id == other.id && Objects.equals(lastName, other.lastName)
                && Objects.equals(password, other.password) && Objects.equals(role, other.role)
                && Objects.equals(state, other.state);
    }
    /**
     * @param id id.
     * @param firstName firstname.
     * @param lastName lastname.
     * @param employeeId employeeId.
     * @param email email.
     * @param password password.
     * @param contact contact.
     * @param role role.
     * @param dob dob.
     * @param gender gender.
     * @param city city.
     * @param country country.
     * @param state state.
     * @param designation designation.
     */
    public UserDto(final int id, @NotEmpty final String firstName, @NotEmpty final String lastName, final int employeeId,
            @NotEmpty @Pattern(regexp = ".+@.+\\.[a-z]+", message = "Invalid Email") final String email,
            @NotEmpty final String password,
            @NotEmpty @Pattern(regexp = "^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$", message = "Invalid Contact Number")final String contact,
            @NotEmpty final String role, @NotEmpty final String dob, @NotEmpty final String gender, final String city, final String country,
            final String state, final String designation) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
        this.email = email;
        this.password = password;
        this.contact = contact;
        this.role = role;
        this.dob = dob;
        this.gender = gender;
        this.city = city;
        this.country = country;
        this.state = state;
        this.designation = designation;
    }
}
