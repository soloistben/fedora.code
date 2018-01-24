package say6;

import java.math.BigInteger;

/**
 * 一个N位的十进制正整数，
 * 如果它每个位上的数字的N次方的和等于这个数的本身，则称为花朵数
 * 1^3+5^3+3^3=153 水仙花数
 * @author Soloist
 *
 */
public class FlowerNumber {
	//求N=21的花朵数
	public static BigInteger[] base = new BigInteger[10];	//0-9每个数的21次方
	
	public static BigInteger calcu_21(int n){
		BigInteger a = BigInteger.ONE;
		for(int i=0;i<21;i++)
			a = a.multiply(BigInteger.valueOf(n));	//计算21次方
		return a;
	}
	
	public static void test(int[] a){
		BigInteger bn = BigInteger.ZERO;
		
		for(int i=0;i<a.length;i++){
			bn = bn.add(base[i].multiply(BigInteger.valueOf(a[i]))); //某个数的21次方乘以出现的次数，在累加
		}
		
		String s = bn.toString();
		if(s.length() != 21)
			return;
		
		int[] b = new int[10]; //bn中每个数出现的次数
		for(int i=0;i<s.length();i++){
			b[s.charAt(i)-'0']++;
		}
		for(int i=0;i<10;i++){	//a数组和b数组出现数字个数一摸一样则成立
			if(a[i]!=b[i])
				return;
		}
		System.out.println(bn);
	}
	
	public static void f(int[] a,int k, int sum){
		if(sum == 0){	//次数分配完毕
			test(a);
			for(int i=0;i<a.length;i++)
				System.out.print(i+":"+a[i]+" ");
			System.out.println();
			return;
		}
		if(k == a.length-1){	//分配到最后
			a[k] = sum;
			f(a,k+1,0);
			return;
		}
		for(int i=0;i<=sum;i++){
			a[k] = i;	//置位
			f(a,k+1,sum-i);
			a[k] = 0;	//回溯
		}
	}
	
	public static void main(String[] args) {
		for(int i=0;i<base.length;i++)
			base[i] = calcu_21(i);
		
		int[] a = new int[10];	//0-9每个次数出现几次

		f(a,0,21);		
	}

}
