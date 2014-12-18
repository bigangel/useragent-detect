package com.jingxuan.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;

/**
 * an utility class used to help user get all of patterns from JSON file
 *
 * @package com.jingxuan.utils
 * @version 0.0.1
 * @author Andy
 *
 */
public final class MobileUtils {

    private MobileUtils() {

    }

    public final static class Phone {

        public static Map<String, String> get() {

            return AnalyzeJson.phones;
        }
    }

//    public final static class Os {
//
//        public static Map<String, String> get() {
//
//            return AnalyzeJson.os;
//        }
//    }

    public final static class Tablet {

        public static Map<String, String> get() {

            return AnalyzeJson.tablets;
        }
    }

//    public final static class Browser {
//
//        public static Map<String, String> get() {
//
//            return AnalyzeJson.browsers;
//        }
//    }

    private static class AnalyzeJson {

        private static final Map<String, String> phones = getDevices("phones");

        private static final Map<String, String> tablets = getDevices("tablets");

//        private static final Map<String, String> os = getDevices("os");

//        private static final Map<String, String> browsers = getDevices("browsers");;

        private static Map<String, String> getDevices(String mobileType) {

            LinkedTreeMap<String, Map<String, Map<String, String>>> devices = getDevicesFromJson();

            if (mobileType == null
                    || devices.get("ua").get(mobileType) == null) {
                return null;
            }

            return devices.get("ua").get(mobileType);
        }

        private static LinkedTreeMap<String, Map<String, Map<String, String>>> getDevicesFromJson() {

            InputStream in = AnalyzeJson.class.getClassLoader()
                    .getResourceAsStream("com/jingxuan/config/devices.json");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(in));

            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, Map<String, Map<String, String>>>>() {
            }.getType();
            LinkedTreeMap<String, Map<String, Map<String, String>>> devices = gson
                    .fromJson(reader, type);

            return devices;
        }
    }
}
