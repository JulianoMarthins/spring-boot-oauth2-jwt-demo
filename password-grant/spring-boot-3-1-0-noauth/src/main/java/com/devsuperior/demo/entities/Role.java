package com.devsuperior.demo.entities;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_role")
public class Role {

    // Atributos de classe
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;


    // Construtores
    public Role() {

    }

    public Role(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }


    //Equals & HashCode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;
        return Objects.equals(id, role.id) && Objects.equals(authority, role.authority);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(authority);
        return result;
    }


    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
