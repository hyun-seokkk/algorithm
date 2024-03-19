import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i = 0 ; i < reserve.length;i++){
            for(int j = 0 ; j < lost.length; j++){
                if(reserve[i] == lost[j]){
                    answer++;
                    reserve[i] = -1;
                    lost[j] = -1;
                    
                }
            }
        }

        for(int i = 0 ; i < reserve.length; i++){
            for(int j = 0 ; j < lost.length; j++){
                if(reserve[i] != -1 && lost[j] != -1){                    
                    if(reserve[i] - lost[j] == 1 || reserve[i] - lost[j] == -1){                        
                        answer++;
                        reserve[i] = -1;
                        lost[j] = -1;
                        
                    }
                }
            }
        }
        return answer;
    }
}