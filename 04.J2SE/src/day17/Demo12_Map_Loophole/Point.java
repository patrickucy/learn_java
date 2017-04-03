package day17.Demo12_Map_Loophole;

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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}


	
