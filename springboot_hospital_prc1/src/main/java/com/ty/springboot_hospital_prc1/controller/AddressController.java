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
import com.ty.springboot_hospital_prc1.dto.Hospital;
import com.ty.springboot_hospital_prc1.exception.DeleteAddressIdNotFound;
import com.ty.springboot_hospital_prc1.exception.GetByIdAddressIdNotFound;
import com.ty.springboot_hospital_prc1.exception.UpdateAddressIdNotFound;
import com.ty.springboot_hospital_prc1.service.AddressService;
import com.ty.springboot_hospital_prc1.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AddressController {
	@Autowired
	private AddressService service;
	@ApiOperation(value = "save address", notes = "Api is used to save the address")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created"),
	})
	@PostMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> saveHospital(@RequestBody Address address){
		return service.saveAddress(address);
	}
	@ApiOperation(value = "update address", notes = "Api is used to update the address")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully updated"),
	})
	@PutMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> updateHospital(@RequestParam int id,@RequestBody Address address) throws UpdateAddressIdNotFound{
		return service.updatAddress(address, id);
	}
	@ApiOperation(value = "delete address", notes = "Api is used to delete the address")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully deleted"),
	})
	@DeleteMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> deleteHospital(@RequestParam int id) throws DeleteAddressIdNotFound{
		return service.deleteAddress(id);
	}
	
	@ApiOperation(value = "getById address", notes = "Api is used to get the address")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created"),
	})
	@GetMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> getById(@RequestParam int id) throws GetByIdAddressIdNotFound{
		return service.getById(id);
	}
}
