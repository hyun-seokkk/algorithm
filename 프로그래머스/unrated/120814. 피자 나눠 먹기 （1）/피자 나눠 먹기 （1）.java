class Solution {
    public int solution(int n) {
        int answer = n/7;
        n %= 7;
        
        return (n == 0) ? answer : answer+1;
    }
}