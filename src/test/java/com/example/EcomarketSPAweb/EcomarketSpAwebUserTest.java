package com.example.EcomarketSPAweb;

import com.example.EcomarketSPAweb.Model.Product;
import com.example.EcomarketSPAweb.Model.User;
import com.example.EcomarketSPAweb.Repository.ProductRepository;
import com.example.EcomarketSPAweb.Repository.UserRepository;
import com.example.EcomarketSPAweb.Services.ProductService;
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
class EcomarketSpAwebUserTest {

	@Autowired
	UserRepository userRepository;

	@MockitoBean
	UserService userService;

	@Test
	@DisplayName("FindAll Test")
	void testUserServiceMock () {
		List<User> users = userRepository.findAll();
		assertNotNull(users);
		//se coloca cuantos usuarios estan registrados en la base de datos//
		assertEquals(1, users.size());
	}

	@Test
	@DisplayName("Rectificar nombre usuario")
	void testFindUser(){
		User prueba = userRepository.findById(2).get();
		assertNotNull(prueba);
		//se coloca el nombre del usuario para verificar si exsite en la base de datos//
		assertEquals("usuario1", prueba.getUsername());
	}


}
