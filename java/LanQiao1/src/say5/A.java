package say5;
/**
 * 素数，整除，余数
 * 最大公约数
 * 最小公倍数
 * 幂数
 * @author Soloist
 *
 */
public class A {
	/**
	 * 辗转相除法2
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
	 * 求a的n次幂，p取模
	 * a%p b%p，取模mol
	 * (a+b)%p = (a%p + b%p)%p
	 * (a*b)%p = (a%p * b%p)%p
	 * @param a	底数
	 * @param n	幂数
	 * @param p 取模
	 * @return
	 */
	public static int fMol(int a,int n,int p){
		int x = 1;
		for(int i=0;i<n;i++)
			x = (x*a)%p;
		return x;
	}
	
	
	public static void main(String[] args) {
		
		//------取模---
		System.out.println(fMol(5,50,17));
		
		int a=15,b=40;
		
		//------最大公约数---------------
		//暴力搜索，但不适合数值比较大的情况
		for(int i=a;i>=1;i--){
			if(a%i==0 && b%i==0){
				System.out.println(i);
				break;
			}
		}
		//辗转相除法1 (a为较小者)
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
		
		//------最小公倍数-------
		//1、比较高效率的是：较大的数的倍数能整出较小的数，则为最小公倍数
		//2、（可以：a*b/gcd(a,b)）最小公倍数 = 两数相乘 除以 最大公约数 
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
