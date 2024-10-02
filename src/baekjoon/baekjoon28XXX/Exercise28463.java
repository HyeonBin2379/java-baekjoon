package baekjoon.baekjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Exercise28463 {

    private enum Toe {
        T("T", List.of(".OP.", ".PO.", "P..O", "O..P")),
        F("F", List.of("I..P", "P..I", ".IP.", ".PI.")),
        Lz("Lz", List.of("O..P", "P..O", ".OP.", ".PO.")),
        NONE("?", List.of("", "", "", ""));

        private final String name;
        private final List<String> trace;

        Toe(String name, List<String> trace) {
            this.name = name;
            this.trace = trace;
        }

        private static String findAnswer(String direction, String trace) {
            int idx = "SNWE".indexOf(direction);
            return Arrays.stream(Toe.values())
                    .filter(toe -> trace.equals(toe.trace.get(idx)))
                    .findFirst()
                    .orElse(NONE)
                    .name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String direction = br.readLine();
        StringBuilder trace = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            trace.append(br.readLine());
        }
        System.out.println(Toe.findAnswer(direction, trace.toString()));
    }
}
