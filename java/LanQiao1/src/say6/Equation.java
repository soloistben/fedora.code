package say6;

public class Equation {

	public static void main(String[] args) {
		/**
		 * a,b,c常数，x,y变量，方程
		 */
		//ax+by=c
		//4x-5y=7
		//1、暴力破解（小范围可取）
		for(int i=0;i<100;i++)
			for(int j=0;j<100;j++){
				if((4*i-5*j)==7){
					System.out.println("x="+i+" y="+j);
				}
			}
		System.out.println("-------------");
		//2、优化速度（双层循环转为单层循环）0
		//ax=c-by
		//先求一个解（x0 y0），
		//再求通解（x=x0+bt）（y=y0-at）（t=-2.-1.0.1.2.3...）
		for(int k=0;k<100;k++){
			if((7-(-5*k))%4==0){
				System.out.println("x="+(7-(-5*k))/4+" y="+k);
				break;
			}
		}
	}

}
