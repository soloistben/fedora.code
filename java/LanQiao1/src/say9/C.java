package say9;
/*
 * 红黑树（效率比AVL树高）
 * 定义：
 * 	1、每个节点要么是红色、要么是黑色
 * 	2、根节点是黑色
 * 	3、每个叶子结点和空节点都是黑色
 * 	4、如果一个节点是红色，那么它两个儿子都是黑色
 * 	5、对每个节点，从该节点到其子孙节点的所有路径上包含相同数目的黑节点
 * 
 * （递归）插入情况：（一般情况直接是红色节点插入，需要再变色）
 * 	1、插入节点是根节点（根节点直接变黑色，没有父节点就是根节点）
 * 	2、插入节点的父节点是黑色（则没事，直接插入）
 * 	3、当前节点的父节点是红色，且叔叔节点也是红色-->将父节点和叔叔节点同时变黑，祖父节点变红。
 * 	      把当前节点指向祖父节点，，从新的当前节点重新开始算法（递归）
 * 	4、当前节点的父节点是红色，且叔叔节点也是黑色，
 * 	      当前节点是右子-->当前节点的父节点作为新的当前节点（递归），以新当前节点为支点左旋
 * 	      当前节点是左子-->父节点变黑，祖父节点为指点右旋								
 */
enum Color{
	Red,Black
}
class RedBlackTree{
	private int data; 	//值
	private RedBlackTree parent;	//父节点
	private RedBlackTree uncle;		//叔叔节点
	private RedBlackTree lChild;	//左子树
	private RedBlackTree rChild;	//右子树
	private Color color;	//颜色
	private boolean isLeft;	//是左子树则为true
	//普通插入节点
	public RedBlackTree(int data){
		this.data = data;
		this.color = Color.Red;	//默认是红色
	}
	//根节点创建
	public RedBlackTree(int data,String root){
		this.data = data;
		if(root == "root")
			this.color = Color.Black;
		this.parent = null;
		this.isLeft = false;
	}
	
	public RedBlackTree getUncle() {	
		if(this.parent!=null && this.parent.parent!=null){
			if(this.parent.isLeft)	//当前节点的父节点是祖父节点的左子树
				uncle = this.parent.parent.rChild;	//则叔叔结点是右子树（不管是否null）
			else
				uncle = this.parent.parent.lChild;	//否则是左孩子
		}
		return uncle;
	}
	
	//遍历（中序遍历）
	public void mid_show(){
		if(lChild!=null) lChild.mid_show();
		System.out.print(data+":"+color+":"+isLeft+" ");
		if(rChild!=null) rChild.mid_show();
	}
	
	private void add(RedBlackTree rbTree){
		//RedBlackTree root = this;
		if(rbTree.data < data){
			if(lChild==null){
				lChild = rbTree;
				rbTree.parent = this;
				rbTree.isLeft = true;
				//root = RBtTurn(rbTree);	//加入一个节点之后，进行调整
			}else
				lChild.add(rbTree);	//返回结点：经过调整左子树部分根节点有可能会发生变化
		}else{
			if(rChild==null){
				rChild = rbTree;
				rbTree.parent = this;
				rbTree.isLeft = false;
				//root = RBtTurn(rbTree);
			}else
				rChild.add(rbTree);
		}
		//RBtTurn(rbTree);
		//return root;
	}
	
	public RedBlackTree addRBTree(RedBlackTree rbTree){
		RedBlackTree root = this;
		add(rbTree);	//添加完毕（因为调整是整体调整，无法在递归中调整）
		root = RBtTurn(rbTree);	//再调整
		return root;
	}
	
	/**
	 * 红黑调整
	 * 将新加入节点，进行判断调整（有误！！！！！！！！！！！！）
	 * @param rbTree
	 * @return
	 */
	private RedBlackTree RBtTurn(RedBlackTree rbTree) {
		RedBlackTree root = this;
		if(rbTree.parent==null)
			//当前节点是根节点
			rbTree.color = Color.Black;
		if(rbTree.parent.color == Color.Black)
			//当前节点父节点是黑色
			return root;
		if(rbTree.parent.color == Color.Red){
			//父亲节点为红色
			if(rbTree.getUncle() != null && rbTree.getUncle().color == Color.Red){
				//叔叔节点同时为红色
				rbTree.parent.color = Color.Black;
				rbTree.getUncle().color = Color.Black;
				RBtTurn(rbTree.parent.parent);
			}
			if(rbTree.getUncle() == null || rbTree.getUncle().color == Color.Black){
				//叔叔节点为空节点也算黑色 
				if(rbTree.isLeft){
					//判断插入节点是左子还是右子
					rbTree.parent.color = Color.Black;
					rbTree.parent.parent.color = Color.Red;
					root = turnRight(rbTree.parent.parent);			
				}else{
					root = turnLeft(rbTree.parent);
					//RBtTurn(rbTree.parent);
					root = RBtTurn(root.lChild);
				}
			}
		}
		return root;
	}
	
	/**
	 * 左旋：
	 * 	1、右子树变为新根节点（父节点转换，是否左右子树转换）
	 * 	2、新根节点（原右子树）左子树变为旧根节点的右子树
	 * 	3、旧根节点为新根节点的左子树
	 * @param oldRoot 支点
	 * @return
	 */
	private RedBlackTree turnLeft(RedBlackTree oldRoot) {
		
		RedBlackTree newRoot = oldRoot.rChild;
		newRoot.parent = oldRoot.parent;	
		newRoot.isLeft = oldRoot.isLeft;
		
		//if(newRoot.lChild != null){
			oldRoot.rChild = newRoot.lChild;
			newRoot.lChild.parent = oldRoot;
			newRoot.lChild.isLeft = false;
		//}
		
		newRoot.lChild = oldRoot;
		oldRoot.parent = newRoot;
		oldRoot.isLeft = true;	
		
		return newRoot;
	}
	/**
	 * 右旋：
	 * 	1、左子树变为新根节点
	 * 	2、新根节点（原左子树）右子树变为旧根节点的右左子树
	 * 	3、旧根节点为新根节点的右子树
	 * @param oldRoot 支点
	 * @return
	 */
	private RedBlackTree turnRight(RedBlackTree oldRoot) {
		
		RedBlackTree newRoot = oldRoot.lChild;
		newRoot.parent = oldRoot.parent;	
		newRoot.isLeft = oldRoot.isLeft;
		
		//if(newRoot.rChild != null){
			oldRoot.lChild = newRoot.rChild;
			newRoot.rChild.parent = oldRoot;
			newRoot.rChild.isLeft = true;
		//}
		
		newRoot.rChild = oldRoot;	
		oldRoot.parent = newRoot;
		newRoot.isLeft = false;
		
		return newRoot;
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
		String sColor = color == Color.Red?"R":"B"; 
		int w = (""+data+sColor).length();
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
		String sColor = color == Color.Red?"R":"B"; 
		String sData = data+""+sColor;	//值转为字符串（字符的一维数组）
		
		int p1 = lChild==null?x:lChild.getRootPos(x); 
		int p2 = getRootPos(x);		//相对左边的位置
		int p3 = rChild==null?p2:rChild.getRootPos(p2+sData.length());
		
		buf[y][p2+1] = '|';
		for(int i=p1+1;i<=p3;i++)		//先全部 下划线_
			buf[y+1][i]='-';
		for(int i=0;i<sData.length();i++)	//当前值 输入buf 替换 下划线_
			buf[y+1][p2+i]=sData.charAt(i);
		if(p1<p2)
			buf[y+1][p1+1] = '+';
		if(p3>p2)
			buf[y+1][p3+1] = '+';
		
		if(lChild!=null) lChild.printInBuf(buf, x, y+2);
		if(rChild!=null) rChild.printInBuf(buf, p2+sData.length(), y+2);
	}
	
	//节点相对左边的位置
	private int getRootPos(int x) {
		return lChild==null?x:x+lChild.getWidth();
	}
}
public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedBlackTree root = new RedBlackTree(100,"root");
		root.addRBTree(new RedBlackTree(50));
		//root.addRBTree(new RedBlackTree(70));
		root.mid_show();
		System.out.println();
		root.display();
	}

}
