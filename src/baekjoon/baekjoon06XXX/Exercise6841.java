package baekjoon.baekjoon06XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Exercise6841 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> shortForm = new ArrayList<>(List.of(
                "CU", ":-)", ":-(", ";-)",
                ":-P","(~.~)","TA","CCC",
                "CUZ","TY","YW","TTYL"
        ));
        List<String> translation = new ArrayList<>(List.of(
                "see you", "I’m happy", "I’m unhappy", "wink",
                "stick out my tongue", "sleepy", "totally awesome", "Canadian Computing Competition",
                "because", "thank-you", "you’re welcome", "talk to you later"
        ));

        while (true) {
            String input = br.readLine();
            if (input.equals("TTYL")) {
                bw.write(translation.get(shortForm.indexOf(input)) + "\n");
                break;
            }
            if (shortForm.contains(input)) {
                bw.write(translation.get(shortForm.indexOf(input)) + "\n");
            } else {
                bw.write(input + "\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
