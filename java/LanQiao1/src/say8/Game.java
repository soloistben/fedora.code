package say8;
/*
 * 博弈问题
 * f（局面 x）--->（boolean）胜负？
 * 
 * 边界条件处理
 * 
 * for(对所有可能的走法){
 * 		试走一步 ---->局面 y		//自己走
 * 		胜负 t = f(y);  //对方走
 * 		if(t==负)	  //只有对手必输，我们才赢。不考虑对方胜的情况，起码要经过所有方法才能确定是否对方胜利
 * 			return 胜
 * 		恢复局面		//回溯 可用try-finally，在finally无论try中是否return，均实现finally中的回溯
 * }
 * return 负	//试过所有方法，无法制胜
 */
public class Game {
	/**
	 * 数组记录0-N的胜负情况
	 * @param isWin
	 */
	public static void countWin(boolean[] isWin){
		for(int i=0;i<isWin.length;i++){
			if(f(i,isWin))	//从小开始测
				isWin[i] = true;
		}
	}
	/**
	 * 取球问题（1,3,7,8  一次性可取球个数）
	 * @param n	所剩的球
	 * @return
	 */
	public static boolean f(int n,boolean[] isWin){
		if(isWin[n])	//直接查用缓冲，提高效率
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
		//数字大运算效率低
		//利用缓冲，将已计算的局面保存，避免重复运算
		System.out.println(f(N,isWin));	
	}

}
