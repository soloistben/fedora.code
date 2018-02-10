package say9;
/*
 * 数据结构
 * 1、线性结构：数组、vector（迭代器）、stack（栈）
 * 2、树形结构：二叉树（重点）
 * 3、图
 * 
 * 
 * 平衡二叉树：左右子树的高度相差不超过1
 * 方法：LL、RR、LR、RL
 * 
 */
//二叉树:递归定义法（可用于递归）
//定义一个二叉树，左子树的值比根的值小，根的值比右子树的值小
class BiTree{
	private int data; //值
	private BiTree lChild;	//左子树
	private BiTree rChild;	//右子树
	
	public BiTree(int data) {
		this.data = data;
	}
	
	//添加节点（递归）
	public void add(BiTree b){
		if(b.data < data){
			if(lChild==null)
				lChild = b;
			else
				lChild.add(b);
		}else{
			if(rChild==null)
				rChild = b;
			else
				rChild.add(b);
		}
	}
	
	//遍历（中序遍历）
	public void mid_show(){
		if(lChild!=null) lChild.mid_show();
		System.out.print(data+" ");
		if(rChild!=null) rChild.mid_show();
	}
	
	//获取伪图像显示的高度
	public int getHeight(){
		int h = 2;	//根结点和竖线 算一层
		int hl = lChild == null?0:lChild.getHeight();
		int hr = rChild == null?0:rChild.getHeight();
		return h + Math.max(hl, hr);	//只要较大者
	}
	
	//获取伪图像显示的宽度
	public int getWidth(){
		int w = (""+data).length();
		if(lChild!=null) w += lChild.getWidth();
		if(rChild!=null) w += rChild.getWidth();
		return w;
	}
	
	//伪图像显示
	public void display(){
		char[][] buf = new char[getHeight()][getWidth()];
		printInBuf(buf,0,0);
		displayBuf(buf);
	}
	
	//显示缓冲流数据
	private void displayBuf(char[][] buf) {
		for(int i=0;i<buf.length;i++){
			for(int j=0;j<buf[i].length;j++)
				System.out.print(buf[i][j]==0?' ':buf[i][j]);
			System.out.println();
		}
	}
	
	//将二叉树伪图像输入缓冲
	private void printInBuf(char[][] buf, int x, int y) {
		String sData = data+"";	//值转为字符串（字符的一维数组）
		
		int p1 = lChild==null?x:lChild.getRootPos(x); 
		int p2 = getRootPos(x);		//相对左边的位置
		int p3 = rChild==null?p2:rChild.getRootPos(p2+sData.length());
		
		buf[y][p2] = '|';
		for(int i=p1;i<=p3;i++)		//先全部 下划线_
			buf[y+1][i]='-';
		for(int i=0;i<sData.length();i++)	//当前值 输入buf 替换 下划线_
			buf[y+1][p2+i]=sData.charAt(i);
		if(p1<p2)
			buf[y+1][p1] = '+';
		if(p3>p2)
			buf[y+1][p3] = '+';
		
		if(lChild!=null) lChild.printInBuf(buf, x, y+2);
		if(rChild!=null) rChild.printInBuf(buf, p2+sData.length(), y+2);
	}
	
	//节点相对左边的位置
	private int getRootPos(int x) {
		return lChild==null?x:x+lChild.getWidth();
	}
}
public class A {

	public static void main(String[] args) {
		BiTree root = new BiTree(100);
		root.add(new BiTree(50));
		root.add(new BiTree(80));
		root.add(new BiTree(150));
		root.add(new BiTree(140));
		root.add(new BiTree(240));
		root.add(new BiTree(10));
		root.add(new BiTree(90));
		root.add(new BiTree(40));
		root.add(new BiTree(144));
		root.add(new BiTree(33));
		root.add(new BiTree(56));
		root.add(new BiTree(122));
		root.add(new BiTree(111));
		root.add(new BiTree(22));
		root.add(new BiTree(2));
		root.add(new BiTree(9));
		root.add(new BiTree(1));
		//root.mid_show();
		root.display();
		System.out.println(root.getHeight()+":"+root.getWidth());
	}

}
