package com.junly.common.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

public class StringUtil extends StringUtils {

    /**
     * 描述：字符串判空
     * @param   value
     * @return boolean true：为空，false：非空
     */
    public static boolean isNullOrEmpty(String value) {
        return isBlank(value);
    }

    /**
     * 描述：获取UUID值
     * @param
     * @return String
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 验证字符串是否为纯数字
     * @param number
     * @return
     */
    public static boolean isValidInteger(String str) {
        if (StringUtil.isBlank(str))
            return false;
        boolean flag = false;
        Pattern p = Pattern.compile("^\\d*$");
        if (str != null) {
            Matcher match = p.matcher(str);
            flag = match.matches();
        }
        return flag;
    }

    /**
     * <p class="detail">
     * 功能：将字符串分隔得到List
     * </p>
     * @author liu.weihao
     * @date 2016年4月20日 
     * @param str   要分隔的字符串
     * @param seperator 分隔符，默认是逗号
     * @return
     */
    public static List<String> String2List(String str, String seperator) {
        if (isBlank(str))
            return null;
        seperator = isNullOrEmpty(seperator) ? "," : seperator;
        List<String> resultList = new ArrayList<String>();
        String[] arr = str.split(seperator);
        for (String s : arr) {
            resultList.add(s);
        }
        return resultList;
    }

    /**
     * <p class="detail">
     * 功能：判断一个字符串的长度，1个汉字=2个字符
     * </p>
     * @author liu.weihao
     * @date 2016年5月4日 
     * @param str
     * @return
     */
    public static int getLength(String str) {
        if (str == null)
            return 0;
        char[] c = str.toCharArray();
        int len = 0;
        for (int i = 0; i < c.length; i++) {
            len++;
            if (!isLetter(c[i]))
                len++;
        }
        return len;
    }

    /**
     * <p class="detail">
     * 功能：判断是否是标准的字符
     * </p>
     * @author liu.weihao
     * @date 2016年5月4日 
     * @param c
     * @return
     */
    public static boolean isLetter(char c) {
        int k = 0x80;
        return c / k == 0 ? true : false;
    }

    /**
     * 货币相加
     * @param m1
     * @param m2
     * @return
     */
    public static String addCount(String m1, String m2) {
        BigDecimal d1 = new BigDecimal(m1);
        BigDecimal d2 = new BigDecimal(m2);
        return d1.add(d2).toString();
    }

    /**
     * 两数相减
     * @param m1
     * @param m2
     * @return
     */
    public static String subCount(String m1, String m2) {
        BigDecimal d1 = new BigDecimal(m1);
        BigDecimal d2 = new BigDecimal(m2);
        return d1.subtract(d2).toString();
    }

    /**
     * 两数相乘
     * @param m1
     * @param m2
     * @return
     */
    public static String mulMoney(String m1, String m2) {
        BigDecimal d1 = new BigDecimal(m1);
        BigDecimal d2 = new BigDecimal(m2);
        return d1.multiply(d2).setScale(2).toString();
    }

    /**
     * 两数相乘
     * @param m1
     * @param m2
     * @param newScale 保留几位小数
     * @return
     */
    public static String mulMoney(String m1, String m2, int newScale) {
        BigDecimal d1 = new BigDecimal(m1);
        BigDecimal d2 = new BigDecimal(m2);
        return d1.multiply(d2).setScale(newScale).toString();
    }

    /**
     * 相除取四舍五入
     * @param m1
     * @param m2
     * @return
     */
    public static String divMoney(String m1, String m2) {
        BigDecimal d1 = new BigDecimal(m1);
        BigDecimal d2 = new BigDecimal(m2);
        return d1.divide(d2, 2, BigDecimal.ROUND_HALF_UP).toString();
    }


    /**
     * <p class="detail">
     * 功能：app接口返回的json数据换行符等统一替换成字符
     * </p>
     * @author tangy
     * @date 2014-12-23
     * @param string
     * @return
     */
    public static final String quote(String string) {
        if (string == null || string.length() == 0) {
            return "";
        }
        char b;
        char c = 0;
        int i;
        int len = string.length();
        StringBuffer sb = new StringBuffer(len + 4);
        String t;

        for (i = 0; i < len; i += 1) {
            b = c;
            c = string.charAt(i);
            switch (c) {
                case '\\':
                case '"':
                    sb.append('\\');
                    sb.append(c);
                    break;
                case '/':
                    if (b == '<') {
                        sb.append('\\');
                    }
                    sb.append(c);
                    break;
                case '\b':
                    sb.append("\\b");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                default:
                    if (c < ' ' || (c >= '\u0080' && c < '\u00a0')
                        || (c >= '\u2000' && c < '\u2100')) {
                        t = "000" + Integer.toHexString(c);
                        sb.append("\\u" + t.substring(t.length() - 4));
                    } else {
                        sb.append(c);
                    }
            }
        }
        return sb.toString();
    }

    /**
     * <p class="detail">
     * 功能：获得请求路径
     * </p>
     * @author wangb
     * @date 2015-1-22
     * @param request
     * @param type
     * @return
     */
    public static String getContextURL(HttpServletRequest request, int type) {
        String strBackUrl = "http://" + request.getServerName() // 服务器地址
                            + ":" + request.getServerPort(); // 端口号
        if (type == 1)
            strBackUrl += request.getContextPath(); // 项目名称
        return strBackUrl;
    }

    /**
     * <p class="detail">
     * 功能：app接口返回富文本编辑器编辑的html代码时调用该方法将图片宽度替换为100%，以适配手机端屏幕(按照内容适应)
     * </p>
     * @author tangy
     * @date 2015-9-16
     * @param htmlText
     * @return
     */

    public static void main(String[] args) {
        System.out.println(getLength("我的ACCC"));
    }
}
