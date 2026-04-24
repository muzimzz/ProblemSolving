package silver;

import java.util.*;
import java.io.*;

public class BOJ_1991_RE {

	static int N;
	static StringBuilder sb = new StringBuilder();
	static Map<Character, char[]> map = new HashMap<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char self = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			map.put(self, new char[] {left, right});
		}

		char start = 'A';
		find1(start);
		sb.append("\n");
		find2(start);
		sb.append("\n");
		find3(start);

//		System.out.println(map.keySet());
//		for (char[] c : map.values()) {
//			System.out.println(Arrays.toString(c));
//		}

		System.out.println(sb);

	}

	public static void find1(char curr) {
		if (curr == '.')
			return;
		sb.append(curr);
		find1(map.get(curr)[0]);
		find1(map.get(curr)[1]);
	}

	public static void find2(char curr) {
		if (curr == '.')
			return;
		find2(map.get(curr)[0]);
		sb.append(curr);
		find2(map.get(curr)[1]);
	}

	public static void find3(char curr) {
		if (curr == '.')
			return;
		find3(map.get(curr)[0]);
		find3(map.get(curr)[1]);
		sb.append(curr);
	}
}
