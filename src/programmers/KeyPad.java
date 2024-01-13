package programmers;

class KeyPadSolution {
    private final int[][] keypad = {{3,1}, {0,0}, {0,1}, {0,2}, {1,0}, {1,1}, {1,2}, {2,0}, {2,1}, {2,2}};
    private int[] leftHand = {3,0};
    private int[] rightHand = {3,2};

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        for (int num : numbers) {
            if (num % 3 == 1) {
                answer.append("L");
                leftHand = keypad[num].clone();
            } else if (num > 0 && num % 3 == 0) {
                answer.append("R");
                rightHand = keypad[num].clone();
            } else {
                int leftDist = getDistance(num, leftHand);
                int rightDist = getDistance(num, rightHand);
                if ((leftDist > rightDist) || (leftDist == rightDist && hand.equals("left"))) {
                    answer.append("L");
                    leftHand = keypad[num].clone();
                } else if (leftDist < rightDist || hand.equals("right")) {
                    answer.append("R");
                    rightHand = keypad[num].clone();
                }
            }
        }
        return answer.toString();
    }
    public int getDistance(int num, int[] hand) {
        return Math.abs(keypad[num][0]-hand[0]) + Math.abs(keypad[num][1]-hand[1]);
    }
}
public class KeyPad {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(new KeyPadSolution().solution(numbers, hand));
    }
}
