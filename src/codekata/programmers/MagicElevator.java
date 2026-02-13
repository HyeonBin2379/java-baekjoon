package codekata.programmers;

public class MagicElevator {

    public int solution(int storey) {
        int answer = 0;

        // storey에서 시작 -> 최종적으로 0이 되어야 함
        // 1
        while (storey > 0) {
            int d = storey % 10;

            answer += Math.min(10-d, d);
            storey /= 10;

            if (d >= 5) {
                // 현재 자릿수가 5일 때, 다음 자릿수를 증가(ex: 95 -> +5 적용하여 100으로 만든 후 진행)
                if (d > 5 || storey % 10 >= 5) {
                    storey += 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int storey = 2554;
        int result = new MagicElevator().solution(storey);
        System.out.println(result);
    }
}
