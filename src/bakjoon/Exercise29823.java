package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise29823 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        int[] position = {0, 0};
        for (char c : input) {
            switch (c) {
                case 'N' -> position[1]++;
                case 'S' -> position[1]--;
                case 'W' -> position[0]--;
                case 'E' -> position[0]++;
            }
        }
        System.out.println(Arrays.stream(position).map(Math::abs).sum());
    }
}
