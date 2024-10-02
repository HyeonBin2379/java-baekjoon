package baekjoon.baekjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise30642 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int floor = Integer.parseInt(br.readLine());
        String mascot = br.readLine();
        int now = Integer.parseInt(br.readLine());
        if (mascot.equals("annyong")) {
            if (now % 2 == 1) {
                System.out.println(now);
            } else {
                System.out.println((now + 1 <= floor ? now+1 : now-1));
            }
        } else {
            if (now % 2 == 0) {
                System.out.println(now);
            } else {
                System.out.println((now + 1 > floor ? now-1 : now+1));
            }
        }
    }
}
