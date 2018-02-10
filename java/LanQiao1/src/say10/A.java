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
 * 哈夫曼树
 */
class HuffmanTree implements BiTree{
	
	private char ch;	//待编码字符
	private int w;		//本树总权
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
		HuffmanTree tmp = new HuffmanTree((char) 0, a.w + b.w);	 //(char) 0 表示空格
		tmp.l = a;
		tmp.r = b;
		return tmp;
	}
	
	public static void create(List<HuffmanTree> list){
		//因为两个比较是对象，因此建立一个比较器，用于比较
		Comparator<HuffmanTree> cp = new Comparator<HuffmanTree>() {
			@Override
			public int compare(HuffmanTree o1, HuffmanTree o2) {				
				return o1.w - o2.w;		//小于0，等于0.大于0
			}
		};
		/**
		 * 将最小两个进行合并，再进行排序
		 */
		while(list.size()>1){
			Collections.sort(list,cp);	//通过比较器排序（小到大）
			HuffmanTree a = list.remove(0);		//获得最小的
			HuffmanTree b = list.remove(0);		//获得较小的，删除一个，下标会往前进一位
			list.add(join(a,b));	//最终返回一个根节点
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
