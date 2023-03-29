package ir.imorate.imotodo.security.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Objects;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 32, unique = true)
    private String username;

    @Column(nullable = false, length = 128)
    @ToString.Exclude
    private String password;

    @Column(nullable = false, length = 32, unique = true)
    private String email;

    @Column
    private Boolean accountNonExpired = Boolean.TRUE;

    @Column
    private Boolean accountNonLocked = Boolean.TRUE;

    @Column
    private Boolean credentialsNonExpired = Boolean.TRUE;

    @Column
    private Boolean enabled = Boolean.FALSE;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ToString.Exclude
    private Set<Role> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
