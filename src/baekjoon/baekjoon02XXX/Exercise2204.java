package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exercise2204 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int num = Integer.parseInt(br.readLine());
            List<String> dictionary = new ArrayList<>();
            if (num == 0) {
                break;
            }
            for (int i = 0; i < num; i++) {
                String word = br.readLine();
                dictionary.add(word);
            }
            dictionary.sort(Comparator.comparing(String::toLowerCase));
            sb.append(dictionary.get(0)).append("\n");
        }
        System.out.print(sb);
    }
}
