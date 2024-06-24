package bakjoon.bakjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise24803 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int g = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int total = g*3 + s*2 + c;
        if (total >= 8) {
            System.out.println("Province or Gold");
        } else if (total >= 6) {
            System.out.println("Duchy or Gold");
        } else if (total == 5) {
            System.out.println("Duchy or Silver");
        } else if (total >= 3) {
            System.out.println("Estate or Silver");
        } else if (total == 2) {
            System.out.println("Estate or Copper");
        } else {
            System.out.println("Copper");
        }
    }
}
