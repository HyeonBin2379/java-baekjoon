package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise17094 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int count = (int) Arrays.stream(br.readLine().split("")).filter(s -> s.equals("2")).count();
        if (count > len-count) {
            System.out.println(2);
        } else if (count == len-count) {
            System.out.println("yee");
        } else {
            System.out.println("e");
        }
    }
}
