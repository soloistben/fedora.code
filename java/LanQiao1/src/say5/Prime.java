package say5;

public class Prime {

	public static void main(String[] args) {
		
		//ɸ�� �������������100002������
		int N = 1000 * 1000 * 10; //ȡ���ϴ���
		int x = 100001;	//��100002������
		byte[] a = new byte[N];	//���Ϊ0��Ϊ����������������
		
		for(int i=2;i<N/2;i++){
			if(a[i]==1)	//�Ѿ����Ϊ1�ľ���������4�ı�����Ҳ��2�ı���
				continue;
			for(int k=2; k<=N/i;k++){	//��ȥ2�ı�����3�ı�����4�ı���...
				if(i*k<N)
					a[i*k] = 1;	//��Щ����������
			}
		}
		
		int m=0;
		for(int i=2;i<N;i++){
			if(a[i] == 0){
				m++;
				if(m==x)
					System.out.print(i+" ");
			}
		}
	}

}
