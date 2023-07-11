import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		char[][] arr = new char[5][15];
		int max = 0;
		
		for (int i=0; i<5; i++) {
			String str = sc.next();
			if (max < str.length()) max = str.length();
			
			for (int j=0; j<str.length(); j++) {
				arr[i][j] = str.charAt(j);
			}
			
		}
		
		for(int i=0; i<max; i++) {
			for(int j=0; j<5; j++) {
				if(arr[j][i] == '\0') continue;
				System.out.print(arr[j][i]);
			}
		}
		
		sc.close();
	}

}