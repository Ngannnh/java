package com.store.snacks.java.sweet.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author ngan nnh on 5/13/2019
 * @project sweet
 */
@Document(collection = "user")
public class Role {
    @Id private String id;
    private String role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
