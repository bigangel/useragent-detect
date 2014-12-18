package com.jingxuan.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jingxuan.detect.Mobile;

public class MobileUnitTest {
    
    private static List<String> userAgentList = new ArrayList<>();
    
    @BeforeClass
    public static void providerData(){
        userAgentList.add("Mozilla/5.0 (iPad; CPU OS 6_0 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Version/6.0 Mobile/10A5355d Safari/8536.25");
        userAgentList.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_6_8) AppleWebKit/537.13+ (KHTML, like Gecko) Version/5.1.7 Safari/534.57.2");
        userAgentList.add("Mozilla/5.0 (Windows; U; Windows NT 6.1; sv-SE) AppleWebKit/533.19.4 (KHTML, like Gecko) Version/5.0.3 Safari/533.19.4");
        userAgentList.add("Mozilla/5.0 (iPhone; U; ru; CPU iPhone OS 4_2_1 like Mac OS X; ru) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8C148a Safari/6533.18.5");
        userAgentList.add("Mozilla/5.0 (iPod; U; CPU iPhone OS 4_3_3 like Mac OS X; ja-jp) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8J2 Safari/6533.18.5");
        userAgentList.add("Mozilla/5.0 (Linux; U; Android 4.0.3; ko-kr; LG-L160L Build/IML74K) AppleWebkit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30");
        userAgentList.add("Mozilla/5.0 (BlackBerry; U; BlackBerry 9900; en) AppleWebKit/534.11+ (KHTML, like Gecko) Version/7.1.0.346 Mobile Safari/534.11+");
        userAgentList.add("Mozilla/5.0 (compatible; MSIE 9.0; Windows Phone OS 7.5; Trident/5.0; IEMobile/9.0)");
        userAgentList.add("Opera/9.80 (J2ME/MIDP; Opera Mini/9.80 (S60; SymbOS; Opera Mobi/23.348; U; en) Presto/2.5.25 Version/10.54");
        userAgentList.add("SAMSUNG-C5212/C5212XDIK1 NetFront/3.4 Profile/MIDP-2.0 Configuration/CLDC-1.1");
        userAgentList.add("NokiaN97i/SymbianOS/9.1 Series60/3.0");
        userAgentList.add("Mozilla/5.0 (SymbianOS/9.4; Series60/5.0 NokiaC6-00/20.0.042; Profile/MIDP-2.1 Configuration/CLDC-1.1; zh-hk) AppleWebKit/525 (KHTML, like Gecko) BrowserNG/7.2.6.9 3gpp-gba");
        userAgentList.add("Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19");
    }
    
    @AfterClass
    public static void clear(){
        userAgentList.clear();
        System.out.println(userAgentList);
    }

    @Test
    public void testIsPhone() {
        boolean[] expecteds = {false, false, false, true, true, true, true,
                                true, true, true, true, true, true};
        
        for (int i = 0; i < userAgentList.size(); i++) {
            boolean expected = expecteds[i];
            String userAgent = userAgentList.get(i);
            
            assertEquals(expected, Mobile.isPhone(userAgent));
            System.out.println("excepted: " + expected +"; actual: " +Mobile.isPhone(userAgent));
        }
    }

    @Test
    public void testIsTablet() {
        boolean[] expecteds = {true, false, false, false, false, false, false, 
                               false, false, false, false, false, false};
        
        for (int i = 0; i < userAgentList.size(); i++) {
            boolean expected = expecteds[i];
            String userAgent = userAgentList.get(i);
            
            assertEquals(expected, Mobile.isTablet(userAgent));
            System.out.println("excepted: " + expected +"; actual: " +Mobile.isTablet(userAgent));
//            System.out.println(Mobile.isPhone(userAgent));
        }
    }

}
