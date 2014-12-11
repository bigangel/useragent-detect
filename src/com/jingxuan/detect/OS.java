package com.jingxuan.detect;

import com.jingxuan.utils.PatternUtils;

/**
 * class used to detect operation system 
 * 
 * @package com.jingxuan.detect
 * @version 0.0.1
 * @author Andy
 *
 */
public class OS {

    
    public static boolean isWindow(String userAgent){
        // reference: http://msdn.microsoft.com/zh-CN/library/ms537503.aspx
        String[] patterns = {
                             "Windows NT 6.3",     // Windows 8.1
                             "Windows NT 6.2",     // Windows 8
                             "Windows NT 6.1",     // Windows 7
                             "Windows NT 6.0",     // Windows Vista
                             "Windows NT 5.2",     // Windows Server 2003; Windows XP x64 Edition
                             "Windows NT 5.1",     // Windows XP
                             "Windows NT 5.01",    // Windows 2000, Service Pack 1 (SP1)
                             "Windows NT 5.0",     // Windows 2000
                             "Windows NT 4.0",     // Microsoft Windows NT 4.0
                             "Windows 98; Win 9x 4.90", // Windows Millennium Edition (Windows Me)
                             "Windows 98",         // Windows 98
                             "Win98",
                             "Win95",
                             "Windows 95",         // Windows 95
                             "Windows CE"          // Windows CE
                            };
        
        return PatternUtils.checkAll(userAgent, patterns);
    }
    
    public static boolean isLinux(String userAgent){
        // reference: http://www.webapps-online.com/online-tools/user-agent-strings/dv/operatingsystem51848/linux
        String[] patterns = {
                                "X11; Linux", 
                                "X11; Ubuntu; Linux", 
                                "X11; U; Linux",
                                "Unknown; Linux",
                            };
        
        return PatternUtils.checkAll(userAgent, patterns);
    }
    
    public static boolean isMac(String userAgent){
        String pattern = "Macintosh;";
        
        return PatternUtils.check(userAgent, pattern);
    }
    
    
    public static boolean isDesktop(String userAgent){
        if (isWindow(userAgent) || isLinux(userAgent) || isMac(userAgent)) {
            return true;
        }
        return false;
    }
    
    public static boolean isMobile(String userAgent){
        if (isAndroid(userAgent) || isIOS(userAgent) || isWindowMobile(userAgent)
                || isWindowPhone(userAgent) || isSymbian(userAgent) || isBlackBerry(userAgent)) {
            return true;
        }
        return false;
    }
    
    public static boolean isAndroid(String userAgent){
        String pattern = "Android;";
        
        return PatternUtils.check(userAgent, pattern);
    }
    
    public static boolean isIOS(String userAgent){
        String pattern = "\\biPhone.*Mobile|\\biPod|\\biPad";
        
        return PatternUtils.check(userAgent, pattern);
    }
    
    public static boolean isWindowPhone(String userAgent){
        String pattern = "Windows Phone 8.0|Windows Phone OS|XBLWP7|ZuneWP7|Windows NT 6.[23]; ARM;";
        
        return PatternUtils.check(userAgent, pattern);
    }
    
    public static boolean isWindowMobile(String userAgent){
        String pattern = "Windows CE.*(PPC|Smartphone|Mobile|[0-9]{3}x[0-9]{3})|Window Mobile|Windows Phone [0-9.]+|WCE;";
        
        return PatternUtils.check(userAgent, pattern);
    }
    
    public static boolean isSymbian(String userAgent){
        String pattern = "Symbian|SymbOS|Series60|Series40|SYB-[0-9]+|\\bS60\\b";

        return PatternUtils.check(userAgent, pattern);
    }
    
    public static boolean isBlackBerry(String userAgent){
        String pattern = "blackberry|\\bBB10\\b|rim tablet os";

        return PatternUtils.check(userAgent, pattern);
    }    
    
}
