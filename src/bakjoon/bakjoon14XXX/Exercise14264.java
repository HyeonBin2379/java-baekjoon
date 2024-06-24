package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise14264 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long len = Integer.parseInt(br.readLine());
        double s = (len*len)*Math.sqrt(3)/4;
        System.out.println(s);
    }
}
