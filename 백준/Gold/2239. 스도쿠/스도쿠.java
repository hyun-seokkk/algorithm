import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean isEnd;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		for (int i = 0; i < 9; ++i) {
			String str = br.readLine();
			for (int j = 0; j < 9; ++j) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		dfs(0);
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
	private static void dfs(int d) {
		// TODO Auto-generated method stub
		if (d == 81) {
			isEnd = true;
			return;
		}
		
		int y = d / 9;
		int x = d % 9;
		
		if (map[y][x] != 0) {
			dfs(d + 1);
		} else {
			for (int i = 1; i <= 9; ++i) {
				if (!isVaild(y, x, i)) continue;
				map[y][x] = i;
				dfs(d + 1);
				if (isEnd) return;
				map[y][x] = 0;
			}
		}
	}
	
	public static boolean isVaild(int y, int x, int n) {
		for (int i = 0; i < 9; ++i) {
			if (map[y][i] == n || map[i][x] == n) return false;
		}
		
		int nx = x / 3 * 3;
		int ny = y / 3 * 3;
		for (int i = ny; i < ny + 3; ++i) {
			for (int j = nx; j < nx + 3; ++j) {
				if (map[i][j] == n) return false;
			}
		}
		return true;
	}

}