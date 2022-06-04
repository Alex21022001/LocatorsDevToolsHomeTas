package utils;

import java.util.Random;

public class StringUtil {
    private static final String ALFANUMERICAL_ALL_CAPS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALFAVIT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random random = new Random();

    public static String getRandomPassword(int stringLength) {
        StringBuilder stringBuilder = new StringBuilder(stringLength);
        for (int i = 0; i < stringLength; i++) {
            stringBuilder.append(ALFANUMERICAL_ALL_CAPS.charAt(random.nextInt(ALFANUMERICAL_ALL_CAPS.length())));
        }
        return stringBuilder.toString();
    }
    public static String getRandomString(int stringLength) {
        StringBuilder stringBuilder = new StringBuilder(stringLength);
        for (int i = 0; i < stringLength; i++) {
            stringBuilder.append(ALFAVIT.charAt(random.nextInt(ALFAVIT.length())));
        }
        return stringBuilder.toString();
    }

}
