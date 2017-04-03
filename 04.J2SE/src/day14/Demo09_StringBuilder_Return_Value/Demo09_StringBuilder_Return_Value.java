package day14.Demo09_StringBuilder_Return_Value;
/**
 * using return value for StringBuilder
 * 
 * basically StringBuilder is the same as StringBuffer
 * but,! StringBuilder is thread unsafe and StringBuffer is thread safe!
 * thus, StringBuilder is more efficient than StringBuffer, because usually we manipulate string
 * on a single thread, there is no need for be thread safe. 
 *  
 * @author patrickyu
 *
 */
public class Demo09_StringBuilder_Return_Value {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder("Hello");
		StringBuilder builder2 = builder.append("world");
		
		System.out.println(builder == builder2);
		builder.insert(5, "!");
		System.out.println(builder.toString());
		
		//functional way of using builder, because its return type is itself
		builder.append("world").insert(5, "!");
		System.out.println(builder.toString());
		
		
		
		StringBuffer buffer = new StringBuffer("Hello");
		StringBuffer buffer2 = buffer.append("world");
		
		System.out.println(buffer == buffer2);
		buffer.insert(5, "!");
		System.out.println(buffer.toString());
		
		//functional way of using builder, because its return type is itself
		buffer.append("world").insert(5, "!");
		System.out.println(buffer.toString());
	}

}
