import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int N, map[][], ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		queen(0);
		System.out.println(ans);
		
	}
	private static void queen(int r) {
		
		if(r == N) { // 모든 행에 퀸을 두었다면
			ans++; // 정답++
			return;
		}
		
		// 퀸은 각 행마다 무조건 하나, 퀸을 둘 수 있는 열 탐색
		for (int c = 0; c < N; c++) {
			
			if(check(r, c)){ // r,c 위치에 퀸을 둘 수 있는 자리라면
				map[r][c] = 1; // 퀸 두고
				queen(r+1); // 다음 행으로 재귀
				map[r][c] = 0; // 복구
			}
		}
		
	}
	private static boolean check(int r, int c) { // 퀸 둘 수 있는 자리인지 검증
		
		// 좌상단 -> 우하단 순으로 하나씩 탐색하니 8방탐색 할필요 없이 좌상, 상, 우상만 확인하면 퀸을 둘 수 있는지 없는지 알 수 있다
		
		// 상단 이동
		for (int i = r-1; i >= 0; i--) {
			if (map[i][c] == 1) return false;
		}
		// 좌상 이동
		for (int i = r-1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
			if (map[i][j] == 1) return false;
		}
		// 우상 이동
		for (int i = r-1, j = c + 1; i >= 0 && j < N; i--, j++) {
			if (map[i][j] == 1) return false;
		}
		
		return true; // 위 조건에 한 번도 안 걸렸으면 퀸 ok
	}

}
