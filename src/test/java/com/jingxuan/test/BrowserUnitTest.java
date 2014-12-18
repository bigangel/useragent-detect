package com.jingxuan.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jingxuan.detect.Browser;

public class BrowserUnitTest {

    @Test
    public void testIsIE() {
        List<String> userAgentList = new ArrayList<>();
        // IE On Mobile
        userAgentList.add("Mozilla/5.0 (compatible; MSIE 9.0; Windows Phone OS 7.5; Trident/5.0; IEMobile/9.0)");
        userAgentList.add("HTC_Touch_3G Mozilla/4.0 (compatible; MSIE 6.0; Windows CE; IEMobile 7.11)");
        userAgentList.add("Mozilla/4.0 (compatible; MSIE 7.0; Windows Phone OS 7.0; Trident/3.1; IEMobile/7.0; Nokia;N70)");
        // IE On Desktop
        userAgentList.add("Mozilla/5.0 (Windows NT 6.3; Trident/7.0; rv:11.0) like Gecko");
        userAgentList.add("Mozilla/5.0 (compatible; MSIE 10.6; Windows NT 6.1; Trident/5.0; InfoPath.2; SLCC1; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; .NET CLR 2.0.50727) 3gpp-gba UNTRUSTED/1.0");
        userAgentList.add("Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0)");
        userAgentList.add("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0; chromeframe/12.0.742.112)");
        userAgentList.add("Mozilla/5.0 (compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0; GTB7.4; InfoPath.2; SV1; .NET CLR 3.3.69573; WOW64; en-US)");
        userAgentList.add("Mozilla/5.0 (Windows; U; MSIE 7.0; Windows NT 5.2)");
        userAgentList.add("Mozilla/5.0 (Windows NT 6.3; Win64, x64; Trident/7.0; Touch; rv:11.0) like Gecko"); // On Windows 8
        
        for (String userAgent : userAgentList) {
            assertTrue(Browser.isIE(userAgent));
        }
    }

    @Test
    public void testIsFirefox() {
//        String pattern = "Firefox/[.0-9]*(?!SeaMonkey)";
        List<String> userAgentList = new ArrayList<>();
        List<String> userAgentList2 = new ArrayList<>();
        
        userAgentList.add("Mozilla/5.0 (Windows NT 6.3; rv:36.0) Gecko/20100101 Firefox/36.0");
        userAgentList.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10; rv:33.0) Gecko/20100101 Firefox/33.0");
        userAgentList.add("Mozilla/5.0 (X11; Linux i586; rv:31.0) Gecko/20100101 Firefox/31.0");
        userAgentList.add("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:24.0) Gecko/20100101 Firefox/24.0");
        userAgentList.add("Mozilla/5.0 (Windows NT 6.2; WOW64; rv:21.0) Gecko/20130514 Firefox/21.0");
        userAgentList.add("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:6.0a2) Gecko/20110613 Firefox/6.0a2");
        userAgentList.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:9.0a2) Gecko/20111101 Firefox/9.0a2");
        userAgentList.add("Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.1.16) Gecko/20120427 Firefox/15.0a1");
        
        // Exclude SeaMonkey -- should report fail
        userAgentList2.add("Mozilla/5.0 (X11; Linux x86_64; rv:12.0) Gecko/20120501 Firefox/12.0 SeaMonkey/2.9.1 Lightning/1.4");
        userAgentList2.add("Mozilla/5.0 (Windows NT 5.0; rv:1.9.2.8) Gecko/20120427 Firefox/12.0 SeaMonkey/2.9");
        userAgentList2.add("Mozilla/5.0 (Windows NT 6.3; Win64, x64; Trident/7.0; Touch; rv:11.0) like Gecko"); // On Windows 8
        userAgentList2.add("Mozilla/5.0 (Windows NT 6.0; rv:2.0) Gecko/20100101 Firefox/4.0 Opera 12.14");
        userAgentList2.add("Mozilla/5.0 (Windows NT 5.1) Gecko/20100101 Firefox/14.0 Opera/12.0");
        
        for (String userAgent : userAgentList) {
            assertTrue(Browser.isFirefox(userAgent));
        }
        
        for (String userAgent : userAgentList2) {
            assertFalse(Browser.isFirefox(userAgent));
        }
    }

    @Test
    public void testIsChrome() {
        List<String> userAgentList = new ArrayList<>();
        userAgentList.add("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");
        userAgentList.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2227.1 Safari/537.36");
        userAgentList.add("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2227.0 Safari/537.36");
        userAgentList.add("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.116 Safari/537.36 Mozilla/5.0 (iPad; U; CPU OS 3_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B334b Safari/531.21.10");
        userAgentList.add("Mozilla/5.0 (iPhone; U; CPU iPhone OS 5_1_1 like Mac OS X; en) AppleWebKit/534.46.0 (KHTML, like Gecko) CriOS/19.0.1084.60 Mobile/9B206 Safari/7534.48.3");
        
        List<String> userAgentList2 = new ArrayList<>();
        userAgentList2.add("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.11 (KHTML, like Gecko) Ubuntu/11.10 Chromium/17.0.963.65 Chrome/17.0.963.65 Safari/535.11");
        userAgentList2.add("Mozilla/5.0 (X11; Linux i686) AppleWebKit/535.11 (KHTML, like Gecko) Ubuntu/11.10 Chromium/17.0.963.65 Chrome/17.0.963.65 Safari/535.11");
        userAgentList2.add("Mozilla/5.0 (Windows NT 6.3; Win64, x64; Trident/7.0; Touch; rv:11.0) like Gecko"); // On Windows 8
        userAgentList2.add("Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.95 Safari/537.36 OPR/15.0.1147.153");
        
        for (String userAgent : userAgentList) {
            assertTrue(Browser.isChrome(userAgent));
        }
        
        for (String userAgent : userAgentList2) {
            assertFalse(Browser.isChrome(userAgent));
        }
    }

    @Test
    public void testIsSafari() {
        List<String> userAgentList = new ArrayList<>();
        List<String> userAgentList2 = new ArrayList<>();
        
        userAgentList.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_3) AppleWebKit/537.75.14 (KHTML, like Gecko) Version/7.0.3 Safari/7046A194A");
        userAgentList.add("Mozilla/5.0 (iPad; CPU OS 6_0 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Version/6.0 Mobile/10A5355d Safari/8536.25");
        userAgentList.add("Mozilla/5.0 (Windows; U; Windows NT 6.1; tr-TR) AppleWebKit/533.20.25 (KHTML, like Gecko) Version/5.0.4 Safari/533.20.27");
        userAgentList.add("Mozilla/5.0 (iPod; U; CPU iPhone OS 4_3_3 like Mac OS X; ja-jp) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8J2 Safari/6533.18.5");
        userAgentList.add("Mozilla/5.0 (iPhone; U; ru; CPU iPhone OS 4_2_1 like Mac OS X; fr) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8C148a Safari/6533.18.5");
        
        userAgentList2.add("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");
        userAgentList2.add("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.11 (KHTML, like Gecko) Ubuntu/11.10 Chromium/17.0.963.65 Chrome/17.0.963.65 Safari/535.11");
        userAgentList2.add("Mozilla/5.0 (Windows NT 6.3; Win64, x64; Trident/7.0; Touch; rv:11.0) like Gecko");
        userAgentList2.add("Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.95 Safari/537.36 OPR/15.0.1147.153");
        userAgentList2.add("Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36 OPR/18.0.1284.68");
       
        for (String userAgent : userAgentList) {
            assertTrue(Browser.isSafari(userAgent));
        }
        
        for (String userAgent : userAgentList2) {
            assertFalse(Browser.isSafari(userAgent));
        }
    }

    @Test
    public void testIsOpera() {
        List<String> userAgentList = new ArrayList<>();
        userAgentList.add("Opera/9.80 (X11; Linux i686; Ubuntu/14.10) Presto/2.12.388 Version/12.16");
        userAgentList.add("Mozilla/5.0 (Windows NT 6.0; rv:2.0) Gecko/20100101 Firefox/4.0 Opera 12.14");
        userAgentList.add("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.0) Opera 12.14");
        userAgentList.add("Mozilla/5.0 (Windows NT 6.1; U; nl; rv:1.9.1.6) Gecko/20091201 Firefox/3.5.6 Opera 11.01");
        userAgentList.add("Opera/9.80 (Android; Opera Mini/7.5.33361/31.1448; U; en) Presto/2.8.119 Version/11.1010");
        userAgentList.add("Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.95 Safari/537.36 OPR/15.0.1147.153");
        userAgentList.add("Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36 OPR/18.0.1284.68");
        
        for (String userAgent : userAgentList) {
            assertTrue(Browser.isOpera(userAgent));
        }
        
    }

}
