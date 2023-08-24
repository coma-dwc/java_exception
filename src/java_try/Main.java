package java_try;

//public class Main {
//	private static int divide(int a, int b) {
//		try {
//			return a / b;
//		} catch (ArithmeticException e) {
//		  return 0;
//		}
//	}
//	
//	public static void main(String[] args) {
//		System.out.println("テスト1: " + divide(12, 4));
//		System.out.println("テスト2: " + divide(12, 0));
//		System.out.println("テスト3: " + divide(12, 2));
//	}
//}
//try ～ catchを使用することでtryのブロックで発生したエラーを捕捉して、
//エラー処理を行うことができる
//ここではArithmeticExceptionを捕捉して、それが発生した場合は0を返している


//printStackTrace
//例外捕捉時に発生したExceptionのprintStackTrace()メソッドを実行

public class Main {
	private static int divide(int a, int b) {
		try {
			return a / b;
		} catch (ArithmeticException e) {
		  e.printStackTrace();
		  return 0;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("テスト1: " + divide(12, 4));
		System.out.println("テスト2: " + divide(12, 0));
		System.out.println("テスト3: " + divide(12, 2));
	}
}
//printStackTrace()は実行することで発生したExceptionのスタックトレースを出力することが出来る