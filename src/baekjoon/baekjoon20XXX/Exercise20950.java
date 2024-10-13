package baekjoon.baekjoon20XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise20950 {

    private static class Color {
        int red, green, blue;

        public Color(int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }
    }

    private static int n, minDiff, newRed, newGreen, newBlue;
    private static Color gomduri;
    private static Color[] colors;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        colors = new Color[n];
        for (int i = 0; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());
            if (i == n) {
                gomduri = new Color(red, green, blue);
                continue;
            }
            colors[i] = new Color(red, green, blue);
        }

        minDiff = Integer.MAX_VALUE;
        search(-1, 0);
        System.out.println(minDiff);
    }

    private static int getDiff(int cnt) {
        return Math.abs(gomduri.red-newRed/cnt)
                + Math.abs(gomduri.green-newGreen/cnt)
                + Math.abs(gomduri.blue-newBlue/cnt);
    }


    private static void search(int start, int cnt) {
        if (cnt >= 2) {
            minDiff = Math.min(getDiff(cnt), minDiff);
        }
        for (int i = start+1; i < n; i++) {
            newRed += colors[i].red;
            newGreen += colors[i].green;
            newBlue += colors[i].blue;

            if (cnt < 7) {
                search(i, cnt + 1);
            }

            newRed -= colors[i].red;
            newGreen -= colors[i].green;
            newBlue -= colors[i].blue;
        }
    }
}
