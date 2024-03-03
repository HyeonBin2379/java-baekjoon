package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise26264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int student = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int bigdata = (int) input.chars().filter(value -> value == 'b').count();

        if (bigdata > student-bigdata) {
            System.out.println("bigdata?");
        } else if (bigdata == student-bigdata) {
            System.out.println("bigdata? security!");
        } else {
            System.out.println("security!");
        }
    }
}
