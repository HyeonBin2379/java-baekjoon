package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise26041 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] phoneNum = br.readLine().split(" ");
        String prefix = br.readLine();
        int count = (int) Arrays.stream(phoneNum).filter(s -> !s.equals(prefix) && s.startsWith(prefix)).count();
        System.out.println(count);
    }
}
