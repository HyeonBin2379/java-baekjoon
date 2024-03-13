package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise11586 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> mirror = new ArrayList<>();
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            String line = br.readLine();
            mirror.add(line);
        }
        int status = Integer.parseInt(br.readLine());

        switch (status) {
            case 1 -> {
                for (int i = 0; i < size; i++) {
                    System.out.println(mirror.get(i));
                }
            }
            case 2 -> {
                for (int i = 0; i < size; i++) {
                    StringBuilder sb = new StringBuilder(mirror.get(i));
                    System.out.println(sb.reverse());
                }
            }
            case 3 -> {
                for (int i = size - 1; i >= 0; i--) {
                    System.out.println(mirror.get(i));
                }
            }
        }
    }
}
