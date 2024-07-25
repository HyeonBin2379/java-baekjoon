package bakjoon.bakjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise10262 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int gunnar = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();
        int emma = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();
        if (gunnar > emma) {
            System.out.println("Gunnar");
        } else if (gunnar < emma) {
            System.out.println("Emma");
        } else {
            System.out.println("Tie");
        }
    }
}
