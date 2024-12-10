package com.raksh.Spring_Boot_Rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data  // Automatically generates getters, setters, and other boilerplate code.
@Entity  // Mark this class as a JPA entity
@Component
public class JobPost {

    @Id  // Mark this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate the ID value
    private int postId;

    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;

}
