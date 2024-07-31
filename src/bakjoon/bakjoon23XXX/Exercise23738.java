package bakjoon.bakjoon23XXX;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Exercise23738 {

    private static final Map<String, String> letter = Map.of(
            "B", "v", "E", "ye", "H", "n", "P", "r",
            "C", "s", "Y", "u", "X", "h"
    );

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        for (Entry<String, String> entry : letter.entrySet()) {
            input = input.replaceAll(entry.getKey(), entry.getValue());
        }
        System.out.println(input.toLowerCase());
    }
}
