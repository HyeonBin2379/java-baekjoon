package bakjoon.bakjoon27XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise27325 {
    private static final int[] box = {1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        char[] cmd = br.readLine().toCharArray();
        int now = 0, next = -1;
        int count = 0;
        for (int i = 0; i < len; i++) {
            switch (cmd[i]) {
                case 'L' -> next = (now == 0) ? 0 : now - 1;
                case 'R' -> next = (now == 2) ? 2 : now + 1;
            }
            if (next == 2) {
                count++;
            }
            swap(now, next);
            now = next;
        }
        System.out.println(count);
    }

    public static void swap(int a, int b) {
        int temp = box[a];
        box[a] = box[b];
        box[b] = temp;
    }
}
