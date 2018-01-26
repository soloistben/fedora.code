package say6;

import java.math.BigInteger;

/**
 * һ��Nλ��ʮ������������
 * �����ÿ��λ�ϵ����ֵ�N�η��ĺ͵���������ı������Ϊ������
 * 1^3+5^3+3^3=153 ˮ�ɻ���
 * @author Soloist
 *
 */
public class FlowerNumber {
	//��N=21�Ļ�����
	public static BigInteger[] base = new BigInteger[10];	//0-9ÿ������21�η�
	
	public static BigInteger calcu_21(int n){
		BigInteger a = BigInteger.ONE;
		for(int i=0;i<21;i++)
			a = a.multiply(BigInteger.valueOf(n));	//����21�η�
		return a;
	}
	
	public static void test(int[] a){
		BigInteger bn = BigInteger.ZERO;
		
		for(int i=0;i<a.length;i++){
			bn = bn.add(base[i].multiply(BigInteger.valueOf(a[i]))); //ĳ������21�η����Գ��ֵĴ��������ۼ�
		}
		
		String s = bn.toString();
		if(s.length() != 21)
			return;
		
		int[] b = new int[10]; //bn��ÿ�������ֵĴ���
		for(int i=0;i<s.length();i++){
			b[s.charAt(i)-'0']++;
		}
		for(int i=0;i<10;i++){	//a�����b����������ָ���һ��һ�������
			if(a[i]!=b[i])
				return;
		}
		System.out.println(bn);
	}
	
	public static void f(int[] a,int k, int sum){
		if(sum == 0){	//�����������
			test(a);
			for(int i=0;i<a.length;i++)
				System.out.print(i+":"+a[i]+" ");
			System.out.println();
			return;
		}
		if(k == a.length-1){	//���䵽���
			a[k] = sum;
			f(a,k+1,0);
			return;
		}
		for(int i=0;i<=sum;i++){
			a[k] = i;	//��λ
			f(a,k+1,sum-i);
			a[k] = 0;	//����
		}
	}
	
	public static void main(String[] args) {
		for(int i=0;i<base.length;i++)
			base[i] = calcu_21(i);
		
		int[] a = new int[10];	//0-9ÿ���������ּ���

		f(a,0,21);		
	}

}
