package say9;
/*
 * �������Ч�ʱ�AVL���ߣ�
 * ���壺
 * 	1��ÿ���ڵ�Ҫô�Ǻ�ɫ��Ҫô�Ǻ�ɫ
 * 	2�����ڵ��Ǻ�ɫ
 * 	3��ÿ��Ҷ�ӽ��Ϳսڵ㶼�Ǻ�ɫ
 * 	4�����һ���ڵ��Ǻ�ɫ����ô���������Ӷ��Ǻ�ɫ
 * 	5����ÿ���ڵ㣬�Ӹýڵ㵽������ڵ������·���ϰ�����ͬ��Ŀ�ĺڽڵ�
 * 
 * ���ݹ飩�����������һ�����ֱ���Ǻ�ɫ�ڵ���룬��Ҫ�ٱ�ɫ��
 * 	1������ڵ��Ǹ��ڵ㣨���ڵ�ֱ�ӱ��ɫ��û�и��ڵ���Ǹ��ڵ㣩
 * 	2������ڵ�ĸ��ڵ��Ǻ�ɫ����û�£�ֱ�Ӳ��룩
 * 	3����ǰ�ڵ�ĸ��ڵ��Ǻ�ɫ��������ڵ�Ҳ�Ǻ�ɫ-->�����ڵ������ڵ�ͬʱ��ڣ��游�ڵ��졣
 * 	      �ѵ�ǰ�ڵ�ָ���游�ڵ㣬�����µĵ�ǰ�ڵ����¿�ʼ�㷨���ݹ飩
 * 	4����ǰ�ڵ�ĸ��ڵ��Ǻ�ɫ��������ڵ�Ҳ�Ǻ�ɫ��
 * 	      ��ǰ�ڵ�������-->��ǰ�ڵ�ĸ��ڵ���Ϊ�µĵ�ǰ�ڵ㣨�ݹ飩�����µ�ǰ�ڵ�Ϊ֧������
 * 	      ��ǰ�ڵ�������-->���ڵ��ڣ��游�ڵ�Ϊָ������								
 */
enum Color{
	Red,Black
}
class RedBlackTree{
	private int data; 	//ֵ
	private RedBlackTree parent;	//���ڵ�
	private RedBlackTree uncle;		//����ڵ�
	private RedBlackTree lChild;	//������
	private RedBlackTree rChild;	//������
	private Color color;	//��ɫ
	private boolean isLeft;	//����������Ϊtrue
	//��ͨ����ڵ�
	public RedBlackTree(int data){
		this.data = data;
		this.color = Color.Red;	//Ĭ���Ǻ�ɫ
	}
	//���ڵ㴴��
	public RedBlackTree(int data,String root){
		this.data = data;
		if(root == "root")
			this.color = Color.Black;
		this.parent = null;
		this.isLeft = false;
	}
	
	public RedBlackTree getUncle() {	
		if(this.parent!=null && this.parent.parent!=null){
			if(this.parent.isLeft)	//��ǰ�ڵ�ĸ��ڵ����游�ڵ��������
				uncle = this.parent.parent.rChild;	//�����������������������Ƿ�null��
			else
				uncle = this.parent.parent.lChild;	//����������
		}
		return uncle;
	}
	
	//���������������
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
				//root = RBtTurn(rbTree);	//����һ���ڵ�֮�󣬽��е���
			}else
				lChild.add(rbTree);	//���ؽ�㣺�����������������ָ��ڵ��п��ܻᷢ���仯
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
		add(rbTree);	//�����ϣ���Ϊ����������������޷��ڵݹ��е�����
		root = RBtTurn(rbTree);	//�ٵ���
		return root;
	}
	
	/**
	 * ��ڵ���
	 * ���¼���ڵ㣬�����жϵ��������󣡣�����������������������
	 * @param rbTree
	 * @return
	 */
	private RedBlackTree RBtTurn(RedBlackTree rbTree) {
		RedBlackTree root = this;
		if(rbTree.parent==null)
			//��ǰ�ڵ��Ǹ��ڵ�
			rbTree.color = Color.Black;
		if(rbTree.parent.color == Color.Black)
			//��ǰ�ڵ㸸�ڵ��Ǻ�ɫ
			return root;
		if(rbTree.parent.color == Color.Red){
			//���׽ڵ�Ϊ��ɫ
			if(rbTree.getUncle() != null && rbTree.getUncle().color == Color.Red){
				//����ڵ�ͬʱΪ��ɫ
				rbTree.parent.color = Color.Black;
				rbTree.getUncle().color = Color.Black;
				RBtTurn(rbTree.parent.parent);
			}
			if(rbTree.getUncle() == null || rbTree.getUncle().color == Color.Black){
				//����ڵ�Ϊ�սڵ�Ҳ���ɫ 
				if(rbTree.isLeft){
					//�жϲ���ڵ������ӻ�������
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
	 * ������
	 * 	1����������Ϊ�¸��ڵ㣨���ڵ�ת�����Ƿ���������ת����
	 * 	2���¸��ڵ㣨ԭ����������������Ϊ�ɸ��ڵ��������
	 * 	3���ɸ��ڵ�Ϊ�¸��ڵ��������
	 * @param oldRoot ֧��
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
	 * ������
	 * 	1����������Ϊ�¸��ڵ�
	 * 	2���¸��ڵ㣨ԭ����������������Ϊ�ɸ��ڵ����������
	 * 	3���ɸ��ڵ�Ϊ�¸��ڵ��������
	 * @param oldRoot ֧��
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
	
	//��ȡαͼ����ʾ�ĸ߶�
	public int getHeight(){
		int h = 2;	//���������� ��һ��
		int hl = lChild == null?0:lChild.getHeight();
		int hr = rChild == null?0:rChild.getHeight();
		return h + Math.max(hl, hr);	//ֻҪ�ϴ���
	}
	
	//��ȡαͼ����ʾ�Ŀ��
	public int getWidth(){
		String sColor = color == Color.Red?"R":"B"; 
		int w = (""+data+sColor).length();
		if(lChild!=null) w += lChild.getWidth();
		if(rChild!=null) w += rChild.getWidth();
		return w;
	}
	
	//αͼ����ʾ
	public void display(){
		char[][] buf = new char[getHeight()][getWidth()];
		printInBuf(buf,0,0);
		displayBuf(buf);
	}
	
	//��ʾ����������
	private void displayBuf(char[][] buf) {
		for(int i=0;i<buf.length;i++){
			for(int j=0;j<buf[i].length;j++)
				System.out.print(buf[i][j]==0?' ':buf[i][j]);
			System.out.println();
		}
	}
	
	//��������αͼ�����뻺��
	private void printInBuf(char[][] buf, int x, int y) {
		String sColor = color == Color.Red?"R":"B"; 
		String sData = data+""+sColor;	//ֵתΪ�ַ������ַ���һά���飩
		
		int p1 = lChild==null?x:lChild.getRootPos(x); 
		int p2 = getRootPos(x);		//�����ߵ�λ��
		int p3 = rChild==null?p2:rChild.getRootPos(p2+sData.length());
		
		buf[y][p2+1] = '|';
		for(int i=p1+1;i<=p3;i++)		//��ȫ�� �»���_
			buf[y+1][i]='-';
		for(int i=0;i<sData.length();i++)	//��ǰֵ ����buf �滻 �»���_
			buf[y+1][p2+i]=sData.charAt(i);
		if(p1<p2)
			buf[y+1][p1+1] = '+';
		if(p3>p2)
			buf[y+1][p3+1] = '+';
		
		if(lChild!=null) lChild.printInBuf(buf, x, y+2);
		if(rChild!=null) rChild.printInBuf(buf, p2+sData.length(), y+2);
	}
	
	//�ڵ������ߵ�λ��
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
