package Error;

//・OutOfMemoryError
//巨大なバイト配列の確保を試みてOutOfMemoryErrorを発生させる

//public class Main {
//	public static void main(String[] args) {
//		byte[] data = new byte[Integer.MAX_VALUE];
//		System.out.println(data.length);
//	}
//}

//OutOfMemroyErrorはメモリを確保しようとした時に、
//既にメモリ資源が枯渇していて必要なメモリが確保できなかった場合に発生する

//この例では一気に巨大メモリを確保しようとしてわざと失敗させていますが、
//通常は徐々にメモリ使用量が増加して容量がいっぱいになったところで発生するので、
//どこで発生するかを予測することができない


//・StackOverflowError
//無限に再起するメソッドinfinity()を定義してStackOverflowErrorを発生させる

public class Main {
	private static int infinity(int n) {
		return infinity(n + 1);
	}
	
	public static void main(String[] args) {
		System.out.println(infinity(0));
	}
}

//StackOverflowErrorは
//あるメソッドの中から別のメソッドがコールされる。
//そのメソッドの中からまた別のメソッドがコールされる。
//という処理構造が深く積み上がった場合に発生する
//多くの場合は、この例のように再帰関数が(バグによって)無限にコールされる事によって発生

//StackOverFlowErrorのStackはprintStackTrace()のStackと同じもの
//StackOverFlowErrorではStackが非常に深く積まれているので、
//printStackTrace()で出力されるスタックトレースも非常に長くなる