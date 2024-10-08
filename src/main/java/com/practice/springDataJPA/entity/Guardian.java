package com.practice.springDataJPA.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data @AllArgsConstructor @NoArgsConstructor
@AttributeOverrides({
    @AttributeOverride(name = "name", column = @Column(name="guardian_name")),
    @AttributeOverride(name = "email", column = @Column(name="guardian_email")),
    @AttributeOverride(name = "mobile", column = @Column(name="guardian_mobile"))  // column names must match the actual table column names in your database.
})
public class Guardian {

    private String name;
    private String email;
    private String mobile;
}
