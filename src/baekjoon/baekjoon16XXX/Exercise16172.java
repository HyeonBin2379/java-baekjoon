package baekjoon.baekjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise16172 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().replaceAll("[0-9]", "");
        String pattern = br.readLine();
        System.out.println(kmp(input, pattern) ? 1 : 0);
    }

    private static boolean kmp(String input, String pattern) {
        int[] needToMove = getIndices(pattern);
        int index = 0;

        for (int i = 0; i < input.length(); i++) {
            if (index > 0 && input.charAt(i) != pattern.charAt(index)) {
                index = needToMove[index-1];
            }
            if (input.charAt(i) == pattern.charAt(index)) {
                if (index == pattern.length()-1) {
                    return true;
                }
                index++;
            }
        }
        return false;
    }

    private static int[] getIndices(String pattern) {
        // 문자열의 i번째 문자 불일치 시 문자열을 얼마나 이동시켜서 비교해야 하는지를 의미
        int[] needToMove = new int[pattern.length()];
        int index = 0;

        for (int i = 1; i < pattern.length(); i++) {
            if (index > 0 && pattern.charAt(i) != pattern.charAt(index)) {
                index = needToMove[index-1];
            }
            if (pattern.charAt(i) == pattern.charAt(index)) {
                needToMove[i] = ++index;
            }
        }
        return needToMove;
    }
}
