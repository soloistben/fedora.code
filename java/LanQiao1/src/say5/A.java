package say5;
/**
 * ����������������
 * ���Լ��
 * ��С������
 * ����
 * @author Soloist
 *
 */
public class A {
	/**
	 * շת�����2
	 * @param a
	 * @param b
	 */
	public static int gcd(int a,int b){
		if(a<0) return -a;
		if(b<0)	return -b;
		if(b==0) return a;
		return gcd(b, a%b);
	}
	/**
	 * ��a��n���ݣ�pȡģ
	 * a%p b%p��ȡģmol
	 * (a+b)%p = (a%p + b%p)%p
	 * (a*b)%p = (a%p * b%p)%p
	 * @param a	����
	 * @param n	����
	 * @param p ȡģ
	 * @return
	 */
	public static int fMol(int a,int n,int p){
		int x = 1;
		for(int i=0;i<n;i++)
			x = (x*a)%p;
		return x;
	}
	
	
	public static void main(String[] args) {
		
		//------ȡģ---
		System.out.println(fMol(5,50,17));
		
		int a=15,b=40;
		
		//------���Լ��---------------
		//���������������ʺ���ֵ�Ƚϴ�����
		for(int i=a;i>=1;i--){
			if(a%i==0 && b%i==0){
				System.out.println(i);
				break;
			}
		}
		//շת�����1 (aΪ��С��)
		while(true){
			if(a==0){
				System.out.println(b);
				break;
			}
			int t = a;
			a = b%a;
			b = t;
		}
		System.out.println(gcd(a, b));
		
		//------��С������-------
		//1���Ƚϸ�Ч�ʵ��ǣ��ϴ�����ı�����������С��������Ϊ��С������
		//2�������ԣ�a*b/gcd(a,b)����С������ = ������� ���� ���Լ�� 
		a=15;
		b=40;
		int j=2;
		while(true){
			if(b*j%a==0){
				System.out.println(b*j);
				break;
			}
			j++;
		}
		System.out.println(a*b/gcd(a,b));
	}

}
