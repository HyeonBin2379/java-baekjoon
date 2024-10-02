package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise32209 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int question = 0;
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            switch (query) {
                case 1 -> question += count;
                case 2 -> {
                    if (question - count < 0) {
                        System.out.println("Adios");
                        return;
                    }
                    question -= count;
                }
            }
        }
        System.out.println("See you next month");
    }
}
