package com.xiaoxiong.bean;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @ClassName: GsonBuilderBeanTwo
 * @Description: 使用注解自定义序列化字段名称
 * @author smile
 * @date 2016年5月12日 上午11:53:54
 * 
 */
public class GsonBuilderBeanTwo {
	@SerializedName("name")
	private String username;
	@SerializedName("pwd")
	private String password;

	public GsonBuilderBeanTwo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {

		String resultString = "";
		resultString += "username:" + username + "\npassword:" + password
				+ "\n";

		return resultString;
	}

}
