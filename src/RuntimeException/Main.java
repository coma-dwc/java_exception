package RuntimeException;

//・割り算のメソッド(再)
//divide()のサンプルを改変してtry～catchの部分を取り除く

//public class Main {
//	private static int divide(int a, int b) {
//		return a / b;
//	}
//	
//	public static void main(String[] args) {
//		System.out.println("テスト1: " + divide(12, 4));
//		System.out.println("テスト2: " + divide(12, 0));
//		System.out.println("テスト3: " + divide(12, 2));
//	}
//}

//divide()メソッドでは0除算が発生した場合にArithmeticExceptionが発生する
//しかし、try～catchで括られていないにも関わらずコンパイルエラーとはならず、
//実行時にエラーが発生した箇所でプログラムは中断する
//このように例外が発生するにもかかわらずそれを処理しないことが許されるものを
//「非検査例外」という
//クラス構造的には非検査例外はRuntimeExceptionのサブクラス
//※非検査例外がなぜcatchを強制されないかというと、非検査例外の発生する原因が
//ほとんどの場合バグだから

//・NullPointerException
//変数strにnullを代入してNullPointerExceptionを発生させる
//public class Main {
//	public static void main(String[] args) {
//		String str = null;
//		System.out.println(str.toUpperCase());
//	}
//}
//この例では変数strはString型なので、String型の持つメソッドtoUpperCase()を実行可能なはずですが、
//値がnullだとメソッドの実行が出来ないためNullPointerExceptionとなる


//・ArrayIndexOutOfBoundsException
//3つの良い嘘を持つ配列変数arrayから4番目の要素(インデックス=3)にアクセスして
//ArrayIndexOutOfBoundsExceptionを発生させる

public class Main {
	public static void main(String[] args) {
		int[] array = new int[] { 5, 10, 15};
		System.out.println(array[3]);
	}
}
