class Solution {
    public int solution(String my_string) {
        my_string = my_string.replaceAll(" - ", " + -");
        String[] splits = my_string.split(" \\+ ");
        int sum = 0;

        boolean isMinus = false;
        for (String split : splits) {
            if (split.equals("-")) {
                isMinus = true;
                continue;
            }

            int num = Integer.parseInt(split);
            sum = isMinus ? sum - num : sum + num;
        }

        return sum;
    }
}


