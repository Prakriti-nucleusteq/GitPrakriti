package com.project.helpesk.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;



/**
 * @author opera_ao6omsd
 *
 */
/**
 * @author opera_ao6omsd
 *
 */
/**
 * @author opera_ao6omsd
 *
 */
@Entity
@Table(name = "users")

public final class User {

    /**
     * id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * String.
     */
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;
    /**
     * String last name.
     */
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    /**
     * String email.
     */
    private int employeeId;

    /**
     * @return employee id.
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId employee id.
     */
    public void setEmployeeId(final int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * role.
     */
    @Column(unique = true)
    private String email;

    /**
     *
     *
     * String.
     *
     */
    @NotEmpty
    @Pattern(regexp = "^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$", message = "Invalid Contact Number")
    private String contact;
    /**
     * String dob.
     */
    private String dob;
    /**
     * gender.
     */
    private String gender;
    /**
     * password.
     */
    @NotEmpty
    // @Pattern(regexp="^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[@$!%?&])[A-Za-z\\d@$!%?&]{8,}$",
    // message="Password Must Contain Minimum eight characters, at least one
    // uppercase letter, one lowercase letter, one number and one special
    // character")
    private String password;

    /**
     * String role.
     */
    @Transient
    private String role;

    /**
     * String city.
     */
    private String city;
    /**
     * State.
     */
    private String state;
    /**
     * String country.
     */
    private String country;
    /**
     * String designation.
     */
    private String designation;
//
//    /**
//     * @param city        city.
//     * @param state       state.
//     * @param country     country.
//     * @param designation designation.
//     */
//    public User(final String city, final String state, final String country, final String designation) {
//        super();
//        this.city = city;
//        this.state = state;
//        this.country = country;
//        this.designation = designation;
//    }

    /**
     * @return city.
     */
    public String getCity() {
        return city;
    }

    /**
     * @param id id.
     * @param firstName firstname.
     * @param lastName lastName.
     * @param employeeId employeeId.
     * @param email email.
     * @param contact contact.
     * @param dob dob.
     * @param gender gender.
     * @param password password.
     * @param role role.
     * @param city city.
     * @param state state.
     * @param country country.
     * @param designation designation.
     */
    public User(final int id, final String firstName, final String lastName, final int employeeId, final String email,
        @NotEmpty @Pattern(regexp = "^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$", message = "Invalid Contact Number") final String contact,
        final String dob, final String gender, final @NotEmpty String password, final String role, final String city, final String state, final String country,
        final String designation) {
    super();
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.employeeId = employeeId;
    this.email = email;
    this.contact = contact;
    this.dob = dob;
    this.gender = gender;
    this.password = password;
    this.role = role;
    this.city = city;
    this.state = state;
    this.country = country;
    this.designation = designation;
}

    /**
     * @param city set city.
     */
    public void setCity(final String city) {
        this.city = city;
    }

    /**
     * @return get state.
     */
    public String getState() {
        return state;
    }

    /**
     * @param state set state.
     */
    public void setState(final String state) {
        this.state = state;
    }

    /**
     * @return String country.
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
     * User.
     */
    public User() {

    }

    /**
     * @return role.
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role role.
     */
    public void setRole(final String role) {
        this.role = role;
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id set id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return firstname.
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
     * @return contact get contact.
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

}
