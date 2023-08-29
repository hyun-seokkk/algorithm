import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1 - 1
 * 2 - 1+1
 * 3 - 1+1+1 2+1 1+2 3
 * 4 - 1+1+1+1 1+1+2 1+2+1 2+1+1 2+2 1+3 3+1
 */

public class Main {
	static int[] memo;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());

		memo = new int[11];
		memo[0] = 0;
		memo[1] = 1;
		memo[2] = 2;
		memo[3] = 4;
		
		for (int i = 4; i <= 10; i++) {
			memo[i] = memo[i-3] + memo[i-2] + memo[i-1];
		}
		
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			System.out.println(memo[n]);
		}
		
		
		
	}

}
