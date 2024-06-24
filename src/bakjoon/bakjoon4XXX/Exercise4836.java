package bakjoon.bakjoon4XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Exercise4836 {

    private static String[] dance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;

        while ((input = br.readLine()) != null) {
            dance = input.split(" ");

            List<String> wrongSet = new ArrayList<>();
            if (!isMatchedRule1()) {
                wrongSet.add(Integer.toString(1));
            }
            if (!isMatchedRule2()) {
                wrongSet.add(Integer.toString(2));
            }
            if (!isMatchedRule3()) {
                wrongSet.add(Integer.toString(3));
            }
            if (!isMatchedRule4()) {
                wrongSet.add(Integer.toString(4));
            }
            if (!isMatchedRule5()) {
                wrongSet.add(Integer.toString(5));
            }

            String wrong;
            switch (wrongSet.size()) {
                case 0 -> sb.append("form ok: ")
                        .append(String.join(" ", dance))
                        .append("\n");
                case 1 -> sb.append(String.format("form error %s: ", wrongSet.get(0)))
                        .append(String.join(" ", dance))
                        .append("\n");
                case 2 -> {
                    wrong = String.join(" and ", wrongSet);
                    sb.append(String.format("form errors %s: ", wrong))
                            .append(String.join(" ", dance))
                            .append("\n");
                }
                default -> {
                    wrong = String.join(", ", wrongSet.subList(0, wrongSet.size() - 1))
                            + " and "
                            + wrongSet.get(wrongSet.size() - 1);
                    sb.append(String.format("form errors %s: ", wrong))
                            .append(String.join(" ", dance))
                            .append("\n");
                }
            }
        }
        System.out.print(sb);
    }

    private static boolean isMatchedRule1() {
        int[] dip = IntStream.rangeClosed(0, dance.length-1).filter(index -> dance[index].equals("dip")).toArray();
        for (int j : dip) {
            boolean[] cases = new boolean[3];

            if (j + 1 != dance.length && dance[j + 1].equals("twirl")) {
                cases[0] = true;
            }
            if (j >= 1 && dance[j - 1].equals("jiggle")) {
                cases[1] = true;
            }
            if (j >= 2 && dance[j - 2].equals("jiggle")) {
                cases[2] = true;
            }
            if (!(cases[0] || cases[1] || cases[2])) {
                dance[j] = dance[j].toUpperCase();
                return false;
            }
        }
        return true;
    }

    private static boolean isMatchedRule2() {
        return String.join(" ", dance).endsWith("clap stomp clap");
    }

    private static boolean isMatchedRule3() {
        List<String> temp = Arrays.asList(dance);
        return !temp.contains("twirl") || temp.contains("hop");
    }

    private static boolean isMatchedRule4() {
        return !String.join(" ", dance).startsWith("jiggle");
    }

    private static boolean isMatchedRule5() {
        return Arrays.stream(dance).anyMatch(s -> s.equals("dip") || s.equals("DIP"));
    }
}
