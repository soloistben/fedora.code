package say3;

public class Test3 {

	/**
	 * 组合数学
	 * 计算m个A，n个B组合成多少不同排列
	 * @param m
	 * @param n
	 * @return
	 */
	public static int f(int m,int n){
		if(n==0||m==0) return 1;	//剩下元素只有一个A或B
		return f(m,n-1)+f(m-1,n);	//首元素是A或B，两种情况
	}
	
	public static void main(String[] args) {
		System.out.println(f(3,2));
	}

}
