class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String result = "";

        for (String[] dbInfo : db) {
            if (dbInfo[0].equals(id_pw[0])) {
                if (dbInfo[1].equals(id_pw[1])) {
                    return "login";
                }
                if (result.isEmpty()) result = "wrong pw";
            }
        }

        return result.isEmpty() ? "fail" : result;
    }
}
