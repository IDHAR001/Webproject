package main.com.util;

/**
 * 字符串工具类
 */
public class StringUtil {

    /**
     * 判断字符串是否为空
     *      如果为空返回true
     *      如果不为空返回false
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str == null || str.trim() == "") {
            return true;
        } else return false;
    }
}
