package bakjoon.bakjoon5XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Exercise5342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> menu = new LinkedHashMap<>(Map.of(
                "Paper", 57.99,
                "Printer", 120.50,
                "Planners", 31.25,
                "Binders", 22.50,
                "Calendar", 10.95,
                "Notebooks", 11.20,
                "Ink", 66.95
        ));
        double sum = 0d;
        while (true) {
            String item = br.readLine();
            if (item.equals("EOI")) {
                break;
            }
            sum += menu.get(item);
        }
        System.out.printf("$%.2f\n", sum);
    }
}
