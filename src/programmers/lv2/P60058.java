package programmers.lv2;

public class P60058 {
    public String solution(String p) {
        if (p.isEmpty()) return "";

        return recursiveFunc(p);
    }

    private String recursiveFunc(String p) {
        String returnVal = "";
        if (p.isEmpty()) {
            return p;
        }

        final int balancedIndex = getBalancedIndex(p);
        String u = p.substring(0, balancedIndex+1);
        String v = p.substring(balancedIndex+1, p.length());

        if (checkBalanced(u)) {
            returnVal = u + recursiveFunc(v);
        } else {
            String newP = "";
            newP += "(";
            newP += recursiveFunc(v);
            newP += ")";

            if (u.length() == 2) {
                returnVal =  newP;
            } else {
                String newU = "";
                final String substring = u.substring(1, u.length() - 1);
                for (int i=0; i<substring.length(); i++) {
                    final String subSub = substring.substring(i, i + 1);
                    if ( subSub.equals("(")) {
                        newU += ")";
                    } else {
                        newU += "(";
                    }
                }
                returnVal = newP + newU;
            }
        }

        return returnVal;
    }


    private int getBalancedIndex(String p) {
        int count = 0;
        for (int i=0; i<p.length(); i++) {
            final char pChar = p.charAt(i);
            if (pChar == '(') {
                count++;
            }
            if (pChar == ')') {
                count--;
            }

            if (count == 0) {
                return i;
            }
        }
        return p.length() - 1;
    }

    private boolean checkBalanced(String str) {
        int count = 0;
        for (int i=0; i<str.length(); i++) {
            final char pChar = str.charAt(i);
            if (pChar == '(') {
                count++;
            }
            if (pChar == ')') {
                count--;
            }

            if (count == -1) {
                return false;
            }
        }
        return true;
    }
}
