package say3;
/**
 * 已知错误金额总数，和明细账目，求出哪一笔或几笔漏掉
 * 解法：每个账目明细，都有可能被遗漏，则都有两种情况（1和0，选择与不选择），
 * 		每种情况都是一遍，递归时，当累积当前金额，等于
 * @author soloist
 * 注意出口条件顺序
 * 注意回溯，重置或修改条件
 */
public class Test5 {
	/**
	 * 递归求解
	 * @param err_sum	有错的总金额
	 * @param a		明细（数组只传入不修改）
	 * @param index	当前明细位置
	 * @param cur_sum 	前边和元素累加的和
	 * @param b		记录明细选择
	 */
	public static void f(int err_sum,int[] a,int index,int cur_sum,boolean[] b) {
		if(cur_sum > err_sum) return;	//当前累积金额超过错误金额
		if(err_sum == cur_sum) {		//当前金额等于错误金额
			for(int i=0;i<b.length;i++) {
				if(b[i]==false)
					System.out.print(i+" ");	//输出 被选 的明细下标
			}
			System.out.println();
			return;
		}
		if(index >= a.length) return;	//当前元素越界
		
		b[index] = false;	//不选
		f(err_sum,a,index+1,cur_sum,b);
		
		b[index] = true;	//选
		cur_sum += a[index];	//当前明细被选了，就累加当前金额
		f(err_sum,a,index+1,cur_sum,b);
		b[index] = false;  //回溯
	}
	public static void main(String[] args) {
		int[] a = {3,2,4,3,1};	//5笔明细账目
		boolean[] b = new boolean[a.length];	//用于记录明细的 选择
		int sum = 6;	//错误总额
		
		f(sum,a,0,0,b);
	}

}
