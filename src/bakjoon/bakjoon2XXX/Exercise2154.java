package bakjoon.bakjoon2XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2154 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder number = new StringBuilder();
        for (int i = 1; i <= 100001; i++) {
            number.append(i);
        }
        System.out.println(number.toString().indexOf(br.readLine())+1);
    }
}
