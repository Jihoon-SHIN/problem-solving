package lv2;

import java.util.StringTokenizer;

public class JadenCase {
    public String solution(String s) {
        String answer = "";

        if ( s.length() == 1) return s.toUpperCase();
        final StringTokenizer stringTokenizer = new StringTokenizer(s, " ", true);

        while (stringTokenizer.hasMoreElements()) {
            final String element = (String) stringTokenizer.nextElement();
            if ( !element.isBlank() ) {
                answer += element.substring(0, 1).toUpperCase() + element.substring(1).toLowerCase();
            } else {
                answer += element;
            }
        }

        return answer;
    }
}
