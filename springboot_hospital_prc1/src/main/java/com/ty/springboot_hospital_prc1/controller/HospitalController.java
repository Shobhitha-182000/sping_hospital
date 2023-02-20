package com.ty.springboot_hospital_prc1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital_prc1.dto.Hospital;
import com.ty.springboot_hospital_prc1.exception.DeleteHospitalIdNotFound;
import com.ty.springboot_hospital_prc1.exception.GetByIdHospitalIdNotFound;
import com.ty.springboot_hospital_prc1.exception.UpdateHospitalIdNotFound;
import com.ty.springboot_hospital_prc1.service.HospitalService;
import com.ty.springboot_hospital_prc1.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HospitalController {

	@Autowired
	private HospitalService service;
	
	@ApiOperation(value = "save Hospital", notes = "Api is used to create the Hospital")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created"),
			@ApiResponse(code = 404, message = "ID not found  ")

	})
	@PostMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital){
		return service.saveHospital(hospital);
	}
	
	@ApiOperation(value = "update Hospital", notes = "Api is used to update the Hospital")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully updated"),
			@ApiResponse(code = 404, message = "ID not found  ")

	})
	@PutMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestParam int id,@RequestBody Hospital hospital) throws UpdateHospitalIdNotFound{
		return service.updateHospital(id, hospital);
	}
	
	@ApiOperation(value = "delete Hospital", notes = "Api is used to delete the Hospital")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully deleted"),
			@ApiResponse(code = 404, message = "ID not found  ")

	})
	@DeleteMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(@RequestParam int id) throws DeleteHospitalIdNotFound{
		return service.deletHospital(id);
	}
	
	@ApiOperation(value = "GetById Hospital", notes = "Api is used to get the Hospital by id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Found"),
			@ApiResponse(code = 404, message = "ID not found  ")

	})
	@GetMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> getById(@RequestParam int id) throws GetByIdHospitalIdNotFound{
		return service.getById(id);
	}
}
