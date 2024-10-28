package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Exercise11645 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Set<String> cities = new HashSet<>();
            while (n-- > 0) {
                cities.add(br.readLine());
            }
            System.out.println(cities.size());
        }
    }
}
