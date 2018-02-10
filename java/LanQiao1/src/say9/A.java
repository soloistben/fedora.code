package say9;
/*
 * ���ݽṹ
 * 1�����Խṹ�����顢vector������������stack��ջ��
 * 2�����νṹ�����������ص㣩
 * 3��ͼ
 * 
 * 
 * ƽ������������������ĸ߶�������1
 * ������LL��RR��LR��RL
 * 
 */
//������:�ݹ鶨�巨�������ڵݹ飩
//����һ������������������ֵ�ȸ���ֵС������ֵ����������ֵС
class BiTree{
	private int data; //ֵ
	private BiTree lChild;	//������
	private BiTree rChild;	//������
	
	public BiTree(int data) {
		this.data = data;
	}
	
	//��ӽڵ㣨�ݹ飩
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
