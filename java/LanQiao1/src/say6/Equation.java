package say6;

public class Equation {

	public static void main(String[] args) {
		/**
		 * a,b,c������x,y����������
		 */
		//ax+by=c
		//4x-5y=7
		//1�������ƽ⣨С��Χ��ȡ��
		for(int i=0;i<100;i++)
			for(int j=0;j<100;j++){
				if((4*i-5*j)==7){
					System.out.println("x="+i+" y="+j);
				}
			}
		System.out.println("-------------");
		//2���Ż��ٶȣ�˫��ѭ��תΪ����ѭ����0
		//ax=c-by
		//����һ���⣨x0 y0����
		//����ͨ�⣨x=x0+bt����y=y0-at����t=-2.-1.0.1.2.3...��
		for(int k=0;k<100;k++){
			if((7-(-5*k))%4==0){
				System.out.println("x="+(7-(-5*k))/4+" y="+k);
				break;
			}
		}
	}

}
