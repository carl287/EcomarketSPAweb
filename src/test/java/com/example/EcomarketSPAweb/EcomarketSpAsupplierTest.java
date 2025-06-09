package com.example.EcomarketSPAweb;

import com.example.EcomarketSPAweb.Model.Suppliers;
import com.example.EcomarketSPAweb.Model.User;
import com.example.EcomarketSPAweb.Repository.SuppliersRepository;
import com.example.EcomarketSPAweb.Repository.UserRepository;
import com.example.EcomarketSPAweb.Services.SuppliersService;
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
class EcomarketSpAsupplierTest {

	@Autowired
		SuppliersRepository suppliersRepository;

		@MockitoBean
		SuppliersService suppliersService;

	@Test
	@DisplayName("FindAll Test")
	void testSuppliersServiceMock() {
		List<Suppliers> suppliers = suppliersRepository.findAll();
		assertNotNull(suppliers);
		//se coloca cuantos proovedores estan registrados en la base de datos//
		assertEquals(1, suppliers.size());
	}

	@Test
	@DisplayName("Rectificar nombre usuario")
	void testFindSupplierEmail(){
		Suppliers prueba = suppliersRepository.findById(3).get();
		assertNotNull(prueba);
		//se coloca el correo del proovedor para verificar si exsite en la base de datos//
		assertEquals("proovedor1@correo.cl", prueba.getSupplier_email());
	}


}
