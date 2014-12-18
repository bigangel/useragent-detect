package com.jingxuan.utils;

/**
 * an utility class to help user to  check a string
 * 
 * @package com.jingxuan.utils
 * @version 0.0.1 
 * @author Andy
 *
 */
public class StringUtils {

    public static boolean isEmpty(String string){
        string = string == null ? string : string.trim();
        if (string == null || "null".equals(string.toLowerCase())
                || "".equals(string) || "false".equals(string.toLowerCase())) {
            return true;
        }
        
        return false;
    }
    
    public static boolean isNotEmpty(String string){
        
        return !isEmpty(string);
    }
}
