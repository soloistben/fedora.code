package say2;
/**
 * 求n个元素全排列
 * abc acb bac bca cab cba
 * @author Soloist
 *
 */
public class AllSort {
	/**
	 * 全排列
	 * @param data
	 * @param index	当前需要交换的位置，预期后面元素交换
	 */
	public static void f(char[] data,int index){
		if(index == data.length){
			for(int i=0;i<data.length;i++){
				System.out.print(data[i]+" ");
			}
			System.out.println();
		}
		for(int i=index;i<data.length;i++){
			//每个字符与第一个字符相交换（每个字符都可以放在第一位）
			{char tmp = data[index]; data[index] = data[i]; data[i] = tmp;}
			//每次交换开始递归
			f(data,index+1);
			//回溯（每次交换完成后需要把位置交换回来）
			{char tmp = data[index]; data[index] = data[i]; data[i] = tmp;}
		}
	}
	
	public static void main(String[] args) {
		char[] data = "ABCD".toCharArray();
		f(data,0);
	}

}
