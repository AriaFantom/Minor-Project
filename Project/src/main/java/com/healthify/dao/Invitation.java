package com.healthify.dao;
import java.time.LocalDateTime;
public class Invitation {
	
    private String doctorEmail;
    private String inviteToken;
    private LocalDateTime tokenExpiry;
    private boolean isUsed;

	public String getDoctorEmail() {
		return doctorEmail;
	}
	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}
	public String getInviteToken() {
		return inviteToken;
	}
	public void setInviteToken(String inviteToken) {
		this.inviteToken = inviteToken;
	}
	public LocalDateTime getTokenExpiry() {
		return tokenExpiry;
	}
	public void setTokenExpiry(LocalDateTime tokenExpiry) {
		this.tokenExpiry = tokenExpiry;
	}
	public boolean isUsed() {
		return isUsed;
	}
	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

}
