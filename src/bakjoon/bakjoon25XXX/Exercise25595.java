package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise25595 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[][] map = new int[size][size];
        for (int i = 0; i < size; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int even = 0, odd = 0;
        int sinei = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                switch (map[i][j]) {
                    case 1 -> {
                        if ((i + j) % 2 == 1) {     // 적이 위치한 행과 열의 짝홀이 다름
                            odd++;
                        } else {                    // 적이 위치한 행과 열의 짝홀이 동일
                            even++;
                        }
                    }
                    case 2 -> sinei = (i + j) % 2;    // 전장에서의 현재 위치
                }
            }
        }
        // 적의 행, 열의 짝홀 구성이 주인공과 다르면 적은 주인공의 이동경로에 없음
        if ((even == 0 && sinei == 0) || (odd == 0 && sinei == 1)) {
            System.out.println("Lena");
        } else {
            System.out.println("Kiriya");
        }
    }
}
