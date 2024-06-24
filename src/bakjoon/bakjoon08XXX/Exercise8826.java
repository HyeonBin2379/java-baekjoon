package bakjoon.bakjoon08XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise8826 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int z = Integer.parseInt(br.readLine());
        for (int i = 0; i < z; i++) {
            int n = Integer.parseInt(br.readLine());
            String route = br.readLine();
            int row = 0, col = 0;
            for (int j = 0; j < n; j++) {
                switch (route.charAt(j)) {
                    case 'N'-> row--;
                    case 'S' -> row++;
                    case 'W' -> col--;
                    case 'E' -> col++;
                }
            }
            System.out.println(Math.abs(row) + Math.abs(col));
        }
    }
}
