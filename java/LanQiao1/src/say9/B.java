package say9;
/*
 * 平衡二叉树：左右子树的高度相差不超过1
 * 在每次添加节点进去，都判断是否平衡，不平衡则调整平衡
 * 方法：
 * 	LL（左子树的左子树高度过高）
 * 	LR（左子树的右子树高度过高）
 * 	RR（右子树的右子树高度过高）
 * 	RL（右子树的左子树高度过高）
 */
class AVLTree{
	private int data; //值
	private AVLTree lChild;	//左子树
	private AVLTree rChild;	//右子树
	private int balance = 0;
	
	public AVLTree(int data) {
		this.data = data;
	}

	public int getBalance() {
		return balance;
	}

	//计算是否平衡
	public void calcu_balance(){
		int lh = lChild==null?0:lChild.getHeight();
		int rh = rChild==null?0:rChild.getHeight();
		balance = (lh-rh)/2;	//算了伪图像中的根结点和竖线，2方便计算（理论上是1和-1）	
	}
	
	public AVLTree add(AVLTree avlTree){
		AVLTree root = this;
		if(avlTree.data < data){
			if(lChild==null)
				lChild = avlTree;
			else
				lChild = lChild.add(avlTree);	//返回结点：经过平衡调整左子树部分根节点有可能会发生变化
		}else{
			if(rChild==null)
				rChild = avlTree;
			else
				rChild = rChild.add(avlTree);
		}
		
		//判断平衡
		calcu_balance();
		
		//balance大于0，则左子树高度大于右子树高度
		if(balance>1){	
			if(lChild.getBalance() > 0)
				root = adjustLL();
			else
				root = adjustLR();
		}
		
		//balance小于0，则左子树高度小于右子树高度
		if(balance<-1){
			if(rChild.getBalance() < 0)
				root = adjustRR();
			else
				root = adjustRL();
		}
		
		calcu_balance();
		
		return root;
	}

	/**
	 * LL方法：
	 * 		1、当前节点（根节点）的左子树 -转成-> 新的根节点
	 * 		2、新根节点的右子树  -转成-> 旧根节点的左子树
	 * 		3、旧根结点 -转成-> 新根节点的右子树
	 * @return
	 */
	private AVLTree adjustLL() {
		AVLTree root = this.lChild;
		this.lChild = root.rChild;
		root.rChild = this;
		return root;
	}
	
	/**
	 * RR方法：
	 * 		1、当前节点（根节点）的右子树 -转成-> 新的根节点
	 * 		2、新根节点的左子树  -转成-> 旧根节点的右子树
	 * 		3、旧根结点 -转成-> 新根节点的左子树
	 * @return
	 */
	private AVLTree adjustRR() {
		AVLTree root = this.rChild;
		this.rChild = root.lChild;
		root.lChild = this;
		return root;
	}
	
	/**
	 * LR方法：
	 * 		1、当前节点（根节点）的左子树进行RR平衡调整 
	 * 		2、当前节点（根节点）整体进行LL调整
	 * @return
	 */
	private AVLTree adjustLR() {
		lChild = lChild.adjustRR();
		return adjustLL();
	}
	
	/**
	 * RL方法：
	 * 		1、当前节点（根节点）的右子树进行LL平衡调整 
	 * 		2、当前节点（根节点）整体进行RR调整
	 * @return
	 */
	private AVLTree adjustRL() {
		rChild = rChild.adjustLL();
		return adjustRR();
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
public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVLTree root = new AVLTree(100);
		root = root.add(new AVLTree(110));
		root = root.add(new AVLTree(120));
		root = root.add(new AVLTree(130));
		root = root.add(new AVLTree(140));
		root = root.add(new AVLTree(150));
		root = root.add(new AVLTree(160));
		root = root.add(new AVLTree(170));
		root = root.add(new AVLTree(180));
		root = root.add(new AVLTree(90));
		root = root.add(new AVLTree(40));
		root = root.add(new AVLTree(50));
		root = root.add(new AVLTree(80));
		root = root.add(new AVLTree(92));
		root = root.add(new AVLTree(91));
//		root.mid_show();
		root.display();
	}

}
