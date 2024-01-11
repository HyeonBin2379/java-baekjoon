package programmers;

import java.util.Stack;

class HamburgerSolution {
    private Stack<Integer> hamburger;

    public int solution(int[] ingredient) {
        int answer = 0;
        hamburger = new Stack<>();
        for (int j : ingredient) {
            hamburger.push(j);
            if (hamburger.size() > 3 && isHamburger()) {
                answer++;
                packHamburger();
            }
        }
        return answer;
    }

    public boolean isHamburger() {
        return hamburger.get(hamburger.size()-4) == 1 && hamburger.get(hamburger.size()-3) == 2
                && hamburger.get(hamburger.size()-2) == 3 && hamburger.get(hamburger.size()-1) == 1;
    }

    public void packHamburger() {
        for (int i = 0; i < 4; i++) {
            hamburger.pop();
        }
    }
}

public class Hamburger {
    public static void main(String[] args) {
        int[] ingredient = {1, 1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(new HamburgerSolution().solution(ingredient));
    }
}
