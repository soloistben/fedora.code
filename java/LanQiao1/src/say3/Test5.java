package say3;
/**
 * ��֪����������������ϸ��Ŀ�������һ�ʻ򼸱�©��
 * �ⷨ��ÿ����Ŀ��ϸ�����п��ܱ���©���������������1��0��ѡ���벻ѡ�񣩣�
 * 		ÿ���������һ�飬�ݹ�ʱ�����ۻ���ǰ��
 * 		���ڴ���������ʱ��û�б�ѡ�е���ϸ�п���ʱ����©���Ǽ�����Ŀ
 * 
 * @author soloist
 * ע���������˳��
 * ע����ݣ����û��޸�����
 */
public class Test5 {
	/**
	 * �ݹ����
	 * @param err_sum	�д���ܽ��
	 * @param a		��ϸ������ֻ���벻�޸ģ�
	 * @param index	��ǰ��ϸλ��
	 * @param cur_sum 	ǰ�ߺ�Ԫ���ۼӵĺ�
	 * @param b		��¼��ϸѡ��
	 */
	public static void f(int err_sum,int[] a,int index,int cur_sum,boolean[] b) {
		if(cur_sum > err_sum) return;	//��ǰ�ۻ�����������
		if(err_sum == cur_sum) {		//��ǰ�����ڴ�����
			System.out.println("����©��ϸ�����ǣ�");
			for(int i=0;i<b.length;i++) {
				if(b[i]==false)
					System.out.println("��"+(i+1)+"�� "+a[i]+"Ԫ");	//��� ��ѡ ����ϸ�±�
			}
			System.out.println();
			return;
		}
		if(index >= a.length) return;	//��ǰԪ��Խ��
		
		b[index] = false;	//��ѡ
		f(err_sum,a,index+1,cur_sum,b);
		
		b[index] = true;	//ѡ
		cur_sum += a[index];	//��ǰ��ϸ��ѡ�ˣ����ۼӵ�ǰ���
		f(err_sum,a,index+1,cur_sum,b);
		b[index] = false;  //���ݣ���
	}
	public static void main(String[] args) {
		int[] a = {3,2,4,3,1};	//5����ϸ��Ŀ
		boolean[] b = new boolean[a.length];	//���ڼ�¼��ϸ�� ѡ��
		int sum = 6;	//�����ܶ�
		System.out.println("��ǰ�����ܽ���ǣ�"+sum+"Ԫ");
		System.out.println("��ϸ��");
		for(int i:a) {
			System.out.print(i+" ");
		}
		System.out.println();
		f(sum,a,0,0,b);
	}

}
