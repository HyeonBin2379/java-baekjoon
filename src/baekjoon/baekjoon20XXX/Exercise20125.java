package baekjoon.baekjoon20XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Exercise20125 {

    private static int n;
    private static char[][] map;
    private static int[] heart;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        heart = new int[2];
        findHeart();

        int[] bodySize = new int[5];
        for (int i = 0; i < n; i++) {
            if (map[heart[0]][i] == '*') {
                if (i < heart[1]) {
                    bodySize[0]++;
                } else if (i > heart[1]) {
                    bodySize[1]++;
                }
            }
        }
        for (int i = heart[0]+1; i < n; i++) {
            if (map[i][heart[1]] == '*') {
                bodySize[2]++;
            }
            if (map[i][heart[1]-1] == '*') {
                bodySize[3]++;
            }
            if (map[i][heart[1]+1] == '*') {
                bodySize[4]++;
            }
        }

        System.out.println((heart[0]+1) + " " + (heart[1]+1));
        System.out.println(Arrays.stream(bodySize).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
    }

    private static void findHeart() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '*') {
                    heart[0] = i+1;
                    heart[1] = j;
                    return;
                }
            }
        }
    }
}
