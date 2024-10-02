package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1120 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str1 = st.nextToken();
        String str2 = st.nextToken();

        int answer = str2.length();
        for (int i = 0; i < str2.length() - str1.length() + 1; i++) {
            int count = getDiff(str1, str2, i);
            answer = Math.min(count, answer);
        }
        System.out.println(answer);
    }

    private static int getDiff(String str1, String str2, int index) {
        int count = 0;
        for (int i = index; i < index+str1.length(); i++) {
            if (str1.charAt(i-index) != str2.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
