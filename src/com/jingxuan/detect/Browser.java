package com.jingxuan.detect;

import com.jingxuan.utils.PatternUtils;

/**
 * @reference https://developer.mozilla.org/en-US/docs/Browser_detection_using_the_user_agent
 * @package com.jingxuan.detect
 * @version 0.0.1 
 * @author Andy
 */
public class Browser {

    public static boolean isIE(String userAgent){
        /**
         * Trident/7.0 ==> IE 11
         * Trident/6.0 ==> IE 10
         * Trident/5.0 ==> IE 9
         * Trident/4.0 ==> IE 8
         * 
         * @referce http://msdn.microsoft.com/zh-CN/library/ms537503.aspx
         */
        String pattern = "; MSIE [.0-9]*;|Trident/7.0";
        
        return PatternUtils.check(userAgent, pattern);
    }
    
    public static boolean isFirefox(String userAgent){
        /**
         * matched pattern
         */
        String[] patterns = {"Firefox/[.0-9]*"};
        
        /**
         * 1. exclude this pattern, SaeMonkey also include string "firefox/x.y"
         * 2. opera may pretend to be Firefox eg: Opera/5.0 (Ubuntu; U; Windows NT 6.1; es; rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13
         */
        String[] excludePatterns = {
                                     "SeaMonkey/[.0-9]*", "Opera/[.0-9]*", "Opera [.0-9]*",
                                     "OPR/[.0-9]*", "OPR [.0-9]*"
                                   };
        
        if (PatternUtils.checkAllMustExclude(userAgent, patterns, excludePatterns)) {
            return true;
        }
        
        return false;
    }
    
    public static boolean isChrome(String userAgent){
        String[] patterns = {
                                "Chrome/[.0-9]*",
                                "CriOS/[.0-9]*", // Chrome for  IOS
                                " \\bCrMo\\b"
                            };
        String[] excludePatterns = {"Chromium/[.0-9]*", "OPR/[.0-9]*"}; // a open source browser behind Chrome browser
        
        return PatternUtils.checkAllMustExclude(userAgent, patterns, excludePatterns);
    }
    
    public static boolean isSafari(String userAgent){
        
        String[] pattern = {"Safari/[.0-9]*"};
        String[] excludePattern = {
                                      "Chromium/[.0-9]*", "Chrome/[.0-9]*", "OPR/[.0-9]*"
                                  };
        
        return PatternUtils.checkAllMustExclude(userAgent, pattern, excludePattern);
    }
    
    public static boolean isOpera(String userAgent){
        String[] patterns = {
                                "OPR/[.0-9]*", "Opera/[.0-9]*", "Opera [.0-9]*",
                                "Opera.*Mini", "Opera.*Mobi", "Android.*Opera",
                                "Coast/[0-9.]+"
                            };
        
        return PatternUtils.checkAll(userAgent, patterns);
    }
    
}
