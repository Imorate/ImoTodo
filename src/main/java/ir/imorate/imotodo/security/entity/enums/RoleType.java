package ir.imorate.imotodo.security.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleType {

    ROLE_USER("User"),
    ROLE_ADMIN("Admin");

    private final String title;

}
