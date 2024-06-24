package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise2810 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> seat = new ArrayList<>();
        int people = Integer.parseInt(br.readLine());
        String input = br.readLine();

        while (!input.isEmpty()) {
            if (input.startsWith("S")) {
                input = input.replaceFirst("S", "");
                seat.add("S");
            } else {
                input = input.replaceFirst("LL", "");
                seat.add("LL");
            }
        }
        System.out.println((people > seat.size()) ? seat.size()+1 : people);
    }
}
