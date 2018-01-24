package say5;

import java.util.Scanner;

/**
 * 高僧斗法：
 *   两位参加游戏的法师分别指挥某个小和尚向上走任意多级的台阶，
 *   但会被站在高级台阶上的小和尚阻挡，不能越过。
 *   两个小和尚也不能站在同一台阶，也不能向低级台阶移动。 
 * 	   两法师轮流发出指令，最后所有小和尚必然会都挤在高段台阶，
 *   再也不能向上移动。轮到哪个法师指挥时无法继续移动，则游戏结束，该法师认输。 
 *   
 * 将问题转换为尼姆游戏，在求解
 *   有三堆各若干个物品，两个人轮流从某一堆取任意多的物品，规定每次至少取一个，多者不限，最后取光者得胜
 * 	  先将整数转换为二进制求解，利用二进制1的个数	
 * @author Soloist
 *
 */
public class Nimm {

	public static boolean f(int[] x){
		String[] y = new String[x.length/2];
		int m=0;
		for(int i=0; i<x.length/2; i++){
			y[i] = Integer.toBinaryString(x[i*2+1]-x[i*2]-1);
			if(y[i].length()>m)
				m = y[i].length();
		}
		for(int i=0;i<m;i++){
			boolean tag = true;
			for(int j=0;j<y.length;j++){
				int k = y[j].length() - (m-i);
				if(k>=0 && y[j].charAt(k)=='1')
					tag = !tag;
			}
			if(tag==false)
				return false;
		}
		return true;
	}
	
	public static void test(int[] x){
		for(int i=0; i<x.length-1; i++){
			for(int k=x[i]+1; k<x[i+1]; k++){
				int old = x[i];
				x[i] = k;
				try{
					if(f(x))
						System.out.println(old+" "+k);
				}finally {
					x[i] = old;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] ss = scan.nextLine().split(" ");
		int[] x = new int[ss.length];
		for(int i=0;i<ss.length;i++){
			x[i] = Integer.parseInt(ss[i]);	//将输入的字符串转成int类型
		}
		test(x);
	}

}
