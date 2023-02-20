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

import com.ty.springboot_hospital_prc1.dto.MedItems;
import com.ty.springboot_hospital_prc1.dto.MedOrder;
import com.ty.springboot_hospital_prc1.service.MedItemService;
import com.ty.springboot_hospital_prc1.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedItemController {
	@Autowired
	private MedItemService service;
	
	@ApiOperation(value = "save MedItem", notes = "Api is used to create the medItem")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created"),
			@ApiResponse(code = 404, message = "ID not found  ")

	})
	@PostMapping("/meditem")
	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(@RequestBody MedItems medItems, @RequestParam int order_id){
		return service.saveMedItems(medItems ,order_id);
	}
	
	@ApiOperation(value = "update MedItem", notes = "Api is used to update the medItem")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully updated"),
			@ApiResponse(code = 404, message = "ID not found  ")

	})
	@PutMapping("/meditem")
	public ResponseEntity<ResponseStructure<MedItems>> updateMedorder(@RequestBody MedItems meditem,@RequestParam int mid){
		return service.updateMedItems(meditem,mid);
	}
	
	@ApiOperation(value = "getById MedItem", notes = "Api is used to get the medItem by id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Found"),
			@ApiResponse(code = 404, message = "ID not found  ")

	})
	@GetMapping("/meditem")
	public ResponseEntity<ResponseStructure<MedItems>> getById(@RequestParam int mid){
		return service.getById(mid);
	}
	
	@ApiOperation(value = "delete MedItem", notes = "Api is used to delete the medItem")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully deleted"),
			@ApiResponse(code = 404, message = "ID not found  ")

	})
	@DeleteMapping("meditem")
	public ResponseEntity<ResponseStructure<MedItems>> deleteMedOder(@RequestParam int mid){
		return service.deleteMedItems(mid);
	}
}
	 

