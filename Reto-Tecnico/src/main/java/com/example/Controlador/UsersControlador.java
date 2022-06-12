package com.example.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Services.UsersServices;
import com.example.Modelo.Users;

@RestController
public class UsersControlador {
	
	@Autowired
	private UsersServices usersservices;
	
	public UsersControlador(UsersServices usersservices) {
		super();
		this.usersservices = usersservices;
	}

	@GetMapping("/users")
	public Object getUsers() {
		return usersservices.getUsers();
	}
	
	@PostMapping("/addusers")
    public ResponseEntity<Users> create(@RequestBody(required=true)Users users){
        return new ResponseEntity<Users>(users, HttpStatus.CREATED);
    }
	
}
