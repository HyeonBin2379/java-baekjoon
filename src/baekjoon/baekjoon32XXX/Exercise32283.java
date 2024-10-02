package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise32283 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        List<String> result = new ArrayList<>();
        int maxLen = (int) Math.pow(2, n);
        for (int i = 0; i < maxLen; i++) {
            String bin = String.format("%0"+ n +"d", Integer.parseInt(Integer.toBinaryString(i)));
            result.add(bin);
        }
        result.sort((o1, o2) -> {
            int cnt1 = Integer.bitCount(Integer.parseInt(o1, 2));
            int cnt2 = Integer.bitCount(Integer.parseInt(o2, 2));

            String rev1 = new StringBuilder(o1).reverse().toString();
            String rev2 = new StringBuilder(o2).reverse().toString();
            return cnt1 != cnt2 ? Integer.compare(cnt1, cnt2) : rev1.compareTo(rev2);
        });
        System.out.println(result.indexOf(input));
    }
}
