package say5;
/**
 * ����4���ǹ�һ������7���ǹ�һ����������ϣ�����򲻵���������Ƕ���
 * ��������4���������򵽣�����涼�������ˣ������򵽸����ﵽ��С��װ�������ɣ�
 * @author Soloist
 *
 */
public class Test {

	public static final int N = 1000*100;
	
	//���������ܹ��򵽵��ǹ���
	//da[] ���ڱ���Ƿ����򵽣�a ��С��װ����
	public static int se(int[]da,int a){
		int n=0;
		for(int i=0;i<da.length;i++){
			if(da[i]==1){
				n++;
				if(n>=a)	//�����򵽸����ﵽ��С��װ��������
					return i-a;	//��a��Ϊ���ҵ��򲻵����Ǹ���
			}else{
				n=0;	//����n
			}
		}
		return -1;	//�Ҳ������
	}
	// a*i + b*j��i��j = 0,1,2,3...�� 
	public static void f(int a,int b){
		int[] da = new int[N];
		
		for(int i=0;i<N/a;i++){
			for(int j=0;j<(N-i*a)/b;j++){
				if(i*a+b*j<N){
					da[i*a+b*j] = 1;	//ͨ����������������õ�����
				}
			}
		}
		
		System.out.println(se(da,a));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f(4,7);
	}

}
