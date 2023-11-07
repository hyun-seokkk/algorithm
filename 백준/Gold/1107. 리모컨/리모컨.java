import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] numbers = new boolean[10];
    static int ans, targetNum;
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String targetNumString = st.nextToken();
        targetNum = Integer.parseInt(targetNumString);
        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int diff = Math.abs(targetNum - 100);
        if(diff <= 3) {
        	System.out.println(diff);
        	return;
        }
        
        // 고장난 버튼 없으면 
        if(cnt == 0) {
        	System.out.println(targetNumString.length());
        	return;
        }
        for (int i = 0; i < 10; i++) {
            numbers[i] = true;
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            int temp = Integer.parseInt(st.nextToken());
            numbers[temp] = false; // 고장난 버튼 false처리
        }
        
        ans = diff;
        
        for (int i = 1; i <= 6; i++) {
            sol(new char[i], 0, 0);
        }
        
        System.out.println(ans);
    }
    private static void sol(char[] arr, int idx, int k) {
        if(k == arr.length) {
            String temp = "";
            for (char ele : arr) {
                temp += ele;
            }
            ans = Math.min(ans, getDiff(Integer.parseInt(temp))+ arr.length);
            return;
        }
        
        for (int i = 0; i < 10; i++) {
            if(numbers[i]) {
                arr[idx] = (char)(i+'0');
                sol(arr, idx+1, k+1);
            }
        }
    }
    private static int getDiff(int num) {
        return Math.abs(targetNum - num);
    }

}