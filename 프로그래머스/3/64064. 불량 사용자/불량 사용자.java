import java.util.*;

class Solution {
    Set<Set<String>> set;
    Set<String> tempSet;

    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();
        tempSet = new HashSet<>();
        int n = user_id.length;
        int r = banned_id.length;
        dfs(user_id, banned_id, n, r, 0);

        return set.size();
    }

    private void dfs(String[] user_id, String[] banned_id, int n, int r, int depth) {
        if (depth == r) {
            set.add(new HashSet<>(tempSet));
            return;
        }

        for (String user : user_id) {
            if (!tempSet.contains(user) && isBanned(user, banned_id[depth])) {
                tempSet.add(user);
                dfs(user_id, banned_id, n, r, depth + 1);
                tempSet.remove(user);
            }
        }
    }

    private boolean isBanned(String user, String banned) {
        if (user.length() != banned.length()) {
            return false;
        }

        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) != '*' && user.charAt(i) != banned.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}