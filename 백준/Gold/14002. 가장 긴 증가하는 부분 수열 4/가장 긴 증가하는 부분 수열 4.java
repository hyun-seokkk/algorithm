import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int n,arr[],dp[], res=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j]){
	                   dp[i] = Math.max(dp[j] + 1, dp[i]);

	                   res = Math.max(dp[i], res);
	                }
			}
		}
        System.out.println(res);
		
		Stack<Integer> s = new Stack<>();
		for(int i=n; i>=1; i--) {
			if(dp[i] == res) {
				s.push(arr[i]);
				res--;
			}
		}
		
		while(!s.isEmpty()) {
			System.out.print(s.pop()+" ");
		}
	}

}