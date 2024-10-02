package baekjoon.baekjoon29XXX;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Exercise29701 {
    private static final Map<String, String> morseCode = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        makeMorseCode();
        String answer = Arrays.stream(br.readLine().split(" ", len)).map(morseCode::get).collect(Collectors.joining());
        System.out.println(answer);
    }

    public static void makeMorseCode() {
        morseCode.put(".-", "A");
        morseCode.put("-...", "B");
        morseCode.put("-.-.", "C");
        morseCode.put("-..", "D");
        morseCode.put(".", "E");
        morseCode.put("..-.", "F");
        morseCode.put("--.", "G");
        morseCode.put("....", "H");
        morseCode.put("..", "I");
        morseCode.put(".---", "J");
        morseCode.put("-.-", "K");
        morseCode.put(".-..", "L");
        morseCode.put("--", "M");
        morseCode.put("-.", "N");
        morseCode.put("---", "O");
        morseCode.put(".--.", "P");
        morseCode.put("--.-", "Q");
        morseCode.put(".-.", "R");
        morseCode.put("...", "S");
        morseCode.put("-", "T");
        morseCode.put("..-", "U");
        morseCode.put("...-", "V");
        morseCode.put(".--", "W");
        morseCode.put("-..-", "X");
        morseCode.put("-.--", "Y");
        morseCode.put("--..", "Z");
        morseCode.put(".----", "1");
        morseCode.put("..---", "2");
        morseCode.put("...--", "3");
        morseCode.put("....-", "4");
        morseCode.put(".....", "5");
        morseCode.put("-....", "6");
        morseCode.put("--...", "7");
        morseCode.put("---..", "8");
        morseCode.put("----.", "9");
        morseCode.put("-----", "0");
        morseCode.put("--..--", ",");
        morseCode.put(".-.-.-", ".");
        morseCode.put("..--..", "?");
        morseCode.put("---...", ":");
        morseCode.put("-....-", "-");
        morseCode.put(".--.-.", "@");
    }
}
