package com.junly.common.plugins.page;

import java.util.List;

public class Page<T>
{
  private int pageNum = 1;
  private int pageSize = 2;
  private int totalRecord;
  private int totalPage;
  private List<T> results;
  
  public int getPageNum()
  {
    return this.pageNum;
  }
  
  public void setPageNum(int pageNum)
  {
    this.pageNum = pageNum;
  }
  
  public int getPageSize()
  {
    return this.pageSize;
  }
  
  public void setPageSize(int pageSize)
  {
    this.pageSize = pageSize;
  }
  
  public int getTotalRecord()
  {
    return this.totalRecord;
  }
  
  public void setTotalRecord(int totalRecord)
  {
    this.totalRecord = totalRecord;
    
    int totalPage = totalRecord % this.pageSize == 0 ? totalRecord / this.pageSize : totalRecord / this.pageSize + 1;
    setTotalPage(totalPage);
  }
  
  public int getTotalPage()
  {
    return this.totalPage;
  }
  
  public void setTotalPage(int totalPage)
  {
    this.totalPage = totalPage;
  }
  
  public List<T> getResults()
  {
    if ((this.results != null) && (this.results.size() == 0)) {
      return null;
    }
    return this.results;
  }
  
  public void setResults(List<T> results)
  {
    this.results = results;
  }
  
  public String toString()
  {
    StringBuilder builder = new StringBuilder();
    builder.append("Page [pageNum=").append(this.pageNum).append(", pageSize=")
      .append(this.pageSize).append(", results=").append(this.results).append(
      ", totalPage=").append(this.totalPage).append(
      ", totalRecord=").append(this.totalRecord).append("]");
    return builder.toString();
  }
}
