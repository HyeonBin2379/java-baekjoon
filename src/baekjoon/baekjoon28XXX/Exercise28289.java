package baekjoon.baekjoon28XXX;

import java.io.*;
import java.util.*;

public class Exercise28289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int student = Integer.parseInt(br.readLine());
        int soft = 0, embedded = 0, ai = 0;
        for (int i = 0; i < student; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if (g < 2) {
                continue;
            }
            switch (c) {
                case 1, 2 -> soft++;
                case 3 -> embedded++;
                case 4 -> ai++;
            }
        }
        System.out.println(soft);
        System.out.println(embedded);
        System.out.println(ai);
        System.out.println(student - soft - embedded - ai);
    }
}
