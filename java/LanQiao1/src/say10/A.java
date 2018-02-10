package say10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

interface BiTree{
	public BiTree getLeft();
	public BiTree getRight();
	public String str();
	public int getWidth();
	public int getHight();
}
/*
 * ��������
 */
class HuffmanTree implements BiTree{
	
	private char ch;	//�������ַ�
	private int w;		//������Ȩ
	private HuffmanTree l;
	private HuffmanTree r;	
	
	public BiTree getLeft() {return l;}
	public BiTree getRight() {return r;}
	public String str() {return ch + ":" + w;}

	@Override
	public int getWidth() {
		int sum = 1;
		if(l!=null) sum += l.getWidth();
		if(r!=null) sum += r.getWidth();
		return sum;
	}

	@Override
	public int getHight() {
		int hl = l==null ? 0:l.getHight();
		int hr = r==null ? 0:r.getHight();
		return Math.max(hl, hr)+1;
	}
	
	public HuffmanTree(char c, int weight) {
		this.ch = c;
		this.w = weight;
	}
	
	public static HuffmanTree join(HuffmanTree a,HuffmanTree b){
		HuffmanTree tmp = new HuffmanTree((char) 0, a.w + b.w);	 //(char) 0 ��ʾ�ո�
		tmp.l = a;
		tmp.r = b;
		return tmp;
	}
	
	public static void create(List<HuffmanTree> list){
		//��Ϊ�����Ƚ��Ƕ�����˽���һ���Ƚ��������ڱȽ�
		Comparator<HuffmanTree> cp = new Comparator<HuffmanTree>() {
			@Override
			public int compare(HuffmanTree o1, HuffmanTree o2) {				
				return o1.w - o2.w;		//С��0������0.����0
			}
		};
		/**
		 * ����С�������кϲ����ٽ�������
		 */
		while(list.size()>1){
			Collections.sort(list,cp);	//ͨ���Ƚ�������С����
			HuffmanTree a = list.remove(0);		//�����С��
			HuffmanTree b = list.remove(0);		//��ý�С�ģ�ɾ��һ�����±����ǰ��һλ
			list.add(join(a,b));	//���շ���һ�����ڵ�
		}
	}
	
	public void show(){
		if(l!=null){
			l.show();
		}
		System.out.println(ch+":"+w);		
		if(r!=null){
			r.show();
		}
	}
}

public class A {

	public static void main(String[] args) {
		List<HuffmanTree> list = new ArrayList<HuffmanTree>();
		list.add(new HuffmanTree('a', 45));
		list.add(new HuffmanTree('b', 13));
		list.add(new HuffmanTree('c', 12));
		list.add(new HuffmanTree('d', 16));
		list.add(new HuffmanTree('e', 9));
		list.add(new HuffmanTree('f', 5));
		
		HuffmanTree.create(list);	
		list.get(0).show();
	}

}
