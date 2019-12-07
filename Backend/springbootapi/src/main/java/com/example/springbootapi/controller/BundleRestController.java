package com.example.springbootapi.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.springbootapi.entity.Bundle;
import com.example.springbootapi.exception.ResourceNotFoundException;
import com.example.springbootapi.service.BundleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController // Annotation @RestController is applied to a class to mark it as a request handler, used to create REST web services
@Api(description ="Bundles Database CRUD operations")
@RequestMapping("/api")
public class BundleRestController {				
 
	@Autowired
	private BundleService bundleService;
	
	public void setBundleService(BundleService bundleService) {
		this.bundleService = bundleService;
	}

	@ApiOperation(value="View available Bundles")
	@GetMapping(value="/bundles", produces = MediaType.APPLICATION_JSON_VALUE)		//	Get All Bundles
	public List<Bundle> getBundles() {
		List<Bundle> bundles = bundleService.retrieveBundles();
		return bundles;
	}

	@ApiOperation(value="Add Bundle to database")			//Add Bundles 
	@PostMapping("/editBundle")
	public HttpStatus saveBundle(@Valid @RequestBody Bundle bundle) {
		bundleService.saveBundle(bundle);
		return HttpStatus.CREATED;
	}

	@ApiOperation(value="Delete Bundle from database")		//Delete Bundles
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteBundle/{bundleId}")
	public void deleteBundle(@PathVariable(name="bundleId")Long bundleId) throws ResourceNotFoundException {
		bundleService.deleteBundle(bundleId);
	}
	
	@ApiOperation(value="Find a Bundle by Id")								// Bundle Id Find
	@GetMapping("/getBundleById/{FindBundleById}")
	public @ResponseBody Bundle getBundles(@PathVariable(name="FindBundleById") Long FindBundleById) throws ResourceNotFoundException {
		return bundleService.getBundles(FindBundleById);
	}
	
	@ApiOperation(value="Update Bundle information")		//Update Bundle	fields
	@PutMapping("/editBundle")
	public ResponseEntity<Bundle> updateBundle(@Valid @RequestBody Bundle bundle) throws ResourceNotFoundException {
		 bundleService.updateBundle(bundle);
		 return new ResponseEntity<Bundle>(bundle, HttpStatus.OK);
		 
	}

}