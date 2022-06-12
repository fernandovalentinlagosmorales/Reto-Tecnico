package com.example.ControllerTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Modelo.Users;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	HttpHeaders headers = new HttpHeaders();
	
	@Test
	public void testgetuser() {
		assertThat(this.restTemplate.getForObject("https://reqres.in/api/users", String.class));
	}

    @Test
    public void testadduser() throws URISyntaxException {
    	final String baseUrl = "https://reqres.in/api/users";
    	URI uri = new URI(baseUrl);
    	Users user = new Users(9,"julio.nelson@reqres.in","Julio","Nelson","https://reqres.in/img/faces/9-image.jpg");
    	HttpEntity<Users> request = new HttpEntity<>(user, headers);
    	assertThat (this.restTemplate.postForEntity(uri, request, String.class));
    	

    }    

}
