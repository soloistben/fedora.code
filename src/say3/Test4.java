package say3;

public class Test4 {
	//显示该整数n的所有加法划分(一般无返回的 都需要两个以上参数)
	/**
	 * @param n
	 * @param a 缓冲
	 * @param m	当前递归位置
	 */
	public static void f(int n,int[] a,int m){
		if(n==0) {
			for(int i=0;i<m;i++){
				if(i==m-1)
					System.out.print(a[i]);
				else
					System.out.print(a[i] + "+");
			}
			System.out.println();
			return;
		}
		for(int i=n;i>0;i--){
			if(m>0 && i>a[m-1])	continue;	//前一项要大于后一项
			a[m] = i;	//将i放入数组	a[] = {6,5,1,4,}
			f(n-i,a,m+1);
		}	
	}
	
	public static void main(String[] args) {
		int[] a = new int[100];	//开个大一点空间
		f(6,a,0);
	}

}
