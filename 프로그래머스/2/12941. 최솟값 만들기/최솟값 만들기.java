import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        ArrayList listB = new ArrayList();
        
        for (int i=0; i<B.length; i++) listB.add(B[i]);
        listB.sort(Comparator.reverseOrder());
        
        for (int i=0; i<A.length; i++) answer += A[i] * (int)listB.get(i);
        return answer;
    }
}