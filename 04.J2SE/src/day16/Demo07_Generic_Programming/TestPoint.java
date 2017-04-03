package day16.Demo07_Generic_Programming;

public class TestPoint {
	
	public static void main(String[] args) {
		Point<Integer> p = new Point<Integer>(1,2);
		p.setX(1);
		int x = p.getX();
		
		dosome(p);
		/**
		 *  generic programming just notify VM, when to do casting for us
		 *  the generic type in fact is "Object"
		 */
		x = p.getX(); // there will be a runtime error here!
		// this can prove that our generic in fact is a fake, it just cast "Object" to a new type
	}
	
	public static void dosome(Point p) {
		p.setX("1");
		Object x = new Integer(1);
	}

}


