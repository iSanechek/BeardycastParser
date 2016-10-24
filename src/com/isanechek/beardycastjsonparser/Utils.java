package com.isanechek.beardycastjsonparser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by isanechek on 23.10.16.
 */
public class Utils {

    public static String convertDate(long val) {
        Instant instant = Instant.ofEpochMilli(val);
//        Date date = new Date(val);
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss", Locale.US);
//        format.setTimeZone(TimeZone.getTimeZone("GMT"));
//        return format.format(calendar.getTime());

        return DateTimeFormatter.RFC_1123_DATE_TIME
                .withZone(ZoneOffset.UTC)
                .format(instant);
    }

    private static final String IMG_PATTERN = "(?:jpg|gif|png)";
    public static String getNormalString(String t) {
        /*Надеюсь место в аду мне обеспечено :D*/
        ArrayList<String> tmp = new ArrayList<>();
        String result = null;
        String[] strings = t.split("");
        for (String string : strings) {
            switch (string) {
                case "[":
                    break;
                case "]":
                    tmp.add("-");
                    break;
                case "(":
                    break;
                case ")":
                    tmp.add("-");
                    break;
                case ">":
                    break;
                default:
                    tmp.add(string);
                    break;
            }
        }

        String ts = null;
        if (tmp.size() != 0) {
            for (String s : tmp) {
                ts = ts + s;
            }
            assert ts != null;
            ts = ts.replaceFirst("null", "").replaceAll("-", "");
            tmp.clear();
            String[] word = ts.split(" ");
            for (String s : word) {
                Pattern p = Pattern.compile(IMG_PATTERN);
                Matcher m = p.matcher(s);
                if (!m.find()) {
                    tmp.add(s);
                }
            }

            if (tmp.size() != 0) {
                for (String s : tmp) {
                    result = result + " " + s;
                }

            }
            if (result != null) {
                result = result.replace("null", "").replace("\"", "");
            }
        }
        return result;
    }

    public static JSONArray createMultimediaJson(String text) {
        JSONArray object = new JSONArray();

        return object;
    }
}
