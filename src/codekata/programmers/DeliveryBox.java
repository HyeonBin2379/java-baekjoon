package codekata.programmers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DeliveryBox {

	private Queue<Integer> mainBelt;
	private Deque<Integer> subBelt;

	public int solution(int[] order) {
		mainBelt = IntStream.rangeClosed(1, order.length)
				.boxed()
				.collect(Collectors.toCollection(LinkedList::new));
		subBelt = new ArrayDeque<>();

		int answer = 0;
		for (int next : order) {
			// 재배치를 통해 순서를 조정할 수 없으면 즉시 종료
			if (!canRelocate(next)) {
				break;
			}
			answer++;
		}
		return answer;
	}

	private boolean canRelocate(int nextNum) {
		// 보조 컨테이너 벨트에서 상자를 꺼낼 수 있는지 확인
		if (!subBelt.isEmpty() && subBelt.peek() == nextNum) {
			subBelt.pop();
			return true;
		}
		// 메인 컨테이너 벨트의 상자를 옮기면서 순서를 조정할 수 있는지
		while (!mainBelt.isEmpty()) {
			int boxNum = mainBelt.poll();
			if (boxNum == nextNum) {
				return true;
			}
			subBelt.push(boxNum);
		}
		// 메인 컨테이너 벨트와 보조 컨테이너 벨트로 상자 순서 조정 불가
		return false;
	}

	public static void main(String[] args) {
		int[] order = {4, 3, 1, 2, 5};
		int result = new DeliveryBox().solution(order);
		System.out.println(result);
	}
}
