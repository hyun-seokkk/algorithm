import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, map[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
//		for(int[] arr:map) {
//			System.out.println(Arrays.toString(arr));
//		}
		
		divide(0,0,N);
		
	}
	private static void divide(int x, int y, int size) {
		
		int half = size/2;
		int sum = 0;
		for (int i = x; i < x+size; i++) { // 현재 탐색하는 범위 내의 모든 수 더하기
			for (int j = y; j < y+size; j++) {
				sum += map[i][j];
			}
		}
		if(sum == size*size) { // 모든 수의 합이 범위 면적과 같으면 전체가 1, 압축 가능하니 1 찍고 리턴
			System.out.print("1");
			return;
		} else if (sum == 0) { // 위와 동일
			System.out.print("0");
			return;
		}
		System.out.print('('); // 재귀 호출 = 새로 분할 -> 괄호로 새로운 범위 구분
		divide(x, y, half);
		divide(x, y + half, half);
		divide(x + half, y, half);
		divide(x + half, y + half, half);
		System.out.print(')');
	}

}
