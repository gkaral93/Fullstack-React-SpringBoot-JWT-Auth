package com.example.springbootapi.jwt;

import java.io.Serializable;

public class  JwtTokenRequest implements Serializable {
  
 
  

/**
	 * 
	 */
	private static final long serialVersionUID = -817396376107836118L;
private String username;
    private String password;

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

