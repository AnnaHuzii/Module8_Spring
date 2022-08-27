package com.goitcd5.module8_spring.dao.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.goitcd5.module8_spring.dao.role.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID id;
    private String email;//ADMIN admin@mail; USER user@mail
    @JsonIgnore
    private String password;//ADMIN password; USER password

    private String firstName;
    private String lastName;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
    private List<Role> roles = new ArrayList<>() ;

    public void addRoles(Role role) {
        roles.add(role);
        role.getUsers().add(this);
    }

    public void removeRoles(Role role) {
        roles.remove(role);
        role.getUsers().remove(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
