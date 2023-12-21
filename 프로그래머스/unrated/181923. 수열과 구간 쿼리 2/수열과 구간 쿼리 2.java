import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        // System.out.println(queries.length);
        
        int len = queries.length;
        
        int[] answer = new int[len];

        
        for(int i=0; i<len; i++){
            int[] query = queries[i];
            
            int s = query[0];
            int e = query[1];
            int k = query[2];
            
            answer[i] = -1;
            
            
            for(int j=s; j<=e; j++){
                if(arr[j] > k) {
                    if(answer[i] == -1) {
                        answer[i] = arr[j];
                    } else {
                        if(answer[i] > arr[j]) answer[i] = arr[j];
                    }
                }
            }
        }
        
        return answer;
    }
}