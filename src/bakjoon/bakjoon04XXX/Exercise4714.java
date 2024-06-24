package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercise4714 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String num = br.readLine();
            if (num.equals("-1.0")) {
                break;
            }
            double value = Double.parseDouble(num);
            bw.write(String.format("Objects weighing %.2f on Earth will weigh %.2f on the moon.\n", value, value*0.167));
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
