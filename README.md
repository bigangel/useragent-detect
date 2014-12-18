UserAgent-Detect
================

##Our Goal

According to the user agent of HTTP header detects the os, browser, phone, tablet and their version(the current version don't support of getting the version number but we will add the functionality in the future).

##Usage

1. import original-useragent-detect-0.0.1-SNAPSHOT.jar(don't include gson classess) or useragent-detect-0.0.1-SNAPSHOT.jar(includes gson classes) into your classpath.
2. now, you should learn how to use these APIs. Please see the following example.

## Examples

```java
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

1. Install maven on your system.
2. CD to the project directory. e.g. `cd E://useragent-detect`
3. Run `mvn clean package` in your CMD or a terminal.
4. Ok. you will get twos jars file under the target folder.
  - original-useragent-detect-0.0.1-SNAPSHOT.jar(don't include gson classes, so you must import gson jar)
  - useragent-detect-0.0.1-SNAPSHOT.jar(include gson classes, this means that you don't have to import gson jar file)

##Author
  - Andy Li
  - Jia  Li
  - Fengding Liao
  
##How to contribute
Fork our project & commit a pull request. We will take any nice idea. Welcome to join us !

##License

[Apache License 2](http://www.apache.org/licenses/LICENSE-2.0)
