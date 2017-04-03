package day04;
/*
 * 成绩好坏的
 */
public class Demo16_Switch_Case {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = 100;
		String level;
		switch (score/10) {
		case 10:
			
		case 9:
			level = "Excellent";
			//这里只有一个break的意思就是case 10 和 case 9  都会进入到这个上面的情况
			break;
			
		case 8:
			level = "Good";
			break;
			
		case 7:
			level = "Medium";
			break;
			
		case 6:
			level = "Pass";
			break;
			
		default:
			level = "Fail";

			break;
		}
		
		System.out.println(level);
	}

}
