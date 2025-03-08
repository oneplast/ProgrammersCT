import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> result = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for (String line : record) {
            String[] splitBits = line.split(" ");
            if (splitBits[0].equals("Enter") || splitBits[0].equals("Change")) {
                map.put(splitBits[1], splitBits[2]);
            }
        }

        String command = "";
        String id = "";
        for (int i = 0; i < record.length; i++) {
            String[] splitBits = record[i].split(" ");
            command = splitBits[0];
            id = splitBits[1];

            if (command.equals("Enter")) {
                result.add(map.get(id) + "님이 들어왔습니다.");
            } else if (command.equals("Leave")) {
                result.add(map.get(id) + "님이 나갔습니다.");
            }
        }

        return result.toArray(new String[0]);
    }
}