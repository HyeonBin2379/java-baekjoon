package codekata.programmers;

import java.util.*;

public class CompressingString {

	private static class Unit {
		String str;
		int count;

		Unit(String str, int count) {
			this.str = str;
			this.count = count;
		}

		void addCount() {
			this.count++;
		}
	}

	public int solution(String s) {
		int answer = s.length();
		for (int i = 1; i <= s.length(); i++) {
			int len = compress(s, i);
			answer = Math.min(len, answer);
		}
		return answer;
	}

	private int compress(String s, int unitSize) {
		Deque<Unit> compressed = new LinkedList<>();
		for (int i = 0; i < s.length(); i += unitSize) {
			String subStr = s.substring(i, Math.min(i+unitSize, s.length()));
			if (compressed.isEmpty()) {
				compressed.add(new Unit(subStr, 1));
				continue;
			}
			Unit unit = compressed.pollLast();
			if (unit.str.equals(subStr)) {
				unit.addCount();
				compressed.offer(unit);
			} else {
				compressed.offer(unit);
				compressed.offer(new Unit(subStr, 1));
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!compressed.isEmpty()) {
			Unit unit = compressed.poll();
			if (unit.count > 1) {
				sb.append(String.format("%d%s", unit.count, unit.str));
			} else {
				sb.append(unit.str);
			}
		}
		return sb.length();
	}

	public static void main(String[] args) {
		String s = "aabbaccc";
		int result = new CompressingString().solution(s);
		System.out.println(result);
	}
}
