package say3;

public class Test1 {

	/**
	 * �ݹ飺
	 * 	1���ҵ�������
	 * 	2�����ҵ��ٽ�㣬��ֹ�ݹ�������ֵ�������䣩
	 * ���ʣ�
	 * 	1���������
	 * 	2�����������ţ���Ҫ�Ż�
	 */
	
	public static String reverseString(String x){
		if(x==null || x.length()<2) return x;	//ֻʣһ���ַ�ֱ�����
		//if(x.length()<=1) return x;
		return reverseString(x.substring(1))+x.charAt(0);	//����Ԫ���ú�
	}
	
	public static void main(String[] args) {
		System.out.println(reverseString("���ڳ���"));
	}
}
