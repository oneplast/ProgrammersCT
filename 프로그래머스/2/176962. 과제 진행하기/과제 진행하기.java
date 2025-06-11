import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        Arrays.sort(plans, (a, b) -> getMinute(a[1]) - getMinute(b[1]));
        Stack<Study> stack = new Stack<>();
        List<String> completedList = new ArrayList<>();

        int curTime = getMinute(plans[0][1]);
        Study cur = new Study(plans[0][0], getMinute(plans[0][1]), Integer.parseInt(plans[0][2]));

        for (int i = 1; i < plans.length; i++) {
            String[] plan = plans[i];
            int newStart = getMinute(plan[1]);
            int diff = newStart - curTime;
            
            if (cur.playTime <= diff) {
                curTime += cur.playTime;
                completedList.add(cur.name);
                
                while (!stack.isEmpty() && (newStart - curTime > 0)) {
                    Study study = stack.pop();
                    int newDiff = newStart - curTime;

                    if (study.playTime <= newDiff) {
                        curTime += study.playTime;
                        completedList.add(study.name);
                    } else {
                        study.playTime -= newDiff;
                        stack.push(study);
                        curTime = newStart;
                        break;
                    }
                }
                cur = new Study(plan[0], newStart, Integer.parseInt(plan[2]));
                curTime = newStart;
            } else {
                cur.playTime -= diff;
                stack.push(cur);
                cur = new Study(plan[0], newStart, Integer.parseInt(plan[2]));
                curTime = newStart;
            }
        }

        completedList.add(cur.name);
        
        while (!stack.isEmpty()) {
            completedList.add(stack.pop().name);
        }

        return completedList.toArray(new String[0]);
    }

    private int getMinute(String time) {
        String[] bits = time.split(":");
        return Integer.parseInt(bits[1]) + (Integer.parseInt(bits[0]) * 60);
    }

    static class Study {
        String name;
        int start;
        int playTime;

        public Study(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
    }
}