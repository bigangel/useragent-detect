package com.jingxuan.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jingxuan.detect.OS;

public class DesktopUnitTest {

    @Test
    public void testIsWindow() {
        List<String> userAgentList = new ArrayList<>();
        
        userAgentList.add("Mozilla/5.0 (Windows NT 6.3; Trident/7.0; rv:11.0) like Gecko");
        userAgentList.add("Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0)");
        userAgentList.add("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0");
        userAgentList.add("Mozilla/5.0 (Windows NT 6.0; WOW64; rv:24.0) Gecko/20100101 Firefox/24.0");
        userAgentList.add("Mozilla/5.0 (Windows; U; Windows NT 5.2; en-GB; rv:1.9.2.9) Gecko/20100824 Firefox/3.6.9");
        userAgentList.add("Mozilla/5.0 (Windows; U; Win98; rv:1.7.3) Gecko/20041001 Firefox/0.10.1");
        
        for (String userAgent : userAgentList) {
//            System.out.println(Desktop.isWindow(userAgent));
            assertTrue(OS.isWindow(userAgent));
        }
    }

    @Test
    public void testIsLinux() {
        List<String> userAgentList = new ArrayList<>();
        List<String> userAgentList2 = new ArrayList<>();
        
        userAgentList.add("Mozilla/5.0 (X11; U; Linux i686; lt; rv:1.6) Gecko/20051114 Firefox/1.5");
        userAgentList.add("Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:24.0) Gecko/20100101 Firefox/24.0");
        userAgentList.add("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.32 (KHTML, like Gecko) Chromium/25.0.1349.2 Chrome/25.0.1349.2 Safari/537.32 Epiphany/3.8.2");
        userAgentList.add("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.4 (KHTML, like Gecko; Google Web Preview) Chrome/22.0.1229 Safari/537.4");
        userAgentList.add("Mozilla/5.0 (X11; U; Linux x86_64; en-US; rv:1.9.2.13) Gecko/20101206 Ubuntu/8.04 (hardy) Firefox/3.6.13");
        userAgentList.add("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.76 Safari/537.36");
        userAgentList.add("Mozilla/5.0 (X11; U; Linux x86_64; de-DE; rv:1.9.0.19) Gecko/2010120923 ThumbShotsBot (KFSW 3.0.6-3)");

        for (String userAgent : userAgentList) {
//            System.out.println(Desktop.isLinux(userAgent));
            assertTrue(OS.isLinux(userAgent));
        }
        
        // exclude Android
        userAgentList2.add("Mozilla/5.0 (Linux; U; Android 4.0.3; ko-kr; LG-L160L Build/IML74K) AppleWebkit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30");
        
        for (String userAgent : userAgentList2) {
//          System.out.println(Desktop.isLinux(userAgent));
          assertFalse(OS.isLinux(userAgent));
        }
        
    }

    @Test
    public void testIsMac() {
        List<String> userAgentList = new ArrayList<>();
        userAgentList.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_3) AppleWebKit/537.75.14 (KHTML, like Gecko) Version/7.0.3 Safari/7046A194A");
        
        for (String userAgent : userAgentList) {
            assertTrue(OS.isMac(userAgent));
        }
    }

    @Test
    public void testIsDesktop() {
        List<String> userAgentList = new ArrayList<>();
        userAgentList.add("Mozilla/5.0 (Windows NT 6.3; Trident/7.0; rv:11.0) like Gecko");
        userAgentList.add("Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0)");
        userAgentList.add("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0");
        userAgentList.add("Mozilla/5.0 (Windows NT 6.0; WOW64; rv:24.0) Gecko/20100101 Firefox/24.0");
        userAgentList.add("Mozilla/5.0 (Windows; U; Windows NT 5.2; en-GB; rv:1.9.2.9) Gecko/20100824 Firefox/3.6.9");
        userAgentList.add("Mozilla/5.0 (Windows; U; Win98; rv:1.7.3) Gecko/20041001 Firefox/0.10.1");
        userAgentList.add("Mozilla/5.0 (X11; U; Linux i686; lt; rv:1.6) Gecko/20051114 Firefox/1.5");
        userAgentList.add("Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:24.0) Gecko/20100101 Firefox/24.0");
        userAgentList.add("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.32 (KHTML, like Gecko) Chromium/25.0.1349.2 Chrome/25.0.1349.2 Safari/537.32 Epiphany/3.8.2");
        userAgentList.add("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.4 (KHTML, like Gecko; Google Web Preview) Chrome/22.0.1229 Safari/537.4");
        userAgentList.add("Mozilla/5.0 (X11; U; Linux x86_64; en-US; rv:1.9.2.13) Gecko/20101206 Ubuntu/8.04 (hardy) Firefox/3.6.13");
        userAgentList.add("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.76 Safari/537.36");
        userAgentList.add("Mozilla/5.0 (X11; U; Linux x86_64; de-DE; rv:1.9.0.19) Gecko/2010120923 ThumbShotsBot (KFSW 3.0.6-3)");
        userAgentList.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_3) AppleWebKit/537.75.14 (KHTML, like Gecko) Version/7.0.3 Safari/7046A194A");
        
        for (String userAgent : userAgentList) {
            assertTrue(OS.isDesktop(userAgent));
        }
    }

}
