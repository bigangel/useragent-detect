package com.jingxuan.detect;

import java.util.Map;

import com.jingxuan.utils.MobileUtils;
import com.jingxuan.utils.PatternUtils;

/**
 * class used to detect mobile
 * 
 * @package com.jingxuan.detect
 * @version 0.0.1
 * @author Andys
 *
 */
public class Mobile {

    /**
     * method used to detect the given user agent whether is a phone device
     * 
     * @param userAgent
     * @return
     */
    public static boolean isPhone(String userAgent){
       Map<String, String> mobilePatterns = MobileUtils.Phone.get();
       
       return PatternUtils.checkPatternFromMap(userAgent, mobilePatterns);
    }
    
    public static boolean isTablet(String userAgent){
        Map<String, String> mobilePatterns = MobileUtils.Tablet.get();
        
        return PatternUtils.checkPatternFromMap(userAgent, mobilePatterns);
    }
}
