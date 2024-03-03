package bakjoon;

import java.io.*;
import java.text.*;
import java.time.*;
import java.util.*;

public class Exercise6845 {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LocalDate election = LocalDate.of(2007, 2, 27);
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            LocalDate birth = LocalDate.of(input[0], input[1], input[2]);
            Period diff = Period.between(birth, election);
            System.out.println(diff.getYears() >= 18 ? "Yes" : "No");
        }
    }
}
