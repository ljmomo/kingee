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

import java.util.ArrayList;
import java.util.List;

import com.junly.common.enums.UserTypeEnums;

/** <p class="detail">
 * 功能：用户类型Util
 * </p>
 * @ClassName: UserTypesUtil 
 * @version V1.0  
 * @date 2017年3月22日 
 * @author junly
 * Copyright 2016 tsou.com, Inc. All rights reserved
 */
public class UserTypesUtil {

    /** <p class="detail">
    * 功能：web端登录者的用户类型
    * </p>
    * @author panwuhai
    * @date 2016年5月5日 
    * @return    
    */
    public static List<Integer> getWebuserTypes() {
        List<Integer> userTypes = new ArrayList<Integer>();

        userTypes.add(UserTypeEnums.SYSTEM_MANAGER.getCode());
        userTypes.add(UserTypeEnums.DEALER.getCode());
        return userTypes;
    }

    /** <p class="detail">
    * 功能：app端登录类型限制
    * </p>
    * @author panwuhai
    * @date 2016年5月5日 
    * @return    
    */
    public static List<Integer> getAppuserTypes() {
        List<Integer> userTypes = new ArrayList<Integer>();

        userTypes.add(UserTypeEnums.MEMBER.getCode());

        return userTypes;
    }
}
