package com.example.Services;

import com.example.Modelo.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Service
public class UsersServices {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Object getUsers() {
		String url = "https://reqres.in/api/users";
		return restTemplate.getForObject(url, String.class);
	}
	
	public static Object addUsers(@RequestBody Users users) {
        String url = "https://reqres.in/api/users";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url,users,Users.class);
    }
	
}
