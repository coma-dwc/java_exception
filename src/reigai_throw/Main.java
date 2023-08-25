package reigai_throw;

//・IllegalArgumentException
//整数除算のサンプルでdivide()メソッドの中で除数が0の場合は
//IllegalArgumentExceptionをthrowする

public class Main {
	private static int divide(int a, int b) {
		if(b == 0) {
			throw new IllegalArgumentException("除数が0です");
		}
		return a / b;
	}
	
	public static void main(String[] args) {
		System.out.println("テスト1: " + divide(12, 4));
		System.out.println("テスト2: " + divide(12, 0));
		System.out.println("テスト3: " + divide(12, 2));
	}
}

//例外はthrow句を使うことによって自分で投げることができる
//また、各種例外クラスは通常のクラスなのでthrowする際にはnewでインスタンスを作成する必要がある

//ArithmeticExceptionがIllegalArgumentExceptionに変わっただけで、
//動作はほとんど変わらないように感じるが、
//呼び出し側がcatchした例外から得られる情報の質が決定的に変わる

//ArithmeticException
//：例外からメソッドの処理中に0除算が発生したことがわかる
//：このメソッドの引数に0を渡しては行けないんだろうと予想できる

//IllegalArgumentException
//：例外からこのメソッドの引数に0を渡してはいけないことがわかる

