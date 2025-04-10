package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        while (n-- > 0) {
            String str = br.readLine();
            list.add(str);
        }

        list.sort((o1, o2) -> {
            int len1 = o1.length();
            int len2 = o2.length();

            return len1 != len2 ? Integer.compare(len1, len2) : o1.compareTo(o2);
        });

        list.stream().distinct().forEach(System.out::println);
    }
}
