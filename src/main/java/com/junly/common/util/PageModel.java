/*
 * 版权所有(C) lijun2016-2020
 * Copyright 2016-2020 Zhejiang lijun Technology Co., Ltd.
 *  
 * This software is the confidential and proprietary information of
 * Zhejiang lijun Corporation ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Zhejiang lijun
 */
package com.junly.common.util;

import java.io.Serializable;

/** <p class="detail">
 * 功能：web端分页的结果数据对象
 * </p>
 * @ClassName: PageModel 
 * @version V1.0  
 * @date 2016年4月26日 
 * @author panwuhai
 * Copyright 2016 lijun.com, Inc. All rights reserved
 */
public class PageModel implements Serializable {

    /** 
     * <p class="detail">
     * 功能：
     * </p>
     * @Fields serialVersionUID 
     * @author panwuhai
     * @date 2016年4月26日
     */
    private static final long serialVersionUID = 423511444957574274L;

    public PageModel(Pager pager, Object dataList) {
        super();
        this.pager = pager;
        this.dataList = dataList;
    }

    /** 
     * <p class="detail">
     * 功能：前端需要的分页参数
     * </p>
     * @Fields pager 
     * @author panwuhai
     * @date 2016年4月26日
     */
    private Pager  pager;

    /** 
     * <p class="detail">
     * 功能：实际的列表数据
     * </p>
     * @Fields obj 
     * @author panwuhai
     * @date 2016年4月26日
     */
    private Object dataList;

    /**
     * @return pager
     */

    public Pager getPager() {
        return pager;
    }

    /**
     * @param pager
     */
    public void setPager(Pager pager) {
        this.pager = pager;
    }

    /**
     * @return dataList
     */

    public Object getDataList() {
        return dataList;
    }

    /**
     * @param dataList
     */
    public void setDataList(Object dataList) {
        this.dataList = dataList;
    }

}
