package bakjoon.bakjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise15098 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] word = br.readLine().split(" ");
        List<String> usedWord = new ArrayList<>();
        for (String s : word) {
            if (usedWord.contains(s)) {
                System.out.println("no");
                return;
            }
            usedWord.add(s);
        }
        System.out.println("yes");
    }
}
