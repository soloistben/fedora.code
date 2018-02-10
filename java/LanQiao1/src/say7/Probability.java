package say7;


/**
 * 30个人班级，出现生日重复的概率有多大
 * @author Soloist
 *
 */
public class Probability {

	public static void main(String[] args) {
		// 概率模拟
		// 0-365随机产生数字，有没有碰撞
		final int N = 1000*100;	//十万次
		int n=0;
		for(int i=0;i<N;i++){
			int[] x = new int[365];	//做标记数组
			for(int j=0;j<30;j++){	//30人
				int p = (int) (Math.random()*365);	//随机值（0-364）				
				if(x[p]==1){	//随机数碰撞，多次取到一样的值
					n++;
					break;
				}else	
					x[p] = 1;
			}
		}
		double r = (double)n/N;
		System.out.println(r);
	}

}
