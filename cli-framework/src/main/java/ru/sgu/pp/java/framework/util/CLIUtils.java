package ru.sgu.pp.java.framework.util;

/**
 * @author Elena Fedorova
 */
public class CLIUtils {

    public static Integer getValueAsInteger(String value) {
        if (value == null) {
            return null;
        } else {
            int result;
            try {
                result = Integer.parseInt(value);
                return result;
            } catch (Exception e) {
                return null;
            }
        }
    }

    public static Double getValueAsDouble(String value) {
        if (value == null) {
            return null;
        } else {
            return Double.parseDouble(value);
        }
    }

    public static boolean isInteger(String s) {
        if (s != null) {
            try {
                Integer.parseInt(s);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }
}
