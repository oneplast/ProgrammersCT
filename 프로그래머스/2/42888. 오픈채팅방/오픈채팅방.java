import java.util.*;

class Solution {
	static final String ENTER = "Enter";
	static final String LEAVE = "Leave";
	static final String CHANGE = "Change";
	static final String ENTER_CMD = "님이 들어왔습니다.";
	static final String LEAVE_CMD = "님이 나갔습니다.";

	public String[] solution(String[] record) {
		Map<String, String> idMap = new HashMap<>();

		String[] cmdBits;
		String cmd, id;
		for (String cmds : record) {
			cmdBits = cmds.split("\\s+");
			cmd = cmdBits[0];
			id = cmdBits[1];

			if (cmd.equals(ENTER) || cmd.equals(CHANGE)) {
				idMap.put(id, cmdBits[2]);
			}
		}

		List<String> results = new ArrayList<>();
		for (int i = 0; i < record.length; i++) {
			cmdBits = record[i].split("\\s+");
			cmd = cmdBits[0];
			id = cmdBits[1];

			if (cmd.equals(ENTER)) {
				results.add(idMap.get(id) + ENTER_CMD);
			} else if (cmd.equals(LEAVE)) {
				results.add(idMap.get(id) + LEAVE_CMD);
			}
		}

		return results.toArray(new String[0]);
	}
}