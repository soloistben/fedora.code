package say2;
/**
 * 组合问题
 * 在n个球中，取出m个（不放回），求有多少种解法
 * @author Soloist
 *
 */
public class Recursion {
	
	public static int f(int n,int m){
		if(n<m) return 0;	//n不能小于m，所以取0次（不能取）
		if(n==m) return 1;	//n=m，取1次
		if(m==0) return 1;	//m=0，取1次（不取）
		return f(n-1,m-1)+f(n-1,m);		//两种情况：（设n个球中有一个特殊球）把所有结果分为，取到想要的特殊球，和没取到特殊球
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = f(10,3);
		System.out.println(k);
	}

}
