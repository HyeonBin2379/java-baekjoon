package bakjoon.bakjoon21XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise21591 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
        if (size[0]-size[2] >= 2 && size[1]-size[3] >= 2) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
