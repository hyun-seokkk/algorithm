import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution {

	private static int T, N;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		int total = (1 << 10) -1; // 모든 숫자가 등장했을 때의 값
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int visited = 0;
			int count=0;
			
			
			while(true) {
				count++;
				char[] arr = String.valueOf(N * count).toCharArray();
				for(char c : arr) {
					int num = c - '0';
					visited = visited | (1<<num);
				}
				if(total == visited) {
					System.out.printf("#%d %d\n",tc, N*count);
					break;
				}
			}
			
		
		}
	}

}
