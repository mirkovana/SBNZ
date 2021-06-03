package com.example.SBNZApp.dto;


//DTO koji enkapsulira generisani JWT i njegovo trajanje koji se vracaju klijentu
public class UserTokenStateDTO {

 private String accessToken;
 private Long expiresIn;
 private Long idUser;

 public UserTokenStateDTO() {
     this.accessToken = null;
     this.expiresIn = null;
     this.idUser = null;
 }

 public UserTokenStateDTO(String accessToken, long expiresIn, long idUser) {
     this.accessToken = accessToken;
     this.expiresIn = expiresIn;
     this.idUser = idUser;
 }

 public String getAccessToken() {
     return accessToken;
 }

 public void setAccessToken(String accessToken) {
     this.accessToken = accessToken;
 }

 public Long getExpiresIn() {
     return expiresIn;
 }

 public void setExpiresIn(Long expiresIn) {
     this.expiresIn = expiresIn;
 }

public Long getIdUser() {
	return idUser;
}

public void setIdUser(Long idUser) {
	this.idUser = idUser;
}
}
