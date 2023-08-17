import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N, R, C;
	static char map[][];
	static int timerMap[][];
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("src/input.txt")); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		timerMap = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				char temp = str.charAt(j);
				map[i][j] = temp;
				if(temp == 'O') {
					timerMap[i][j] = 3;
				}
			}
		}
		
		for (int t = 1; t <= N; t++) {
			cDown();
			if(t%2 == 0) {
				reFill();
			}

		}
		print(map);


		
	}

	private static void cDown() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(timerMap[i][j] > 0) {
					timerMap[i][j]--;					
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'O' && timerMap[i][j] == 0) {
					boom(i,j);
				}
			}
		}
	}

	private static void boom(int x, int y) {
		map[x][y] = '.';
		timerMap[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0&&nx<R&&ny>=0&&ny<C&&timerMap[nx][ny] != 0) {
				map[nx][ny] = '.';
				timerMap[nx][ny] = 0;
			}
		}
	}

	private static void reFill() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(timerMap[i][j] == 0) {
					timerMap[i][j] = 3;
				}
				map[i][j] = 'O';
			}
		}
	}

	private static void print(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
