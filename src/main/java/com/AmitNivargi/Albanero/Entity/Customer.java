package com.AmitNivargi.Albanero.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.reflect.Field;
import java.util.Date;

@Data
//@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is required")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Address is required")
    private String address;

    @Size(min = 6, max = 6, message = "Pincode should be 6 digits")
    private String pincode;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number should be 10 digits")
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotBlank(message = "City is required")
    private String city;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    private Date createdOn;

    // constructors
    public Customer() {
        createdOn = new Date();
    }


    public Object getPropertyValue(String propertyName) {
        try {
            Field field = getClass().getDeclaredField(propertyName);
            field.setAccessible(true);
            return field.get(this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }


}
