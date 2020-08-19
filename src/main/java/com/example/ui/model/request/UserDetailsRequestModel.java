package com.example.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {
    @NotNull(message = "First name can't be NULL")
    private String firstName;

    @NotNull(message = "Last name can't be NULL")
    private String lastName;

    @NotNull(message = "Email name can't be NULL")
    @Email(message = "Not a valid email address ")
    private String email;

    @NotNull(message = "Password} name can't be NULL")
    @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters")
    private String password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}