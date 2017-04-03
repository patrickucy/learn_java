package day06;

import java.util.Scanner;

import day01.HelloWorld;

/*
 * 成绩管理系统:数组的应用
 * 首先你要搞清楚你要处理什么数据
 * 
 * 数据设计:使用数组装载数据
 * 算法设计:
 * 1)提示主菜单 1.输入 2.列表 3.查询 0.离开
 * 2)等待用户的输入(菜单号)
 * 3)多路处理 菜单功能
 * 	3.1)处理输入功能
 *		a)提示一位同学的名字,等待输入这位同学的名字
 * 	3.2)处理列表功能
 * 	3.3)处理查询功能
 * 	3.4)处理离开功能
 * 3)返回(1)
 * 
 */
public class Demo02_Student_Management_System {

	public static void main(String[] args) {
		//数据结构
		String[] names = {"tom","jerry","john","nemo","andy","lee"};
		Integer[] scores = new Integer[names.length];
		
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.println("Main menu: 1.Input 2.List 3.Search 0.Exit"); 
			String cmd = in.nextLine(); //这个API不能解决空行的问题
			
			if (cmd.equals("0")) {
				//0.exit
				System.out.println("See you.");
				break;
			}else if (cmd.equals("1")) {
				//1.input
				for (int i = 0; i < scores.length; i++) {
					System.out.println("Please input a score for student: "+ names[i] );
					String str = in.nextLine();
					scores[i] = Integer.parseInt(str);
				}
				System.out.println("You just done inputing scores for students");
				
						
			}else if (cmd.equals("2")) {
				//2.List
				System.out.println("Listing all information: ");
				int sum = 0;
				for (int i = 0; i < scores.length; i++) {
					System.out.println("Student: " + names[i] + "	Scores: " + scores[i]);
					sum += scores[i];
				}
				System.out.println("Average score: "+ (double) sum/scores.length);

			}else if (cmd.equals("3")) {
				//3.Search
				System.out.println("Please search:");
				String inputName = in.nextLine();
				for (int i = 0; i < scores.length; i++) {
					if (inputName.equals(names[i])) {
						System.out.println("Student: " + names[i] + " Score: " + scores[i]);
					}
				}
			}else {
				System.out.println("Wrong command");
			}
		}
		
		
	}

}
