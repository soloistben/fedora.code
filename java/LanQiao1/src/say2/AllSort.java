package say2;
/**
 * ��n��Ԫ��ȫ����
 * abc acb bac bca cab cba
 * @author Soloist
 *
 */
public class AllSort {
	/**
	 * ȫ����
	 * @param data
	 * @param index	��ǰ��Ҫ������λ�ã�Ԥ�ں���Ԫ�ؽ���
	 */
	public static void f(char[] data,int index){
		if(index == data.length){
			for(int i=0;i<data.length;i++){
				System.out.print(data[i]+" ");
			}
			System.out.println();
		}
		for(int i=index;i<data.length;i++){
			//ÿ���ַ����һ���ַ��ཻ����ÿ���ַ������Է��ڵ�һλ��
			{char tmp = data[index]; data[index] = data[i]; data[i] = tmp;}
			//ÿ�ν�����ʼ�ݹ�
			f(data,index+1);
			//���ݣ�ÿ�ν�����ɺ���Ҫ��λ�ý���������
			{char tmp = data[index]; data[index] = data[i]; data[i] = tmp;}
		}
	}
	
	public static void main(String[] args) {
		char[] data = "ABCD".toCharArray();
		f(data,0);
	}

}
