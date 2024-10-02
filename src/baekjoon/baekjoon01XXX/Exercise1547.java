package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1547 {
    private static final boolean[] cup = {true, false, false};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            swap(from-1, to-1);
        }

        int index = -1;
        for (int i = 0; i < 3; i++) {
            if (cup[i]) {
                index = (i+1);
                break;
            }
        }
        System.out.println(index);
    }

    public static void swap(int from, int to) {
        boolean temp = cup[from];
        cup[from] = cup[to];
        cup[to] = temp;
    }
}
