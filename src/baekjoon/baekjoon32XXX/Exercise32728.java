package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise32728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[] toys = br.readLine().split("", n);
        String[] result = new String[3];
        Arrays.fill(result, "");
        for (String toy : toys) {
            switch (toy) {
                case "r" -> {
                    for (int i = 0; i < 3; i++) {
                        if (result[(1+i) % 3].length() < k) {
                            result[(1+i) % 3] += toy;
                            break;
                        }
                    }
                }
                case "p" -> {
                    for (int i = 0; i < 3; i++) {
                        if (result[(2+i) % 3].length() < k) {
                            result[(2+i) % 3] += toy;
                            break;
                        }
                    }
                }
                case "s" -> {
                    for (int i = 0; i < 3; i++) {
                        if (result[i].length() < k) {
                            result[i] += toy;
                            break;
                        }
                    }
                }
            }
        }
        Arrays.stream(result).forEach(System.out::println);
    }
}
