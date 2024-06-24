package bakjoon.bakjoon20XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise20436 {

    private static final String[] keyboard = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] leftPos = findPosition(st.nextToken());
        int[] rightPos = findPosition(st.nextToken());
        String[] input = br.readLine().split("");

        int answer = 0;
        for (String s : input) {
            int[] pos = findPosition(s);
            if (isLeft(pos)) {
                answer += getDistance(leftPos, pos) + 1;
                leftPos = pos.clone();
            } else {
                answer += getDistance(rightPos, pos) + 1;
                rightPos = pos.clone();
            }
        }
        System.out.println(answer);
    }

    private static int[] findPosition(String letter) {
        int[] position = new int[2];
        for (int i = 0; i < 3; i++) {
            if (keyboard[i].contains(letter)) {
                position[0] = i;
                position[1] = keyboard[i].indexOf(letter);
                break;
            }
        }
        return position;
    }

    private static int getDistance(int[] hand, int[] letter) {
        return Math.abs(hand[0]-letter[0]) + Math.abs(hand[1]-letter[1]);
    }

    private static boolean isLeft(int[] currentPos) {
        return currentPos[1] <= (keyboard[currentPos[0]].length()-1)/2;
    }
}