package com.flowers.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flowers.rest.beans.UserDetail;
import com.flowers.rest.service.IUserDetailService;

@RestController
@RequestMapping("/api/vi/")
public class UserDetailRestController {

	@Autowired
	IUserDetailService userDetailService;

	// REST endpoints that reads the JSON feed using HTTP
	@GetMapping(value = "/userDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<UserDetail>> getUserDetails() {

		List<UserDetail> listUsers = userDetailService.getUserDetails();
		return null == listUsers ? ResponseEntity.noContent().build() : ResponseEntity.ok(listUsers);

	}

	// Get the number of unique user Ids and return in a JSON response
	@GetMapping(value = "/uniqueUsers", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<UserDetail>> getUniqueUserDetails() {

		List<UserDetail> listUsers = userDetailService.getUniqueUsers();
		System.out.println(listUsers.toString());
		return null == listUsers ? ResponseEntity.noContent().build() : ResponseEntity.ok(listUsers);

	}

	// It updates 4th JSON array item and will change the title and body of the object to "1800Flowers"
	@PatchMapping(value = "/updateUserDetails/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserDetail> UpdateUserDetails(@PathVariable(name = "id") int id,
			@RequestParam String value) {

		UserDetail userDetail = userDetailService.updateUserDetailsById(id, value);
		
		System.out.println(userDetail.toString());
		return null == userDetail ? ResponseEntity.noContent().build() : ResponseEntity.ok(userDetail);

	}

}
