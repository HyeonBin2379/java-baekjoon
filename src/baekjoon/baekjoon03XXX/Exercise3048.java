package baekjoon.baekjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise3048 {

    private static char[] ants;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        String ant1 = br.readLine();
        String ant2 = br.readLine();
        int t = Integer.parseInt(br.readLine());

        ants = (new StringBuilder(ant1).reverse() + ant2).toCharArray();
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < ants.length-1; j++) {
                if (ant1.contains(String.valueOf(ants[j])) && ant2.contains(String.valueOf(ants[j+1]))) {
                    swap(j, j+1);
                    if (ants[j+1] == ant1.charAt(0)) {
                        break;
                    }
                }
            }
        }
        System.out.println(new String(ants));
    }

    private static void swap(int i, int j) {
        char temp = ants[i];
        ants[i] = ants[j];
        ants[j] = temp;
    }
}
