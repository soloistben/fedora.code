package say5;
/**
 * 假如4颗糖果一包，和7颗糖果一包，各种组合，求出买不到的最大数是多少
 * 连续出现4个数都能买到，则后面都可以买到了（连续买到个数达到最小包装的数即可）
 * @author Soloist
 *
 */
public class Test {

	public static final int N = 1000*100;
	
	//搜索连续能够买到的糖果数
	//da[] 用于标记是否能买到，a 最小包装的数
	public static int se(int[]da,int a){
		int n=0;
		for(int i=0;i<da.length;i++){
			if(da[i]==1){
				n++;
				if(n>=a)	//连续买到个数达到最小包装的数即可
					return i-a;	//减a是为了找到买不到的那个数
			}else{
				n=0;	//重置n
			}
		}
		return -1;	//找不到结果
	}
	// a*i + b*j（i，j = 0,1,2,3...） 
	public static void f(int a,int b){
		int[] da = new int[N];
		
		for(int i=0;i<N/a;i++){
			for(int j=0;j<(N-i*a)/b;j++){
				if(i*a+b*j<N){
					da[i*a+b*j] = 1;	//通过各种组合求出可买得到的数
				}
			}
		}
		
		System.out.println(se(da,a));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f(4,7);
	}

}
