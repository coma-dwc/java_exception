package Error;

//・OutOfMemoryError
//巨大なバイト配列の確保を試みてOutOfMemoryErrorを発生させる

public class Main {
	public static void main(String[] args) {
		byte[] data = new byte[Integer.MAX_VALUE];
		System.out.println(data.length);
	}
}
//OutOfMemroyErrorはメモリを確保しようとした時に、
//既にメモリ資源が枯渇していて必要なメモリが確保できなかった場合に発生する

//この例では一気に巨大メモリを確保しようとしてわざと失敗させていますが、
//通常は徐々にメモリ使用量が増加して容量がいっぱいになったところで発生するので、
//どこで発生するかを予測することができない