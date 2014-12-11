package com.jingxuan.utils;

import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * a utility class to check string whether to match a given user agent
 *  
 * @package com.jingxuan.utils
 * @version 0.0.1
 * @author Andy
 *
 */

public final class PatternUtils {

    private PatternUtils(){
    }
    
    /**
     * method used to match the pattern and fetch the matched result
     * 
     * @param userAgent
     * @param pattern
     * @return
     */
    public static String match(String userAgent, String pattern) {

        Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(userAgent);
        while (matcher.find()) {
            return matcher.group();
        }

        return null;
    }
    
    /**
     * method used to check a string whether or not to match the given pattern
     * 
     * @param userAgent
     * @param pattern
     * @return boolean -- true on matched, false on not matched
     */
    public static boolean check(String userAgent, String pattern){
        Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(userAgent);
        
        return matcher.find();
    }
    
    /**
     * method used to check all pattern to match given pattern
     * 
     * @param userAgent -- a string of user agent on browser
     * @param patterns -- all are matched pattern
     * @return true on matched all , otherwise returns false
     */
    public static boolean checkAll(String userAgent, String[] patterns){
        
        String stringPattern = stringOfPattern(patterns);
//        System.out.println(stringPattern);
        return check(userAgent, stringPattern);
    }
    
    /**
     * method used to check all of patterns whether or not to match the given string 
     * 
     * @param userAgent
     * @param patterns
     * @return boolean 
     */
    public static boolean checkAllMust(String userAgent, String[] patterns){
       
        for (String pattern : patterns) {
            if (!check(userAgent, pattern)) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * method used to check a pattern whether or not to match a given string but must exclude a given pattern
     * 
     * @param userAgent
     * @param pattern
     * @param excludePattern
     * @return
     */
    public static boolean checkMustExclude(String userAgent, String pattern, String excludePattern){
        if (check(userAgent, pattern) && !check(userAgent, excludePattern)) {
            return true;
        }
        
        return false;
    }
    
    /**
     * method used to patterns whether or not to match a given string but must exclude some patterns
     * 
     * @param userAgent
     * @param patterns
     * @param excludePatterns
     * @return
     */
    public static boolean checkAllMustExclude(String userAgent, String[] patterns, String[] excludePatterns){
        String pattern = stringOfPattern(patterns);
        String excludePattern = stringOfPattern(excludePatterns);
//              System.out.println(pattern);
//              System.out.println(excludePattern);
        if (check(userAgent, pattern) && !check(userAgent, excludePattern)) {
            return true;
        }
        
        return false;
    }
    
    /**
     * method used to get a string consist of patterns(e.g. a|b|c)
     * 
     * @param patterns
     * @return String -- a completed pattern include all the given pattern
     */
    public static String stringOfPattern(String[] patterns){
        StringBuffer sb = new StringBuffer();
        
        for (String pattern : patterns) {
            sb.append(pattern);
            sb.append("|");
        }
        String tempString = sb.toString();
        int position = tempString.lastIndexOf("|");
        String finalString = tempString.substring(0, position);
        
        return finalString;
    }
    
    
    /**
     * method used to check patterns whether or not to match given string
     * 
     * @param userAgent
     * @param mobilePatterns
     * @return boolean true on matched, false on not matched
     */
    public static boolean checkPatternFromMap(String userAgent, Map<String , String> mobilePatterns){
        
        Set<String> keys = mobilePatterns.keySet();
        for (String key : keys) {
            String pattern = mobilePatterns.get(key);
            if (PatternUtils.check(userAgent, pattern)) {
//                System.out.println(pattern);
                return true;
            }
        }
        
        return false;
    }
    
}
