class Solution {
    public String solution(String polynomial) {
        int includeX = 0;
        int rest = 0;
        String[] splits = polynomial.split(" \\+ ");

        for (String split : splits) {
            if (split.endsWith("x")) {
                split = split.replace("x", "");
                includeX += split.isEmpty() ? 1 : Integer.parseInt(split);
            } else {
                rest += Integer.parseInt(split);
            }
        }

        if (includeX > 0 && rest > 0) {
            return includeX == 1 ? "x + " + rest : includeX + "x + " + rest;
        } else if (rest > 0) {
            return String.valueOf(rest);
        } else if (includeX > 0){
            return includeX == 1 ? "x" : includeX + "x";
        }
        
        return "0";
    }
}
