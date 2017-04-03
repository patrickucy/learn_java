package day14.Demo08_StringBuilder_More;
/**
 * using StringBuilder for string alteration
 * @author patrickyu
 *
 */
public class Demo08_StringBuilder_More {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "work hard to study java";
		/**
		 *  before String alteration, you need to transform it into StringBuilder
		 */
		StringBuilder builder = new StringBuilder(str);
		builder.append(", for finding a better job!");
		
		/**
		 * alter content
		 * 
		 *  work hard to study java, for finding a better job!
		 */
		builder.replace(29, builder.length(), "changing the world");
		System.out.println(builder.toString());
		
		
		/**
		 * delete content
		 * for changing the world
		 */
		builder.delete(0, 25);
		System.out.println(builder.toString());
		
		/**
		 *  insert content
		 *  
		 *  living, for changing the world!
		 */
		builder.insert(0, "living ");
		System.out.println(builder.toString());

		System.out.println(builder.reverse().toString());
		
	}

}
