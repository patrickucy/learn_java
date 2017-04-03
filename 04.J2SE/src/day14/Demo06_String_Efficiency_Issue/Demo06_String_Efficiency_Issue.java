package day14.Demo06_String_Efficiency_Issue;

public class Demo06_String_Efficiency_Issue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "a";
//		for (int i = 0; i < 1000000; i++) {
//			str+=str;
//			// Out of memory heap space!!!!
//		}
		// why this would happen???
		// because you constantly creating new strings !!!
		// thus, you need a "mubtable string" class to handle this issue

		
	}

}
