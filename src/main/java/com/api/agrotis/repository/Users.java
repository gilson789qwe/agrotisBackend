package com.api.agrotis.repository;

import com.api.agrotis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Users extends JpaRepository<User, Long> {
}

