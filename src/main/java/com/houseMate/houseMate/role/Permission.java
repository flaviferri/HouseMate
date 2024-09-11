package com.houseMate.houseMate.role;



import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {

    //ADMIN_GET("admin:get"),
    ADMIN_CREATED("admin_created"),
    ADMIN_DELETE("admin_delete"),
    ADMIN_UPDATE("admin_update"),
    ADMIN_READ("admin_read"),
    USER_GET("user:get"),
    USER_CREATED("user_created"),
    USER_DELETE("user_delete"),
    USER_UPDATE("user_update");
    private final String permission;


}
