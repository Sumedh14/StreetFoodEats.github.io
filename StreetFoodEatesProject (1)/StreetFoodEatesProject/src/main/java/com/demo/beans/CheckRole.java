package com.demo.beans;

public class CheckRole {
	private int roleId;
	private int userId;

	public CheckRole() {
		super();
	}

	public CheckRole(int roleId, int userId) {
		super();
		this.roleId = roleId;
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CheckRole [roleId=" + roleId + ", userId=" + userId + "]";
	}

	
}
