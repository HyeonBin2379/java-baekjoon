package bakjoon.bakjoon3XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise3613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String varName = br.readLine();

        if (!hasValidUnderLine(varName)) {
            System.out.println("Error!");
            return;
        }

        if (varName.contains("_") && varName.matches("^[a-z_]*$")) {
            System.out.println(changeToJavaFormat(varName));
        } else if (!varName.contains("_") && hasValidUpperCase(varName)) {
            System.out.println(changeToCppFormat(varName));
        } else {
            System.out.println("Error!");
        }
        br.close();
    }
    public static boolean hasValidUnderLine(String varName) {
        if (varName.contains("__")) {
            return false;
        }
        return varName.indexOf("_") != 0 && varName.indexOf("_") != varName.length() - 1;
    }
    public static boolean hasValidUpperCase(String varName) {
        return !(varName.charAt(0) >= 'A' && varName.charAt(0) <= 'Z');
    }
    public static String changeToJavaFormat(String varName) { // C++ 변수명을 자바로
        String[] tokens = varName.split("_");
        StringBuilder result = new StringBuilder(tokens[0]);
        for (int i = 1; i < tokens.length; i++) {
            String firstChar = String.valueOf(tokens[i].charAt(0));
            tokens[i] = tokens[i].replaceFirst(firstChar, firstChar.toUpperCase());
            result.append(tokens[i]);
        }
        return result.toString();
    }
    public static String changeToCppFormat(String varName) { // 자바 변수명을 C++로
        List<String> tokens = new ArrayList<>();
        int tokenLength = 0;
        int start = 0;
        for (int i = 0; i < varName.length()-1; i++) {
            tokenLength++;
            if (varName.charAt(i+1) >= 'A' && varName.charAt(i+1) <= 'Z') {
                tokens.add(varName.substring(start, start+tokenLength).toLowerCase());
                start += tokenLength;
                tokenLength = 0;
            }
        }
        tokens.add(varName.substring(start).toLowerCase());
        return String.join("_", tokens);
    }
}
