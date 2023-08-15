import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,r,c, ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		ans = 0;
		
		divideSquare(0,0,(int) Math.pow(2, N));
		
		System.out.println(ans);
		
	}
	private static void divideSquare(int sr, int sc, int size) {
		// TODO Auto-generated method stub
		if(size < 1) return;
		
		int half = size/2;
		
		
		
		// 4등분한 사각형 좌상단부터 시계방향으로 1,2,3,4
        // 각 영역에 맞게 변경된 초기위치를 인자에 넣어 재귀호출
		if(r < sr + half) {
			if(c < sc + half) { //1번 영역은 이동 x
				divideSquare(sr, sc, half);
			} else { // 2번 영역은 1번 영역의 이동횟수만큼 이미 이동한 상태
				ans += half*half;
				divideSquare(sr, sc+ half, half);
			}
		} else { // 3번 영역은 2번 ..
			if(c < sc + half) {
				ans += half*half*2;
				divideSquare(sr + half, sc, half);
			}else { // 4번 영역
				ans += half*half*3;
				divideSquare(sr + half, sc + half, half);
			}
		}
		
	}

}
