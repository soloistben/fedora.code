package say8;
/*
 * 井字棋（有平局的博弈 ）
 * f(局面)--->胜负平
 * {
 * 		tag = 负
 * 		for(对所有可走位置){
 * 			试走 ----> 局面y
 * 			结果 t = f(y)
 * 			if(t==负)
 * 				return 胜
 * 			if(t==平)
 * 				tag = 平		//不能直接返回平，可以试其他走法逼平
 * 		}
 * 		return tag
 * }
 */
public class Game1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
