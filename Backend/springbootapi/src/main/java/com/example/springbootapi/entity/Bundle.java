package com.example.springbootapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="Bundles")
public class Bundle {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
									
	@Column(nullable = false)		// Bundle_name
    private String name;
						
    @Column(nullable = false)		// Bundle_price
    private Long price;

    @Column(nullable = false)		// Bundle_code
    private Integer code;
	
    @Column(nullable = true)		// Bundle_Expire_date
    private String expdate;
	
    @Column(nullable = true)		// Availability_date
    private String avadate;

	
	public Long getId() {    		//Getters and Setters
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getExpdate() {
		return expdate;
	}

	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}

	public String getAvadate() {
		return avadate;
	}

	public void setAvadate(String avadate) {
		this.avadate = avadate;
	}

	
	
	}
