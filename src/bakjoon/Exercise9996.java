package bakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercise9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        for (int i = 0; i < testCase; i++) {
            String str = br.readLine();
            if (pattern.indexOf("*") == 0 || pattern.indexOf("*") == pattern.length()-1) {
                String token = pattern.replace("*", "");
                if (pattern.indexOf("*") == 0) {
                    bw.write(str.endsWith(token) ? "DA\n" : "NE\n");
                } else {
                    bw.write(str.startsWith(token) ? "DA\n" : "NE\n");
                }
            } else {
                String[] tokens = pattern.split("[*]", 2);
                if (tokens[0].length() + tokens[1].length() > str.length()) {
                    bw.write("NE\n");
                } else {
                    bw.write(str.startsWith(tokens[0]) && str.endsWith(tokens[1]) ? "DA\n" : "NE\n");
                }
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
