package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise29467 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> str = new ArrayList<>();
        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            str.add(input.substring(i));
        }
        Collections.sort(str);
        System.out.println(str.get(str.size()-1));
    }
}
