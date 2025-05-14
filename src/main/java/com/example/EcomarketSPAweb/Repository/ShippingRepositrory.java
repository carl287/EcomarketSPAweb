package com.example.EcomarketSPAweb.Repository;

import com.example.EcomarketSPAweb.Model.Shipping;
import com.example.EcomarketSPAweb.Model.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepositrory extends JpaRepository<Shipping, Integer> {
    @Repository
    interface SuppliersRepository extends JpaRepository<Suppliers, Integer> {
    }
}
