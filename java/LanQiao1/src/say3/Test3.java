package say3;

public class Test3 {

	/**
	 * �����ѧ
	 * ����m��A��n��B��ϳɶ��ٲ�ͬ����
	 * @param m
	 * @param n
	 * @return
	 */
	public static int f(int m,int n){
		if(n==0||m==0) return 1;	//ʣ��Ԫ��ֻ��һ��A��B
		return f(m,n-1)+f(m-1,n);	//��Ԫ����A��B���������
	}
	
	public static void main(String[] args) {
		System.out.println(f(3,2));
	}

}
