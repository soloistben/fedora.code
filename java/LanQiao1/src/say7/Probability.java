package say7;


/**
 * 30���˰༶�����������ظ��ĸ����ж��
 * @author Soloist
 *
 */
public class Probability {

	public static void main(String[] args) {
		// ����ģ��
		// 0-365����������֣���û����ײ
		final int N = 1000*100;	//ʮ���
		int n=0;
		for(int i=0;i<N;i++){
			int[] x = new int[365];	//���������
			for(int j=0;j<30;j++){	//30��
				int p = (int) (Math.random()*365);	//���ֵ��0-364��				
				if(x[p]==1){	//�������ײ�����ȡ��һ����ֵ
					n++;
					break;
				}else	
					x[p] = 1;
			}
		}
		double r = (double)n/N;
		System.out.println(r);
	}

}
