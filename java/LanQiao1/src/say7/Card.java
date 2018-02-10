package say7;

import java.util.Scanner;
import java.util.Stack;

public class Card {
	/**
	 * 24点
	 * @param ss
	 */
	public static void f(String[] ss){
		//随机产生组合序列，然后计算是否等于24
		//6 3 4 * + （逆波兰表达式）数字压进栈，靠近运算符的两个数字运算，然后值压栈，最后剩下一个结果在栈中
		for(int k=0;k<1000*100;k++){
			String[] buf = new String[7];	//7位置的缓冲区
			for(int i=0;i<4;i++)	
				buf[i] = ss[i];	//输入的四个数
			for(int i=4;i<7;i++)
				buf[i] = random_op();	//随机运算符
			shuffle(buf);	//洗牌打乱顺序
			if(calcute(buf)){
				//计算成功
				show(buf);
				break;
			}else{
				//System.out.println("计算失败");
				//break;
			}
		}
	}
	/**
	 * 输出
	 * @param buf
	 */
	private static void show(String[] buf) {
		Stack<String> stk = new Stack<String>();	//栈
	
		for(int i=0;i<buf.length;i++){				
			if(buf[i].equals("+")||buf[i].equals("-")||buf[i].equals("*")||buf[i].equals("/")){
				stk.push("("+stk.pop()+buf[i]+stk.pop()+")");	//将本次运算过程压进栈
			}else{
				stk.push(buf[i]);
			}
		}
		System.out.println(stk.pop()+"=24");
	}
	/**
	 * 逆波兰计算
	 * @param buf
	 * @return
	 */
	private static boolean calcute(String[] buf) {
		Stack<String> stk = new Stack<String>();	//栈
		try{
			for(int i=0;i<buf.length;i++){		
				//如果遇到运算符，出栈两个数字
				if(buf[i].equals("+")||buf[i].equals("-")||buf[i].equals("*")||buf[i].equals("/")){
					int a = Integer.parseInt((String) stk.pop());	//出栈两个数
					int b = Integer.parseInt((String) stk.pop());
					//运算后再入栈
					stk.push(op(a,b,buf[i])+"");
				}else{
					stk.push(buf[i]);
				}
			}
		}catch (Exception e) {
			return false;	//出异常直接返回错误
		}
		if(stk.size()==1 && stk.pop().equals("24")){	//最后结果是否等于24
			return true;
		}else
			return false;
	}
	/**
	 * 加减乘除计算
	 * @param a
	 * @param b
	 * @param s
	 * @return
	 * @throws Exception 
	 */
	private static int op(int a, int b, String oper) throws Exception {
		if(oper.equals("+"))
			return a+b;
		if(oper.equals("-"))
			return a-b;
		if(oper.equals("*"))
			return a*b;	
		if(a%b!=0)
			throw new Exception("not %");  
		return a/b;
	}
	/**
	 * 洗牌交换顺序
	 * @param buf
	 */
	private static void shuffle(String[] buf) {
		for(int i=0;i<buf.length;i++){
			int j = (int) (Math.random()*buf.length); 	//产生随机下标
			String tmp = buf[i];
			buf[i] = buf[j];
			buf[j] = tmp;
		}		
	}
	/**
	 * 随机返回运算符
	 * @return
	 */
	private static String random_op() {
		int n = (int)(Math.random()*4);
		if(n==0) return "+";
		if(n==1) return "-";
		if(n==2) return "*";
		return "/";
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.println("请输入4个整数：");
			String[] ss = scan.nextLine().split(" ");
			f(ss);
		}
	}

}
