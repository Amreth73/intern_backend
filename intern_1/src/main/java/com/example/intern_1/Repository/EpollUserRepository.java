package com.example.intern_1.Repository;


import com.example.intern_1.Model.EpollUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EpollUserRepository extends JpaRepository<EpollUsers, Integer> {
    Optional<EpollUsers> findByEmail(String email);
}