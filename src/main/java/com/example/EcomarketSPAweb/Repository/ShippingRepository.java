package com.example.EcomarketSPAweb.Repository;

import com.example.EcomarketSPAweb.Model.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Integer> {

}
