import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int M = sc.nextInt();
	
	static int[] sel = new int[M];
	static boolean[] v = new boolean[N];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		recursive(0);
	}
	
	private static void recursive(int idx) {
		if (idx == M) {
			for(int ele : sel) {
				System.out.print(ele+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[idx] = i+1;
				recursive(idx+1);
				v[i] = false;
			}
		}
	}

}
