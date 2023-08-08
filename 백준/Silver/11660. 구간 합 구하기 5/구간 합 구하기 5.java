import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static class Loc {
		int x;
		int y;
		Loc(int x, int y){
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int N, M, temp, nums[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				temp = Integer.parseInt(st.nextToken());
				nums[i][j] = nums[i][j-1] + nums[i-1][j] - nums[i-1][j-1] + temp;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			Loc first = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Loc second = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			
			System.out.println(nums[second.x][second.y] - nums[first.x-1][second.y] -nums[second.x][first.y-1] + nums[first.x-1][first.y-1]);
		}
		
	}
}