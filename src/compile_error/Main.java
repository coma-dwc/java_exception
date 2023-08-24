package compile_error;

//コンパイルエラーの例１
//public class Main {
//	public static void main(String[] args) {
//		System.out.pritnln("!Hello World"); //printlnの綴りが間違っているのでコンパイルエラー
//	}
//}

//コンパイルエラーの例２
//public class Main {
//	public static void main(String[] args) {
//		System.out.pritnln("!Hello World")　//末尾に;がないので以下略
//	}
//}


//実行時エラー
//public class Main {
//	public static void main(String[] args) {
//		System.out.println("テスト1: " + (12 / 4));
//		System.out.println("テスト2: " + (12 / 0));  //ここでエラー(0除算の実行時エラー)
//		System.out.println("テスト3: " + (12 / 2));
//	}
//}


//スタックトレースを読む
public class Main {
	public static void main(String[] args) {
		methodA();  //mainの中でmethodAを実行する
	}
	
	private static void methodA() {
		methodB();  //methodAの中でmethodBを実行する
	}
	
	private static void methodB() {
		methodC();  //methodBの中でmethodCを実行する
	}
	
	private static void methodC() {
		methodD();  //methodCの中でmethodDを実行する
	}
	
	private static void methodD() {
		methodE();  //methodDの中でmethodEを実行する
	}
	
	private static void methodE() {
		System.out.println("テスト1: " + (12 / 4));
		System.out.println("テスト2: " + (12 / 0));
		System.out.println("テスト3: " + (12 / 2));
	}  //methodEの中で実行時エラーが発生する
}