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
package com.junly.service.helper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.junly.common.contants.ViewContants;
import com.junly.common.enums.HttpChannelType;


/** <p class="detail">
 * 功能：这里写类描述
 * </p>
 * @ClassName: TicketHelper 
 * @version V1.0  
 * @date 2017年3月24日 
 * @author junly
 * Copyright 2016 lijun.com, Inc. All rights reserved
 */
public class TicketHelper {

    /**
     * jar包不要引错 org.apache.commons.logging.*
     */
    private static final Log logger = LogFactory.getLog("HK-SESSION");

    /** <p class="detail">
    * 功能：更新cookie时间
    * </p>
    * @author junly
    * @date 2016年4月22日 
    * @param response
    * @param ticket    
    */
    public void setCookie(HttpServletRequest request, HttpServletResponse response, String ticket) {
        // 信任保存
        Cookie cookie = new Cookie(ViewContants.LOGIN_TICKET_KEY, ticket);

        // 要使此处有效 则访问地址必须与此处的域名一致
        cookie.setDomain(request.getServerName());
        // 设置父path
        cookie.setPath("/");
        // 设置有效期存放至客户端硬盘否则为浏览器内存
        cookie.setMaxAge(ViewContants.TRUST_COOKIE_TIME); //存活期为秒 
        response.addCookie(cookie);
    }

    
     /** <p class="detail">
     * 功能：三种方式归纳取原文ticket
     * </p>
     * @author junly
     * @date 2017年3月24日 
     * @param request
     * @param httpChannelType
     * @return    
     */
    public String getTicket(HttpServletRequest request, HttpChannelType httpChannelType) {

        Cookie cookies[] = request.getCookies();

        String ticket = null;

        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (StringUtils.equals(ViewContants.LOGIN_TICKET_KEY, cookie.getName())) {

                    ticket = StringUtils.trim(cookie.getValue());

                    StringBuilder builder = new StringBuilder(httpChannelType.name());
                    builder.append("：获取到cookie的ticket=").append(ticket);
                    builder.append("：客户端请求地址=").append(request.getServerName()).append("====");
                    builder.append(cookie.getDomain());
                    logger.info(builder.toString());

                    break;
                }
            }
        }

        // java后台设置的cookie存在则header部分肯定也存在即可获取,
        // 测试非后台塞入cookie的取值 如：跨域情况下、安卓情况
        if (StringUtils.isBlank(ticket)) {
            ticket = customHeadTicket(request, httpChannelType);
        }

        if (StringUtils.isBlank(ticket)) {
            ticket = StringUtils.trim(request.getParameter(ViewContants.LOGIN_TICKET_KEY));
        }

        return ticket;
    }

    /** <p class="detail">
    * 功能：清楚取到的cookie
    * </p>
    * @author junly
    * @date 2016年4月20日 
    * @param response
    * @param cookie    
    */
    public void deleteCookie(HttpServletResponse response, Cookie cookie) {
        if (cookie != null) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }

    
     /** <p class="detail">
     * 功能：自定义的header ticket
     * </p>
     * @author junly
     * @date 2017年3月24日 
     * @param request
     * @param httpChannelType
     * @return    
     */
    private String customHeadTicket(HttpServletRequest request, HttpChannelType httpChannelType) {

        String ticket = request.getHeader(ViewContants.LOGIN_TICKET_KEY);

        if (StringUtils.isNotBlank(ticket)) {
            logger.info(httpChannelType.name() + ": header部分获取到ticket=" + ticket);
        }

        /*        Enumeration<?> headerNames = request.getHeaderNames();

                while (headerNames.hasMoreElements()) {
                    String key = (String) headerNames.nextElement();
                    logger.info(httpChannelType.name() + ": header部分: key=" + key + "; value="
                                + request.getHeader(key));
                }*/

        return StringUtils.trim(ticket);
    }

    /** <p class="detail">
    * 功能：从Header部分取
    * </p>
    * @author junly
    * @date 2016年6月8日 
    * @param request
    * @return    
    */
    /*    private String getHeadTicket(HttpServletRequest request, HttpChannelType httpChannelType) {

            String headerCookie = StringUtils.trim(request.getHeader(ViewContants.LOGIN_HEADER_COOKIE));

            if (StringUtils.isNotBlank(headerCookie)) {
                String[] cookies = StringUtils.split(headerCookie, ";");
                for (String cookie : cookies) {
                    if (cookie.contains(ViewContants.LOGIN_TICKET_KEY)) {
                        String tickets[] = StringUtils.split(cookie, "=");
                        if (tickets.length == 2) {
                            logger.info(httpChannelType.name() + ": header部分获取到的cookie-ticket="
                                        + tickets[1]);
                            return StringUtils.trim(tickets[1]);
                        }
                    }
                }
            }
            return null;
        }*/

    /** <p class="detail">
    * 功能：app取 request cookies
    * </p>
    * @author junly
    * @date 2016年4月19日 
    * @param request
    * @return    
    */
    /*    public Cookie getTicketCookie(HttpServletRequest request, HttpChannelType httpChannelType) {

            Cookie cookies[] = request.getCookies();

            Cookie cookie = null;

            if (null != cookies) {
                for (Cookie c : cookies) {

                    if (!StringUtils.equals(ViewContants.LOGIN_TICKET_KEY, c.getName())) {
                        continue;
                    }

                    logger.info(httpChannelType.name() + ": cookie获取到ticket：" + request.getServerName()
                                + "====" + c.getDomain());
                    cookie = c;

                    break;
                }
            }

            return cookie;
        }*/

}
