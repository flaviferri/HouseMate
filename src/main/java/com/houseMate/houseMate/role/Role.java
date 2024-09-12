package com.houseMate.houseMate.role;

import com.houseMate.houseMate.role.Permission;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum Role {

    VISITOR(0, Collections.emptySet()),
    ADMIN(1, Set.of(
            Permission.ADMIN_CREATED,
            Permission.ADMIN_UPDATE,
            Permission.ADMIN_DELETE,
            Permission.USER_GET,
            Permission.USER_CREATED,
            Permission.USER_UPDATE,
            Permission.USER_DELETE
    )),
    USER(2, Set.of(
            Permission.USER_GET,
            Permission.USER_CREATED,
            Permission.USER_UPDATE,
            Permission.USER_DELETE
    ));

    private final int id;
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}