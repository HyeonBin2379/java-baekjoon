package codekata.programmers;

import java.util.*;

public class OpenChatting {

	private final Map<String, String> nickname = new HashMap<>();
	private final Map<String, String> chatLog = new LinkedHashMap<>();

	public String[] solution(String[] record) {
		for (String message : record) {
			String[] tokens = message.split(" ");
			switch (tokens[0]) {
				case "Enter", "Change":
					nickname.put(tokens[1], tokens[2]);
					break;
			}
		}

		List<String> answer = new ArrayList<>();
		for (String message : record) {
			String[] tokens = message.split(" ");
			switch (tokens[0]) {
				case "Enter":
					answer.add(String.format("%s님이 들어왔습니다.", nickname.get(tokens[1])));
					break;
				case "Leave":
					answer.add(String.format("%s님이 나갔습니다.", nickname.get(tokens[1])));
					break;
			}
		}
		return answer.toArray(new String[0]);
	}

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] result = new OpenChatting().solution(record);
		System.out.println(Arrays.toString(result));
	}
}
