package com.valerio.nu.springdatajpa.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity(name = "Users")
@NamedQuery(name = "User.findByTheUsersName", query = "from Users u where u.username = ?1")
public class User extends AbstractPersistable<Long> {

    private static final long serialVersionUID = -2952735933715107252L;

    @Column(unique = true) private String username;

    private String firstname;
    private String lastname;

    public User() {
        this(null);
    }

    /**
     * Creates a new user instance.
     */
    public User(Long id) {
        this.setId(id);
    }

    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * Returns the username.
     *
     * @return
     */
    public String getUsername() {

        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
