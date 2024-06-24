package bakjoon.bakjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise30032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        char[][] input = new char[size][size];
        for (int i = 0; i < size; i++) {
            input[i] = br.readLine().toCharArray();
            for (int j = 0; j < size; j++) {
                if (d == 1) {
                    switch (input[i][j]) {
                        case 'd' -> input[i][j] = 'q';
                        case 'b' -> input[i][j] = 'p';
                        case 'q' -> input[i][j] = 'd';
                        case 'p' -> input[i][j] = 'b';
                    }
                } else {
                    switch (input[i][j]) {
                        case 'd' -> input[i][j] = 'b';
                        case 'b' -> input[i][j] = 'd';
                        case 'q' -> input[i][j] = 'p';
                        case 'p' -> input[i][j] = 'q';
                    }
                }
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.println(new String(input[i]));
        }
    }
}
