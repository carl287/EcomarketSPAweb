package com.example.EcomarketSPAweb;

import com.example.EcomarketSPAweb.Model.Shipping;
import com.example.EcomarketSPAweb.Model.User;
import com.example.EcomarketSPAweb.Repository.ShippingRepository;
import com.example.EcomarketSPAweb.Repository.UserRepository;
import com.example.EcomarketSPAweb.Services.ShippingService;
import com.example.EcomarketSPAweb.Services.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EcomarketSpAwebShippingTest {

	@Autowired
	ShippingRepository shippingRepository;

	@MockitoBean
	ShippingService shippingService;

	@Test
	@DisplayName("FindAll Test")
	void testUserServiceMock () {
		List<Shipping> shippings = shippingRepository.findAll();
		assertNotNull(shippings);
		//se coloca cuantos usuarios estan registrados en la base de datos//
		assertEquals(1, shippings.size());
	}

	@Test
	@DisplayName("Rectificar patente de envio")
	void testFindUser(){
		//se coloca la id del patente que se quiere revisar
		Shipping prueba = shippingRepository.findById(2).get();
		assertNotNull(prueba);
		//se coloca la patente del envío para verificar si existe en la base de datos//
		assertEquals("abc123", prueba.getPatente());
	}


}
