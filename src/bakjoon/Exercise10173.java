package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise10173 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            if (str.equals("EOI")) {
                break;
            }
            System.out.println(str.toUpperCase().contains("NEMO") ? "Found" : "Missing");
        }
    }
}
