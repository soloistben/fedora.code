package say8;
/*
 * ��������
 * f������ x��--->��boolean��ʤ����
 * 
 * �߽���������
 * 
 * for(�����п��ܵ��߷�){
 * 		����һ�� ---->���� y		//�Լ���
 * 		ʤ�� t = f(y);  //�Է���
 * 		if(t==��)	  //ֻ�ж��ֱ��䣬���ǲ�Ӯ�������ǶԷ�ʤ�����������Ҫ�������з�������ȷ���Ƿ�Է�ʤ��
 * 			return ʤ
 * 		�ָ�����		//���� ����try-finally����finally����try���Ƿ�return����ʵ��finally�еĻ���
 * }
 * return ��	//�Թ����з������޷���ʤ
 */
public class Game {
	/**
	 * �����¼0-N��ʤ�����
	 * @param isWin
	 */
	public static void countWin(boolean[] isWin){
		for(int i=0;i<isWin.length;i++){
			if(f(i,isWin))	//��С��ʼ��
				isWin[i] = true;
		}
	}
	/**
	 * ȡ�����⣨1,3,7,8  һ���Կ�ȡ�������
	 * @param n	��ʣ����
	 * @return
	 */
	public static boolean f(int n,boolean[] isWin){
		if(isWin[n])	//ֱ�Ӳ��û��壬���Ч��
			return true;
		if(n>=1 && f(n-1,isWin)==false)
			return true;
		if(n>=3 && f(n-3,isWin)==false)
			return true;
		if(n>=7 && f(n-7,isWin)==false)
			return true;
		if(n>=8 && f(n-8,isWin)==false)
			return true;
		return false;
	}

	public static void main(String[] args) {
		int N = 1500;
		boolean[] isWin = new boolean[N+1];
		
		countWin(isWin);
		for(int i=0;i<isWin.length;i++){
			System.out.println(i+":"+isWin[i]);
		}
		//System.out.println(f(10,isWin));
		//���ִ�����Ч�ʵ�
		//���û��壬���Ѽ���ľ��汣�棬�����ظ�����
		System.out.println(f(N,isWin));	
	}

}
