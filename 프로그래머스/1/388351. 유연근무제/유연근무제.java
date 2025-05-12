class Solution {

    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            boolean isPossible = true;
            int limitTime = this.calculateTime(schedules[i]);

            for (int j = 0; j < timelogs[i].length; j++) {
                int curDay = startday + j;
                if (this.shouldCheck(curDay) && limitTime < timelogs[i][j]) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                answer++;
            }
        }

        return answer;
    }

    private int calculateTime(int schedule) {
        int hour = schedule / 100;
        int minute = schedule % 100;
        int calMin = minute + 10;

        return hour * 100 + (calMin / 60) * 100 + (calMin % 60);
    }

    private boolean shouldCheck(int curDay) {
        int dayOfWeek = curDay % 7;
        return dayOfWeek > 0 && dayOfWeek <= 5;
    }
}