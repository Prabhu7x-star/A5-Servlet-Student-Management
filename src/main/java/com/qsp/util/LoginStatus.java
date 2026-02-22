package com.qsp.util;

public enum LoginStatus {
	VALID("valid"),INVALID("invalid");
	private String status;
	private LoginStatus(String status) {
		this.status=status;
	}
	public String getValues() {
		return this.status;
	}
}
