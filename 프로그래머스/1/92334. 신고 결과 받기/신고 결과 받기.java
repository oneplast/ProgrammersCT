import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] result = new int[id_list.length];
        Map<String, Integer> reportedMap = new HashMap<>();
        Map<String, List<String>> resultMap = new HashMap<>();

        for (String rep : report) {
            String[] bits = rep.split(" ");
            String reportUser = bits[0];
            String reportedUser = bits[1];

            if (resultMap.containsKey(reportUser) && resultMap.get(reportUser).contains(reportedUser)) {
                continue;
            }

            reportedMap.put(reportedUser, reportedMap.getOrDefault(reportedUser, 0) + 1);

            resultMap.putIfAbsent(reportUser, new ArrayList<>());
            resultMap.get(reportUser).add(reportedUser);
        }

        int idx = 0;
        for (String id : id_list) {
            if (!resultMap.containsKey(id)) {
                idx++;
                continue;
            }

            List<String> reportedUsers = resultMap.get(id);

            int succeed = 0;
            for (String reportedUser : reportedUsers) {
                if (reportedMap.get(reportedUser) >= k) {
                    succeed++;
                }
            }

            result[idx++] = succeed;
        }

        return result;
    }
}