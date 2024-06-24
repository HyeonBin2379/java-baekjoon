package bakjoon.bakjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise30585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int popped = 0;
        for (int i = 0; i < row; i++) {
            String input = br.readLine();
            popped += (int) input.chars().filter(value -> value == '1').count();
        }
        System.out.println(Math.min(popped, (row*col-popped)));
    }
}
