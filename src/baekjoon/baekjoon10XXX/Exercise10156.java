package baekjoon.baekjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise10156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int unit = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        br.close();

        System.out.println((unit*count < money) ? 0 : unit*count - money);
    }
}
