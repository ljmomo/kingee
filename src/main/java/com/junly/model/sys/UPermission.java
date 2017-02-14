package com.junly.model.sys;

public class UPermission
{
  private Long id;
  private String url;
  private String name;
  
  public Long getId()
  {
    return this.id;
  }
  
  public void setId(Long id)
  {
    this.id = id;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void setUrl(String url)
  {
    this.url = (url == null ? null : url.trim());
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = (name == null ? null : name.trim());
  }
}
