package silver;

import java.util.*;


public class BOJ_1991 {
	
	static Map<Character, Character[]> tree = new HashMap<>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		char root = '.';
		for (int i = 0; i < size; i++) {
			char a = sc.next().charAt(0);
			char b = sc.next().charAt(0);
			char c = sc.next().charAt(0);
			
			if (i == 0) {
				root = a;
			}
			
			tree.put(a, new Character[] {b, c});
			
		} // for
		
		L(root); System.out.println();
		M(root); System.out.println();
		R(root); System.out.println();	
		
	} // main
	
	public static void L(char node) {
		
		if (node == '.') return;
		
		System.out.print(node);
		L(tree.get(node)[0]);
		L(tree.get(node)[1]);
		
	}
	
	public static void M(char node) {
			
		if (node == '.') return;	
		
		M(tree.get(node)[0]);
		System.out.print(node);
		M(tree.get(node)[1]);
	}
	
	public static void R(char node) {
		
		if (node == '.') return;

		R(tree.get(node)[0]);
		R(tree.get(node)[1]);
		System.out.print(node);
	}
	

}
