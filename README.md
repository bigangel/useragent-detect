UserAgent-Detect
================

##Our Goal
According to the user agent of HTTP header detects the os, browser, phone, tablet and their version(the current version don't support of getting version number but we will add the function in the furture).

##Usage
1. import those .jars file under dist directory(our useragent-detect.jar depends on gson).
2. now, you can look over those APIS and learn how to detect os, browser, phone, tablet and so on.

## Examples
```
String userAgent = "Mozilla/5.0 (iPhone; U; CPU iPhone OS 5_1_1 like Mac OS X; en) AppleWebKit/534.46.0 (KHTML, like Gecko) CriOS/19.0.1084.60 Mobile/9B206 Safari/7534.48.3";        
        // detect mobile -- phone or tablet
        
        System.out.println(Mobile.isPhone(userAgent));
        System.out.println(Mobile.isTablet(userAgent));
        
        // detect browser
        System.out.println(Browser.isChrome(userAgent));
        System.out.println(Browser.isFirefox(userAgent));
        System.out.println(Browser.isIE(userAgent));
        System.out.println(Browser.isOpera(userAgent));
        System.out.println(Browser.isSafari(userAgent));
        
        // detect os
        System.out.println(OS.isAndroid(userAgent));
        System.out.println(OS.isBlackBerry(userAgent));
        System.out.println(OS.isIOS(userAgent));
        System.out.println(OS.isLinux(userAgent));
        System.out.println(OS.isDesktop(userAgent));
        System.out.println(OS.isMac(userAgent));
        System.out.println(OS.isSymbian(userAgent));
        System.out.println(OS.isWindowPhone(userAgent));
        System.out.println(OS.isWindowMobile(userAgent));
        System.out.println(OS.isWindow(userAgent));
        
```

## Build
1. download and install ANT(we use ant version 1.9.4).
2. type `ant resolve ` in a terminal or a command line to download those dependenies by ivy tools.
3. type `ant clean`, then `ant dist`
4. Ok. you can find the output files under the dist diretory.
 

##License
[Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)




