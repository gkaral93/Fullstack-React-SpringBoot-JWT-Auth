package com.example.springbootapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springbootapi.entity.Bundle;
import com.example.springbootapi.exception.ResourceNotFoundException;
import com.example.springbootapi.service.BundleService;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.springbootapi.repository.BundleRepository;


@Service
public class BundleServiceImpl implements BundleService{

	@Autowired
	private BundleRepository bundleRepository;

	public void setBundleRepository(BundleRepository bundleRepository) {
		this.bundleRepository = bundleRepository;
	}
	 
	public List<Bundle> retrieveBundles() {						//	Get All Bundles
		List<Bundle> bundles = bundleRepository.findAll();
		return bundles;
	}
 
	public Bundle getBundles(Long id) throws ResourceNotFoundException {	// Bundle Id Find
		Optional<Bundle> optEmp = bundleRepository.findById(id);
		if (!optEmp.isPresent()) {
			throw new ResourceNotFoundException();
		}else return optEmp.get();
	}
	
	public void saveBundle (Bundle bundle){						//Bundle Create
	  
	  bundleRepository.save(bundle);
	}
	
	public void  deleteBundle(Long bundleId) throws ResourceNotFoundException{	//Bundle Delete
		Optional<Bundle> optEmp = bundleRepository.findById(bundleId);
		if (!optEmp.isPresent()) {
			throw new ResourceNotFoundException();
		}
		else bundleRepository.deleteById(bundleId);
	}
	
 	public void updateBundle(Bundle bundle) {				//Bundle Update	
 		 bundleRepository.save(bundle);
	}

}