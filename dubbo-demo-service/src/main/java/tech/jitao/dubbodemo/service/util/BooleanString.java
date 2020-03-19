package tech.jitao.dubbodemo.service.util;

import com.google.common.base.Strings;

public final class BooleanString {
    public static final String YES = "Y";
    public static final String NO = "N";

    public static String clean(String str, boolean emptyToFalse) {
        if (Strings.isNullOrEmpty(str)) {
            return emptyToFalse ? NO : "";
        }

        return YES.equals(str) ? YES : NO;
    }

    public static boolean toBool(String str) {
        return YES.equals(str);
    }

    public static String toString(Boolean bool) {
        if (bool != null && bool) {
            return YES;
        } else {
            return NO;
        }
    }
}
