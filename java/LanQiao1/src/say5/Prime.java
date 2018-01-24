package say5;

public class Prime {

	public static void main(String[] args) {
		
		//筛法 素数，先择出第100002的素数
		int N = 1000 * 1000 * 10; //取个较大数
		int x = 100001;	//第100002个素数
		byte[] a = new byte[N];	//标记为0则为素数，否则不是素数
		
		for(int i=2;i<N/2;i++){
			if(a[i]==1)	//已经标记为1的就跳过，是4的倍数，也是2的倍数
				continue;
			for(int k=2; k<=N/i;k++){	//除去2的倍数，3的倍数，4的倍数...
				if(i*k<N)
					a[i*k] = 1;	//这些都不是素数
			}
		}
		
		int m=0;
		for(int i=2;i<N;i++){
			if(a[i] == 0){
				m++;
				if(m==x)
					System.out.print(i+" ");
			}
		}
	}

}
