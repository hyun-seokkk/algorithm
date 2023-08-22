import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C, mo,ja;
	static char alpha[], moeum[] = {'a','e','i','o','u'};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("src/input.txt")); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alpha = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alpha);
		recursive(new char[L], 0, 0);
	}
	private static void recursive(char[] sel, int idx, int k) {
		if(k==sel.length) {
			mo = 0;
			check(sel);
			ja = k-mo;
			if(mo>=1 && ja>=2) {
				for(char ele : sel) {
					System.out.print(ele);
				}				
				System.out.println();
			}
			return;
		}
		if(idx==C) return;
		
		for (int i = idx; i < C; i++) {
			sel[k] = alpha[i];
			recursive(sel, i+1, k+1);
		}
	}
	private static void check(char[] sel) {
		for (int i = 0; i < sel.length; i++) {
			for (int j = 0; j < moeum.length; j++) {
				if(sel[i] == moeum[j]) {
					mo++;
					break;
				}
			}
		}
		
	}
}
