package com.houseMate.houseMate.role;

import com.houseMate.houseMate.role.Permission;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public enum Role {

    VISITOR(Collections.emptySet()),
    ADMIN(
            Set.of(
                    Permission.ADMIN_GET,
                    Permission.ADMIN_CREATED,
                    Permission.ADMIN_UPDATE,
                    Permission.ADMIN_DELETE,
                    Permission.USER_GET,
                    Permission.USER_CREATED,
                    Permission.USER_UPDATE,
                    Permission.USER_DELETE
            )
    ),
    USER(
            Set.of(
                    Permission.USER_GET,
                    Permission.USER_CREATED,
                    Permission.USER_UPDATE,
                    Permission.USER_DELETE
            )
    );

    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .toList();

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}