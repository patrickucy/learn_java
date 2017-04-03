package day17.Demo10_Map_Intro;

public class Point implements Comparable<Point> { // this is just like OC's protocol
	private int x;
	private int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}


	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 *  rules.
	 *  return >0: current object is bigger than o
	 *  return <0: current object is smaller than o
	 *  return =0: current object equals to o
	 */
	@Override
	public int compareTo(Point o) { // here you want to compare itself!
		// TODO Auto-generated method stub
		/**
		 * calculate power
		 */
		//				double len = this.x * this.x + this.y * this.y;
		double len = Math.pow(this.x, 2) + Math.pow(this.y, 2);

		double len0 = o.x * o.x + o.y * o.y;
		return (int) (len - len0);
	}


	/**
	 * compareTo() always has to be consistent to equals()
	 * this is very reasonable
	 * when compareTo returns 0,then we say these two objects are equals
	 * 
	 */

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Point){
			Point p = (Point) obj;
			return p.x == this.x && p.y == this.y;
		}else{
			return false;
		}
	}
}


	
