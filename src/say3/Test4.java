package say3;

public class Test4 {
	//��ʾ������n�����мӷ�����(һ���޷��ص� ����Ҫ�������ϲ���)
	/**
	 * @param n
	 * @param a ����
	 * @param m	��ǰ�ݹ�λ��
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
			if(m>0 && i>a[m-1])	continue;	//ǰһ��Ҫ���ں�һ��
			a[m] = i;	//��i��������	a[] = {6,5,1,4,}
			f(n-i,a,m+1);
		}	
	}
	
	public static void main(String[] args) {
		int[] a = new int[100];	//������һ��ռ�
		f(6,a,0);
	}

}
