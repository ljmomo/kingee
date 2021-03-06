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
package com.junly.common.enums;

import org.apache.commons.lang.StringUtils;

/** <p class="detail">
 * 功能：HTTP渠道类型
 * </p>
 * @ClassName: UserTypeEnums 
 * @version V1.0  
 * @date 2016年4月14日 
 * @author panwuhai
 * Copyright 2016 lijun.com, Inc. All rights reserved
 */
public enum HttpChannelType {

    APP("APP", "APP"), 
    WEB("WEB", "WEB"), 
    H5("H5", "H5"), ;

    private String code;

    private String detail;

    HttpChannelType(String code, String detail) {
        this.code = code;
        this.detail = detail;
    }

    /**
     * 获得枚举
     * 
     * @param code
     * @return
     */
    public static HttpChannelType getEnumByCode(String code) {

        if (StringUtils.isNotBlank(code)) {
            for (HttpChannelType activitie : HttpChannelType.values()) {
                if (StringUtils.equals(code, activitie.getCode())) {
                    return activitie;
                }
            }
        }
        return null;
    }

    public static String getDetailByCode(String code) {

        if (StringUtils.isNotBlank(code)) {
            for (HttpChannelType activitie : HttpChannelType.values()) {
                if (StringUtils.equals(code, activitie.getCode())) {
                    return activitie.getDetail();
                }
            }
        }
        return null;
    }

    /**
     * @return code
     */

    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail
     *            the detail to set
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }
}
