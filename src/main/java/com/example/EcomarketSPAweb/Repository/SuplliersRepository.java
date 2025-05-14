package com.example.EcomarketSPAweb.Repository;

import com.example.EcomarketSPAweb.Model.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuplliersRepository extends JpaRepository<Suppliers, Integer> {
}
