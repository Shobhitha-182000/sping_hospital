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

import com.ty.springboot_hospital_prc1.dto.Encounter;
import com.ty.springboot_hospital_prc1.exception.DeleteEncounterIdNotFound;
import com.ty.springboot_hospital_prc1.exception.GetByIdEncounterIdNotFound;
import com.ty.springboot_hospital_prc1.service.EncounterService;
import com.ty.springboot_hospital_prc1.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EncounterController {
	@Autowired
	private EncounterService service;
	@ApiOperation(value = "save Encounter", notes = "Api is used to save the encounter")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created"),
			@ApiResponse(code = 404, message = "ID not found or given person or branch")

	})
	@PostMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@RequestBody Encounter encounter,@RequestParam int personid,int branchid){
		return service.saveEncounter(encounter, personid, branchid);
	}
	@ApiOperation(value = "update Encounter", notes = "Api is used to update the encounter")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully updated"),
			@ApiResponse(code = 404, message = "ID not found or given person or branch")

	})
	@PutMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@RequestBody Encounter encounter,@RequestParam int encounterid,int branchid){
		return service.updateEncounter(encounter, encounterid, branchid);
	}
	
	@ApiOperation(value = "delete Encounter", notes = "Api is used to delete the encounter")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully deleted"),
			@ApiResponse(code = 404, message = "ID not found or given person or branch")

	})
	@DeleteMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(@RequestParam int id) throws DeleteEncounterIdNotFound{
		return service.deleteEncounter(id);
	}
	
	@ApiOperation(value = "getById Encounter", notes = "Api is used to get the encounter by the id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully found"),
			@ApiResponse(code = 404, message = "ID not found or given person or branch")

	})
	@GetMapping("/encounter")
	public ResponseEntity<ResponseStructure<Encounter>> getById(int id) throws GetByIdEncounterIdNotFound{
		return service.getById( id);
	}
}
