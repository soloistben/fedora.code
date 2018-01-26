package say5;

import java.util.Scanner;

/**
 * ��ɮ������
 *   ��λ�μ���Ϸ�ķ�ʦ�ֱ�ָ��ĳ��С��������������༶��̨�ף�
 *   ���ᱻվ�ڸ߼�̨���ϵ�С�����赲������Խ����
 *   ����С����Ҳ����վ��ͬһ̨�ף�Ҳ������ͼ�̨���ƶ��� 
 * 	   ����ʦ��������ָ��������С���б�Ȼ�ᶼ���ڸ߶�̨�ף�
 *   ��Ҳ���������ƶ����ֵ��ĸ���ʦָ��ʱ�޷������ƶ�������Ϸ�������÷�ʦ���䡣 
 *   
 * ������ת��Ϊ��ķ��Ϸ�������
 *   �����Ѹ����ɸ���Ʒ��������������ĳһ��ȡ��������Ʒ���涨ÿ������ȡһ�������߲��ޣ����ȡ���ߵ�ʤ
 * 	  �Ƚ�����ת��Ϊ��������⣬���ö�����1�ĸ���	
 * @author Soloist
 *
 */
public class Nimm {

	public static boolean f(int[] x){
		String[] y = new String[x.length/2];
		int m=0;
		for(int i=0; i<x.length/2; i++){
			y[i] = Integer.toBinaryString(x[i*2+1]-x[i*2]-1);
			if(y[i].length()>m)
				m = y[i].length();
		}
		for(int i=0;i<m;i++){
			boolean tag = true;
			for(int j=0;j<y.length;j++){
				int k = y[j].length() - (m-i);
				if(k>=0 && y[j].charAt(k)=='1')
					tag = !tag;
			}
			if(tag==false)
				return false;
		}
		return true;
	}
	
	public static void test(int[] x){
		for(int i=0; i<x.length-1; i++){
			for(int k=x[i]+1; k<x[i+1]; k++){
				int old = x[i];
				x[i] = k;
				try{
					if(f(x))
						System.out.println(old+" "+k);
				}finally {
					x[i] = old;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] ss = scan.nextLine().split(" ");
		int[] x = new int[ss.length];
		for(int i=0;i<ss.length;i++){
			x[i] = Integer.parseInt(ss[i]);	//��������ַ���ת��int����
		}
		test(x);
	}

}
