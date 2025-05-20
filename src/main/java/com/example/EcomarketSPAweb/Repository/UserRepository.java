package com.example.EcomarketSPAweb.Repository;

import com.example.EcomarketSPAweb.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
