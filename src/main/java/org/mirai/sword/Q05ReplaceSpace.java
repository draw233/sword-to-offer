package org.mirai.sword;

/**
 * @author mirau on 2021/3/28.
 * @version 1.0
 */
public class Q05ReplaceSpace {

    private final static String SPACE = "%20";

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder(s.length() + 16);
        for (int i = 0; i < s.length(); i++) {
            if (' ' == (s.charAt(i))) {
                sb.append(SPACE);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
