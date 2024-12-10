package com.raksh.Spring_Boot_Rest.repository;

import com.raksh.Spring_Boot_Rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {
    // No need to implement basic CRUD methods, JpaRepository provides them
    // You can define custom queries if needed, for example:
    // List<JobPost> findByPostProfile(String postProfile);
}
