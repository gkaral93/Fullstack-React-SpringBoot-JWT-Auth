package com.example.springbootapi.service;


import java.util.List;


import com.example.springbootapi.entity.Bundle;
import com.example.springbootapi.exception.ResourceNotFoundException;

public interface BundleService {
	
	 public List<Bundle> retrieveBundles();
	 public void saveBundle(Bundle bundle);
	 public void deleteBundle(Long bundleId) throws ResourceNotFoundException;
	 public void updateBundle(Bundle bundle);
	 public Bundle getBundles (Long id) throws ResourceNotFoundException;
	
}
