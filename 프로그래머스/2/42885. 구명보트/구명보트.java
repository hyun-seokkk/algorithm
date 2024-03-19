import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int idx = 0;
        
        for(int j=people.length-1; idx<=j; j--) {
            if(people[idx] + people[j] <= limit) {
                idx++;
            }
            answer++;
        }
        
        return answer;
    }
}