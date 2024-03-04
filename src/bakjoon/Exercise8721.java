package bakjoon;

import java.io.*;
import java.util.*;

public class Exercise8721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int i = 0, count = 0;
        while (i < len) {
            if (input[i] != (count+1)) {
                i++;
            } else {
                count++;
            }
        }
        System.out.println(len-count);
    }
}
