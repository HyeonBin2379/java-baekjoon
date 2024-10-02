package baekjoon.baekjoon27XXX;

import java.io.*;
import java.util.*;

public class Exercise27983 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] x = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] l = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] color = br.readLine().split(" ");
        int a = 0, b = 0;
        for (int i = 0; i < count-1; i++) {
            for (int j = i+1; j < count; j++) {
                if (Math.abs(x[i]-x[j]) <= l[i]+l[j] && !color[i].equals(color[j])) {
                    a = i+1;
                    b = j+1;
                    break;
                }
            }
        }
        if (a > 0 && b > 0) {
            System.out.println("YES");
            System.out.println(a + " " + b);
        } else {
            System.out.println("NO");
        }
    }
}
