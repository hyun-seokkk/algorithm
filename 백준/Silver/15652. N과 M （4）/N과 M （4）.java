import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int M;
	static int[] sel;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sel = new int[M];
		
		recursive(0, 0);
		System.out.println(sb);
	}
	private static void recursive(int idx, int loc) {
		if(idx == M) {
			for(int ele : sel) {
				sb.append(ele+" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i=loc; i<N; i++) {
			sel[idx] = i+1;
			recursive(idx+1, i);
		}
	}

}
