package com.example.springbootapi.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.springbootapi.entity.Bundle;

@Repository
public interface BundleRepository extends JpaRepository <Bundle, Long>{
	
}
