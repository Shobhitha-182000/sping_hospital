package com.ty.springboot_hospital_prc1.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital_prc1.dto.Branch;
import com.ty.springboot_hospital_prc1.dto.Hospital;
import com.ty.springboot_hospital_prc1.exception.DeleteBranchIdNotFound;
import com.ty.springboot_hospital_prc1.exception.GetByIdBranchIdNotFound;
import com.ty.springboot_hospital_prc1.exception.UpdateBranchIdNotFound;
import com.ty.springboot_hospital_prc1.service.BranchService;
import com.ty.springboot_hospital_prc1.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Value;

@RestController
public class BranchController {
	@Autowired
	private BranchService service;

	@ApiOperation(value = "save branch", notes = "Api is used to save the branch")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created"),
			@ApiResponse(code = 404, message = "ID not found or given hospital or address")

	})
	@PostMapping("/branch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch, @RequestParam int hid,
			@RequestParam int aid) {
		return service.saveBranch(branch, hid, aid);
	}

	@ApiOperation(value = "update branch", notes = "Api is used upate the branch")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully updated"),
			@ApiResponse(code = 404, message = "ID not found or given hospital or address")

	})

	@PutMapping("/branch/{id}")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestBody Branch branch, @PathVariable int id) throws UpdateBranchIdNotFound {
		return service.updateBranch(id, branch);
	}

	@ApiOperation(value = "get By Id ", notes = "Api is used get the branch by id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully ound"),
			@ApiResponse(code = 404, message = "ID not found or given hospital or address") })
	@GetMapping("/branch/{id}")
	public ResponseEntity<ResponseStructure<Branch>> getByIdBranch(@PathVariable int id) throws GetByIdBranchIdNotFound {
		return service.getById(id);
	}

	@ApiOperation(value = "Delete By Id ", notes = "Api is used delete the branch")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Deleted"),
			@ApiResponse(code = 404, message = "ID not found or given hospital or address") })
	@DeleteMapping("/branch/{id}")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@PathVariable int id) throws DeleteBranchIdNotFound {
		return service.deleteBranch(id);
	}

	@ApiOperation(value = "getAll ", notes = "Api is used select all  branch")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Found"),
			@ApiResponse(code = 404, message = "ID not found or given hospital or address") })
	@GetMapping("/getall")
	public ResponseEntity<ResponseStructure<List<Branch>>> getByHospital(@RequestParam int hid) {
		return service.getByHospital(hid);
	}

}
