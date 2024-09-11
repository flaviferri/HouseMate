package com.houseMate.houseMate.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.houseMate.houseMate.role.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.validation.constraints.*;


@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name="app_user")
public class User extends BaseEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Column(nullable = false)
    @NotEmpty(message = "The full name is required.")
    public String name;
    public String lastName;

    @NotEmpty(message = "The email address is required.")
    @Email(message = "The email address is invalid.", flags = { Pattern.Flag.CASE_INSENSITIVE })
    @Column(nullable = false, unique = true)
    private String email;

    @NotEmpty(message = "The password is required.")
    @Column(nullable = false)
    public String password;

    @NotNull(message = "The date of birth is required.")
    @Past(message = "The date of birth must be in the past.")
    public LocalDate birth_day;
    public LocalDate departure_date;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Flat> flats;

     Role role;

    public User(){
        this.role = Role.USER;
    }




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}


