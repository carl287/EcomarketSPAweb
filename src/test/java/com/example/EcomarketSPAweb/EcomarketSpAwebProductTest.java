package com.example.EcomarketSPAweb;

import com.example.EcomarketSPAweb.Model.GestionProduct;
import com.example.EcomarketSPAweb.Model.Product;
import com.example.EcomarketSPAweb.Repository.GestionProductRepository;
import com.example.EcomarketSPAweb.Repository.ProductRepository;
import com.example.EcomarketSPAweb.Services.GestionProductService;
import com.example.EcomarketSPAweb.Services.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EcomarketSpAwebProductTest {

	@Autowired
	ProductRepository productRepository;

	@MockitoBean
	ProductService productService;

	@Test
	@DisplayName("FindAll Test")
	void testProductServiceMock() {
		List<Product> productos = productRepository.findAll();
		assertNotNull(productos);
		assertEquals(3, productos.size());
	}

	@Test
	@DisplayName("Rectificar precio producto")
	void testFindProduct(){
		Product prueba = productRepository.findById(1).get();
		assertNotNull(prueba);
		assertEquals(1990,prueba.getPrice());
	}

}
