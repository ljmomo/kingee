package com.junly.model.sys;

import java.util.Date;

public class UUser
{
  private Long id;
  private String nickname;
  private String email;
  private String pswd;
  private Date createTime;
  private Date lastLoginTime;
  private Long status;
  
  public Long getId()
  {
    return this.id;
  }
  
  public void setId(Long id)
  {
    this.id = id;
  }
  
  public String getNickname()
  {
    return this.nickname;
  }
  
  public void setNickname(String nickname)
  {
    this.nickname = (nickname == null ? null : nickname.trim());
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setEmail(String email)
  {
    this.email = (email == null ? null : email.trim());
  }
  
  public String getPswd()
  {
    return this.pswd;
  }
  
  public void setPswd(String pswd)
  {
    this.pswd = (pswd == null ? null : pswd.trim());
  }
  
  public Date getCreateTime()
  {
    return this.createTime;
  }
  
  public void setCreateTime(Date createTime)
  {
    this.createTime = createTime;
  }
  
  public Date getLastLoginTime()
  {
    return this.lastLoginTime;
  }
  
  public void setLastLoginTime(Date lastLoginTime)
  {
    this.lastLoginTime = lastLoginTime;
  }
  
  public Long getStatus()
  {
    return this.status;
  }
  
  public void setStatus(Long status)
  {
    this.status = status;
  }
}
