package say3;

public class Test2 {
	/**
	 * 杨辉三角 m层的第n个元素
	 * 1
	 * 1 1
	 * 1 2  1
	 * 1 3  3  1
	 * 1 4  6  4 1
	 * 1 5 10 10 5 1	
	 * m层的第n个元素 = m-1层的n位置的元素+m-1层n-1位置的元素
	 * @param m
	 * @param n
	 * @return
	 */
	public static int f(int m,int n){
		if(m==0) return 1;
		if(n==0) return 1;
		if(n==m) return 1;
		return f(m-1,n)+f(m-1,n-1);
	}
	
	public static void main(String[] args) {
		int level = 10;
		for(int j=0;j<level;j++){
			for(int i=0;i<=j;i++)
				System.out.print(f(j,i)+" ");
			System.out.println();
		}
	}

}
