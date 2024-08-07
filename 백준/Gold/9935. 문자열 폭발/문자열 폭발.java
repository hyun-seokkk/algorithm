import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] munja = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();
        int bombLength = bomb.length;

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < munja.length; i++) {
            stack.push(munja[i]);

            if(munja[i] == bomb[bombLength - 1] && stack.size() >= bombLength) {
                ArrayDeque<Character> tempStack = new ArrayDeque<>();
                boolean isMatch = true;

                for (int j = bombLength - 1; j >= 0 ; j--) {
                    char now =stack.pop();
                    tempStack.push(now);
                    if (now != bomb[j]) {
                        isMatch = false;
                        break;
                    }
                }
                if (!isMatch) {
                    while (!tempStack.isEmpty()) {
                        stack.push(tempStack.pop());
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.length() == 0 ? "FRULA" : sb.reverse());

    }
}