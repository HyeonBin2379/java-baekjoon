package baekjoon.baekjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise6243 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int answer = 0;
            while (true) {
                String[] tokens = br.readLine().split(" ");
                if (tokens[0].equals("0")) {
                    System.out.println(answer);
                    break;
                }
                if (tokens[0].equals("#")) {
                    return;
                }
                double mile = Double.parseDouble(tokens[2]);
                switch (tokens[3]) {
                    case "F" -> answer += mile * 2;
                    case "B" -> answer += mile + Math.ceil(mile/2);
                    case "Y" -> answer += Math.max(mile, 500);
                }
            }
        }
    }
}
