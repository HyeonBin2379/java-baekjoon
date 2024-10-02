package baekjoon.baekjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise24923 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String speaking = br.readLine();
        System.out.println(speaking.endsWith("eh?") ? "Canadian!" : "Imposter!");
    }
}
