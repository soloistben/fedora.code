package say7;

import java.util.Scanner;
import java.util.Stack;

public class Card {
	/**
	 * 24��
	 * @param ss
	 */
	public static void f(String[] ss){
		//�������������У�Ȼ������Ƿ����24
		//6 3 4 * + ���沨�����ʽ������ѹ��ջ������������������������㣬Ȼ��ֵѹջ�����ʣ��һ�������ջ��
		for(int k=0;k<1000*100;k++){
			String[] buf = new String[7];	//7λ�õĻ�����
			for(int i=0;i<4;i++)	
				buf[i] = ss[i];	//������ĸ���
			for(int i=4;i<7;i++)
				buf[i] = random_op();	//��������
			shuffle(buf);	//ϴ�ƴ���˳��
			if(calcute(buf)){
				//����ɹ�
				show(buf);
				break;
			}else{
				//System.out.println("����ʧ��");
				//break;
			}
		}
	}
	/**
	 * ���
	 * @param buf
	 */
	private static void show(String[] buf) {
		Stack<String> stk = new Stack<String>();	//ջ
	
		for(int i=0;i<buf.length;i++){				
			if(buf[i].equals("+")||buf[i].equals("-")||buf[i].equals("*")||buf[i].equals("/")){
				stk.push("("+stk.pop()+buf[i]+stk.pop()+")");	//�������������ѹ��ջ
			}else{
				stk.push(buf[i]);
			}
		}
		System.out.println(stk.pop()+"=24");
	}
	/**
	 * �沨������
	 * @param buf
	 * @return
	 */
	private static boolean calcute(String[] buf) {
		Stack<String> stk = new Stack<String>();	//ջ
		try{
			for(int i=0;i<buf.length;i++){		
				//����������������ջ��������
				if(buf[i].equals("+")||buf[i].equals("-")||buf[i].equals("*")||buf[i].equals("/")){
					int a = Integer.parseInt((String) stk.pop());	//��ջ������
					int b = Integer.parseInt((String) stk.pop());
					//���������ջ
					stk.push(op(a,b,buf[i])+"");
				}else{
					stk.push(buf[i]);
				}
			}
		}catch (Exception e) {
			return false;	//���쳣ֱ�ӷ��ش���
		}
		if(stk.size()==1 && stk.pop().equals("24")){	//������Ƿ����24
			return true;
		}else
			return false;
	}
	/**
	 * �Ӽ��˳�����
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
	 * ϴ�ƽ���˳��
	 * @param buf
	 */
	private static void shuffle(String[] buf) {
		for(int i=0;i<buf.length;i++){
			int j = (int) (Math.random()*buf.length); 	//��������±�
			String tmp = buf[i];
			buf[i] = buf[j];
			buf[j] = tmp;
		}		
	}
	/**
	 * ������������
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
			System.out.println("������4��������");
			String[] ss = scan.nextLine().split(" ");
			f(ss);
		}
	}

}
