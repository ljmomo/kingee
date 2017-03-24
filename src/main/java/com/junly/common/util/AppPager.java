/*
 * 版权所有(C) 浙江天搜科技股份有限公司2016-2020
 * Copyright 2016-2020 Zhejiang Tsou Technology Co., Ltd.
 *  
 * This software is the confidential and proprietary information of
 * Zhejiang Tsou Corporation ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Zhejiang Tsou
 */
package com.junly.common.util;

import java.io.Serializable;

/**
 * <p class="detail">
 * 功能：
 * </p>
 * 
 * @ClassName: AppPager
 * @version V1.0
 * @date 2016年4月20日
 * @author panwuhai Copyright 2016 tsou.com, Inc. All rights reserved
 */
public class AppPager implements Serializable {

    /**
     * <p class="detail">
     * 功能：serialVersionUID
     * </p>
     * 
     * @Fields serialVersionUID
     * @author panwuhai
     * @date 2016年4月20日
     */
    private static final long serialVersionUID = 2558832243642279010L;

    /** 当前第几页  app必传项 */
    private Integer           currentPage;

    // 页码， app可选项
    private Integer           pageSize;

    /** mysql 每页起始行 */
    private Integer           startRow;

    public AppPager() {
        super();
    }

    public AppPager(Integer currentPage, Integer pageSize) {
        super();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * @return startRow
     */
    public Integer getStartRow() {
        return startRow;
    }

    /**
     * @param startRow
     */
    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    /**
     * @return pageSize
     */

    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
