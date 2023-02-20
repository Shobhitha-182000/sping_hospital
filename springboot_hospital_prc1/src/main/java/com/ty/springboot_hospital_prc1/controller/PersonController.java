package com.ty.springboot_hospital_prc1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital_prc1.dto.Address;
import com.ty.springboot_hospital_prc1.dto.Person;
import com.ty.springboot_hospital_prc1.service.PersonService;
import com.ty.springboot_hospital_prc1.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PersonController {
	@Autowired
	private PersonService service;
	
	@ApiOperation(value = "save Person", notes = "Api is used to create the Person")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created"),
			@ApiResponse(code = 404, message = "ID not found  ")

	})
	@PostMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> saveHospital(@RequestBody Person person){
		return service.savePerson(person);
	}
	

	@ApiOperation(value = "Update Person", notes = "Api is used to update the Person")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created"),
			@ApiResponse(code = 404, message = "ID not found  ")

	})
	@PutMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> updateHospital(@RequestParam int id,@RequestBody Person person){
		return service.updatePerson(id, person);
	}
	

	@ApiOperation(value = "delete Person", notes = "Api is used to delete the Person")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully deleted"),
			@ApiResponse(code = 404, message = "ID not found  ")

	})
	@DeleteMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> deleteHospital(@RequestParam int id){
		return service.deletePerson(id);
	}

	@ApiOperation(value = "getById Person", notes = "Api is used to get the Person by id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Found"),
			@ApiResponse(code = 404, message = "ID not found  ")

	})
	@GetMapping("/person")
	public ResponseEntity<ResponseStructure<Person>> getById(@RequestParam int id){
		return service.getById(id);
	}
}



 
