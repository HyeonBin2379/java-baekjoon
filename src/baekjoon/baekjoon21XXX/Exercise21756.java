package baekjoon.baekjoon21XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise21756 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= len; i++) {
            arr.add(i);
        }

        while (arr.size() > 1) {
            for (int i = 0; i < arr.size(); i++) {
                arr.remove(i);
            }
        }
        System.out.println(arr.get(0));
    }
}
