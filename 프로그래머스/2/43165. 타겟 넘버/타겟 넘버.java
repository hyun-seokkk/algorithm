class Solution {
    
    private static boolean[][] v;
    private static int cnt;
    private static int[] pm = {1,-1};
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        v = new boolean[numbers.length][2];
        int sum = 0;
        dfs(0, numbers, target, sum);
        return cnt;
    }
    
    public void dfs(int idx, int[] numbers, int target, int sum) {
        if(idx >= numbers.length) {
            if(sum == target) {
                cnt++;
            }
            return;
        }
        for(int i=0; i<2; i++) {
            if(!v[idx][i]) {
                if(i==0) {
                    v[idx][i] = true;
                    sum += numbers[idx];
                    dfs(idx+1, numbers, target, sum);
                    sum -= numbers[idx];
                    v[idx][i] = false;
                } else {
                    v[idx][i] = true;
                    sum -= numbers[idx];
                    dfs(idx+1, numbers, target, sum);
                    sum += numbers[idx];
                    v[idx][i] = false;                    
                }
            }
        }
    }
    
}