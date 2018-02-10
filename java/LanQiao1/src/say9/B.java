package say9;
/*
 * ƽ������������������ĸ߶�������1
 * ��ÿ����ӽڵ��ȥ�����ж��Ƿ�ƽ�⣬��ƽ�������ƽ��
 * ������
 * 	LL�����������������߶ȹ��ߣ�
 * 	LR�����������������߶ȹ��ߣ�
 * 	RR�����������������߶ȹ��ߣ�
 * 	RL�����������������߶ȹ��ߣ�
 */
class AVLTree{
	private int data; //ֵ
	private AVLTree lChild;	//������
	private AVLTree rChild;	//������
	private int balance = 0;
	
	public AVLTree(int data) {
		this.data = data;
	}

	public int getBalance() {
		return balance;
	}

	//�����Ƿ�ƽ��
	public void calcu_balance(){
		int lh = lChild==null?0:lChild.getHeight();
		int rh = rChild==null?0:rChild.getHeight();
		balance = (lh-rh)/2;	//����αͼ���еĸ��������ߣ�2������㣨��������1��-1��	
	}
	
	public AVLTree add(AVLTree avlTree){
		AVLTree root = this;
		if(avlTree.data < data){
			if(lChild==null)
				lChild = avlTree;
			else
				lChild = lChild.add(avlTree);	//���ؽ�㣺����ƽ��������������ָ��ڵ��п��ܻᷢ���仯
		}else{
			if(rChild==null)
				rChild = avlTree;
			else
				rChild = rChild.add(avlTree);
		}
		
		//�ж�ƽ��
		calcu_balance();
		
		//balance����0�����������߶ȴ����������߶�
		if(balance>1){	
			if(lChild.getBalance() > 0)
				root = adjustLL();
			else
				root = adjustLR();
		}
		
		//balanceС��0�����������߶�С���������߶�
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
	 * LL������
	 * 		1����ǰ�ڵ㣨���ڵ㣩�������� -ת��-> �µĸ��ڵ�
	 * 		2���¸��ڵ��������  -ת��-> �ɸ��ڵ��������
	 * 		3���ɸ���� -ת��-> �¸��ڵ��������
	 * @return
	 */
	private AVLTree adjustLL() {
		AVLTree root = this.lChild;
		this.lChild = root.rChild;
		root.rChild = this;
		return root;
	}
	
	/**
	 * RR������
	 * 		1����ǰ�ڵ㣨���ڵ㣩�������� -ת��-> �µĸ��ڵ�
	 * 		2���¸��ڵ��������  -ת��-> �ɸ��ڵ��������
	 * 		3���ɸ���� -ת��-> �¸��ڵ��������
	 * @return
	 */
	private AVLTree adjustRR() {
		AVLTree root = this.rChild;
		this.rChild = root.lChild;
		root.lChild = this;
		return root;
	}
	
	/**
	 * LR������
	 * 		1����ǰ�ڵ㣨���ڵ㣩������������RRƽ����� 
	 * 		2����ǰ�ڵ㣨���ڵ㣩�������LL����
	 * @return
	 */
	private AVLTree adjustLR() {
		lChild = lChild.adjustRR();
		return adjustLL();
	}
	
	/**
	 * RL������
	 * 		1����ǰ�ڵ㣨���ڵ㣩������������LLƽ����� 
	 * 		2����ǰ�ڵ㣨���ڵ㣩�������RR����
	 * @return
	 */
	private AVLTree adjustRL() {
		rChild = rChild.adjustLL();
		return adjustRR();
	}
	
	//���������������
	public void mid_show(){
		if(lChild!=null) lChild.mid_show();
		System.out.print(data+" ");
		if(rChild!=null) rChild.mid_show();
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
		int w = (""+data).length();
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
		String sData = data+"";	//ֵתΪ�ַ������ַ���һά���飩
		
		int p1 = lChild==null?x:lChild.getRootPos(x); 
		int p2 = getRootPos(x);		//�����ߵ�λ��
		int p3 = rChild==null?p2:rChild.getRootPos(p2+sData.length());
		
		buf[y][p2] = '|';
		for(int i=p1;i<=p3;i++)		//��ȫ�� �»���_
			buf[y+1][i]='-';
		for(int i=0;i<sData.length();i++)	//��ǰֵ ����buf �滻 �»���_
			buf[y+1][p2+i]=sData.charAt(i);
		if(p1<p2)
			buf[y+1][p1] = '+';
		if(p3>p2)
			buf[y+1][p3] = '+';
		
		if(lChild!=null) lChild.printInBuf(buf, x, y+2);
		if(rChild!=null) rChild.printInBuf(buf, p2+sData.length(), y+2);
	}
	
	//�ڵ������ߵ�λ��
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
