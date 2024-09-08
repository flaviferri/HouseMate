package com.houseMate.houseMate.models;

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
import lombok.AllArgsConstructor;
import lombok.Builder;



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
    public String name;
    public String lastName;
    @Column(nullable = false, unique = true)
    public String email;
    @Column(nullable = false)
    public String password;
    public LocalDate birth_day;
    public LocalDate departure_date;
    Role role;

    public User(){}



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
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


