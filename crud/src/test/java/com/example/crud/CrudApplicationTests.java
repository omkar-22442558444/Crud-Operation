package com.example.crud;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;

@SpringBootTest
class CrudApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void testgetAllemp()throws URISyntaxException {
		System.out.println("test start");
		RestTemplate resttemplate=new RestTemplate();
		String url="http://localhost:8081/getEmp";
		URI uri=new URI(url);
		ResponseEntity<String> response=resttemplate.getForEntity(uri, String.class);
		Assertions.assertEquals(200,response.getStatusCodeValue());
		System.out.println("test end");

	}
	@Test
	public void testupdateEmp()throws URISyntaxException {
		System.out.println("test start");
		RestTemplate resttemplate=new RestTemplate();
		String url="http://localhost:8081/updateEmp";
		URI uri=new URI(url);
		ResponseEntity<String> response=resttemplate.getForEntity(uri, String.class);
		
		Assertions.assertEquals(200,response.getStatusCodeValue());
		System.out.println("test end");

	}
	@Test
	public void testdeleteEmp()throws URISyntaxException {
		System.out.println("test start");
		RestTemplate resttemplate=new RestTemplate();
		String url="http://localhost:8081/deleteEmp";
		URI uri=new URI(url);
		ResponseEntity<String> response=resttemplate.getForEntity(uri, String.class);
		
		Assertions.assertEquals(200,response.getStatusCodeValue());
		System.out.println("test end");

	}
	@Test
	public void testinsertEmp()throws URISyntaxException {
		System.out.println("test start");
		RestTemplate resttemplate=new RestTemplate();
		String url="http://localhost:8081/insertEmp";
		URI uri=new URI(url);
		ResponseEntity<String> response=resttemplate.getForEntity(uri, String.class);
		
		Assertions.assertEquals(200,response.getStatusCodeValue());
		System.out.println("test end");

	}
}
