package com.junly.form.sys;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
public class LoginFormWeb implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotBlank(message = "用户名不能为空！")
	@Length(min = 4, max = 11, message = "用户名不能为空!")
	private String userName;
	@NotBlank(message = "passWord不能为空")
	@Length(min = 32, max = 32, message = "密码系统错误!")
	private String passWord;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
}
