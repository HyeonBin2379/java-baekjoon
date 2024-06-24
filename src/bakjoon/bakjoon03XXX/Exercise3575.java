package bakjoon.bakjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise3575 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = br.readLine().trim().toCharArray();
        char[] s2 = br.readLine().trim().toCharArray();
        char[] t1 = br.readLine().trim().toCharArray();
        char[] t2 = br.readLine().trim().toCharArray();

        String origPair = makePair(s1, s2, s1.length);
        String resPair = makePair(t1, t2, t1.length);
        if (origPair.equals(resPair)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static String makePair(char[] str1, char[] str2, int n) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String pair = String.valueOf(str1[i])+str2[n-1-i];
            result.add(pair);
        }
        Collections.sort(result);
        return String.join("", result);
    }
}
