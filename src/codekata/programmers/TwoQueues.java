package codekata.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueues {

	private static class CustomQueue {

		private Queue<Long> queue;
		private Long totalSum = 0L;

		CustomQueue(int[] queue) {
			this.queue = new LinkedList<>();
			for (int num : queue) {
				this.queue.add((long)num);
				totalSum += num;
			}
		}

		void enqueue(long num) {
			queue.offer(num);
			totalSum += num;
		}

		Long dequeue() {
			Long num = queue.poll();
			totalSum -= num;
			return num;
		}

		boolean isEndCondition(CustomQueue queue) {
			return (long) this.totalSum == queue.totalSum;
		}

		int size() {
			return queue.size();
		}
	}

	public int solution(int[] queue1, int[] queue2) {
		CustomQueue customQueue1 = new CustomQueue(queue1);
		CustomQueue customQueue2 = new CustomQueue(queue2);

		int answer = 0;
		int limit = customQueue1.size() * 3;

		while (!customQueue1.isEndCondition(customQueue2) && answer < limit) {
			if (customQueue1.totalSum > customQueue2.totalSum) {
				pollOffer(customQueue1, customQueue2);
			} else {
				pollOffer(customQueue2, customQueue1);
			}
			answer++;
		}
		return answer >= limit ? -1 : answer;
	}

	private void pollOffer(CustomQueue from, CustomQueue to) {
		Long num = from.dequeue();
		to.enqueue(num);
	}

	public static void main(String[] args) {
		int[] queue1 = {3, 2, 7, 2};
		int[] queue2 = {4, 6, 5, 1};
		int result = new TwoQueues().solution(queue1, queue2);
		System.out.println(result);
	}
}
