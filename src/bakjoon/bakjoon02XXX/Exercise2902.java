package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2902 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] names = br.readLine().split("-");

        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(name.charAt(0));
        }
        System.out.println(sb);
    }
}
