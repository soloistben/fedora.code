package say2;
/**
 * �������
 * ��n�����У�ȡ��m�������Żأ������ж����ֽⷨ
 * @author Soloist
 *
 */
public class Recursion {
	
	public static int f(int n,int m){
		if(n<m) return 0;	//n����С��m������ȡ0�Σ�����ȡ��
		if(n==m) return 1;	//n=m��ȡ1��
		if(m==0) return 1;	//m=0��ȡ1�Σ���ȡ��
		return f(n-1,m-1)+f(n-1,m);		//�������������n��������һ�������򣩰����н����Ϊ��ȡ����Ҫ�������򣬺�ûȡ��������
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = f(10,3);
		System.out.println(k);
	}

}
