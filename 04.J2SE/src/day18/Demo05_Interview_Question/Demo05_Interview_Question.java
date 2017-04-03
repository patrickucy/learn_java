package day18.Demo05_Interview_Question;
/**
 * very special case!!!!!!!!!!!!!
 * why result is 3,3,3 ??????????????
 * 
 * @author patrickyu
 *
 */
public class Demo05_Interview_Question {
	
	public static void main(String[] args) {
		System.out.println(test(null)+","+test("0") + "," + test(""));
	}
	
	public static int test(String str){
		try{
			return str.charAt(0) - '0';
			
		}catch (NullPointerException e){
			return 1;
		}catch(RuntimeException e){
			return 2;
		}finally{
			return 3; // you should never write return in finally block!!!!!!!
		} 
	}
}
