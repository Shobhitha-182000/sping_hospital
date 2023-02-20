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

import com.ty.springboot_hospital_prc1.dto.MedOrder;
import com.ty.springboot_hospital_prc1.service.MedOrderService;
import com.ty.springboot_hospital_prc1.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedOrderController {
	@Autowired
	private MedOrderService service;
	
	@ApiOperation(value = "save medorder", notes = "Api is used to create the medorder")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created"),
			@ApiResponse(code = 404, message = "ID not found  ")

	})
	@PostMapping("/medorder")
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedorder(@RequestBody MedOrder medOrder,@RequestParam int encounterid){
		return service.saveMedorder(medOrder,encounterid);
	}
	
	@ApiOperation(value = "update medorder", notes = "Api is used to update the medorder")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully updated"),
			@ApiResponse(code = 404, message = "ID not found  ")

	})
	@PutMapping("/medorder")
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedorder(@RequestBody MedOrder medOrder,@RequestParam int mid){
		return service.updateMedorder(medOrder,mid);
	}
	
	@ApiOperation(value = "getByid medorder", notes = "Api is used to get the medorder by id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Found"),
			@ApiResponse(code = 404, message = "ID not found  ")

	})
	@GetMapping("/medorder")
	public ResponseEntity<ResponseStructure<MedOrder>> getById(@RequestParam int mid){
		return service.getById(mid);
	}
	
	@ApiOperation(value = "delete medorder", notes = "Api is used to delete the medorder")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully deleted"),
			@ApiResponse(code = 404, message = "ID not found  ")

	})
	@DeleteMapping("/medorder")
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOder(@RequestParam int mid){
		return service.deleteMedOrder(mid);
	}
}
