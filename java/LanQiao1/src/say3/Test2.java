package say3;

public class Test2 {
	/**
	 * ������� m��ĵ�n��Ԫ��
	 * 1
	 * 1 1
	 * 1 2  1
	 * 1 3  3  1
	 * 1 4  6  4 1
	 * 1 5 10 10 5 1	
	 * m��ĵ�n��Ԫ�� = m-1���nλ�õ�Ԫ��+m-1��n-1λ�õ�Ԫ��
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
