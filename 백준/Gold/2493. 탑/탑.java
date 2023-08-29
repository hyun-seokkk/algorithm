import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		ArrayDeque<Integer> Q = new ArrayDeque<Integer>();
		
		int[] arr = new int[n];
		int[] signalArr = new int[n];
		for (int curTowIdx = 0; curTowIdx < n; curTowIdx++) {
			int temp = Integer.parseInt(st.nextToken());  // 높이 정보
			arr[curTowIdx] = temp;  // 현재 위치 타워 높이정보 저장
			while(!Q.isEmpty()) {  // 큐가 비어있다면 or 빌때까지 수신정보 저장하는 로직
				int lastIdx = Q.peekLast();  // 스택 최상단 인덱스 
				int lastHeight = arr[lastIdx]; // 스택 최상단 타워의 높이
				if(lastHeight < temp) { 
					Q.removeLast();  // 현재 타워가 이전 타워보다 높다면 수신 불가 -> pop
				} else {
					signalArr[curTowIdx] = lastIdx+1; // 현재 타워보다 높은 타워를 만났다면 레이저 수신정보 저장 후 루프 탈출
					break;
				}
				
			}
			Q.add(curTowIdx);  // 큐에는 인덱스 정보 저장
		}
		for(int ele : signalArr) {
			System.out.print(ele+" ");
		}
//		System.out.println(Arrays.toString(signalArr));
	}

}