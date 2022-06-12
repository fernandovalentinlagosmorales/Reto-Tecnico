package com.example.ServiceTest;

import static org.junit.Assert.assertNotNull;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.modelo.Users;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestService {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testgetuser() {
		ResponseEntity<Users> result=restTemplate.getForEntity("https://reqres.in/api/users", Users.class);
		assertNotNull(result);
	}

	@Test
	public void testpostuser() throws URISyntaxException {
		URI uri = new URI("https://reqres.in/api/users");
		Users user = new Users(9,"julio.nelson@reqres.in","Julio","Nelson","https://reqres.in/img/faces/9-image.jpg");

		HttpEntity<Users> request = new HttpEntity<>(user, headers);
		ResponseEntity<Users> responseEntity = this.restTemplate.postForEntity(uri, request, Users.class);
		Assert.assertEquals(201, responseEntity.getStatusCodeValue());
	}
}
