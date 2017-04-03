package day17.Demo17_Template_Pattern;

public class Demo17_Template_Pattern {
	
	public static void main(String[] args) {
		Yu yu = new Yu();
		yu.sayName();
		yu.sayInfo();
		
		Cang cang = new Cang();
		cang.sayName();
		cang.sayInfo();
		
	}
}


class Yu extends Person{

	@Override
	public void sayName() {
		// TODO Auto-generated method stub
		System.out.println("I am Patrick");
	}

	@Override
	public void sayInfo() {
		// TODO Auto-generated method stub
		System.out.println("I like playing games");
		System.out.println("I like sleeping");
	}
	
}

class Cang extends Person{

	@Override
	public void sayName() {
		// TODO Auto-generated method stub
		System.out.println("I am Cang jin Null");
		
	}

	@Override
	public void sayInfo() {
		// TODO Auto-generated method stub
		System.out.println("I like shooting movies");
		System.out.println("I enjoy being shooted");
		
	}
	
}