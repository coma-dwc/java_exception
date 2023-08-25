package reigai_throw;

//・IllegalArgumentException
//整数除算のサンプルでdivide()メソッドの中で除数が0の場合は
//IllegalArgumentExceptionをthrowする

//public class Main {
//	private static int divide(int a, int b) {
//		if(b == 0) {
//			throw new IllegalArgumentException("除数が0です");
//		}
//		return a / b;
//	}
//	
//	public static void main(String[] args) {
//		System.out.println("テスト1: " + divide(12, 4));
//		System.out.println("テスト2: " + divide(12, 0));
//		System.out.println("テスト3: " + divide(12, 2));
//	}
//}

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



//・IllegalStateException
//Javaのenumをswitch文と組み合わせて使用する場合、
//switchはenumの網羅性を検査してくれない。
//enum Statusを処理するswitch文のdefaul句で
//IllegalStateException()をthrowするようにする

//enum Status {
//	NotStarted,
//	Processing,
//	Finished,
//}
//
//public class Main {
//	private static void printStatus(Status status) {
//		switch (status) {
//			case NotStarted:
//				System.out.println("まだ処理されていません");
//				break;
//			case Processing:
//				System.out.println("処理中です");
//				break;
//			case Finished:
//				System.out.println("処理済みです");
//				break;
//			default:
//				throw new IllegalStateException();
//		}
//	}
//	
//	public static void main(String[] args) {
//		printStatus(Status.Processing);
//	}
//}

//IllegalStateExceptionはありえない状態が発生したことを示す例外です
//このサンプルでは最後のdefault節がなくても問題なく実行できる
//しかし、将来的に列挙型Statusの値が増えたとしたら、
//printStatus()メソッドもそれに合わせて修正すべきですが、修正せずとも
//printStatus()メソッドは動作するんので修正が必要であることに気が付かないかも
//default節にIllegalStateExceptionを仕込んでおけば、実行時にエラーが発生するのでそこで修正が必要なことに気がつく
//プログラムの作成ではswitchやifでの条件分岐がつきものですが、到達するはずがないコードブロックがある場合は
//そこでIllegalStateExceptionを投げるようにする



//・例外のrethrow
//整数除算のサンプルで先に0をチェックする代わりに、
//0除算の例外をキャッチして、IllegalArgumentExceptionを投げなおす

public class Main {
	private static int divide(int a, int b) {
		try {
			return a / b;
		} catch (ArithmeticException e) {
		  throw new IllegalArgumentException("除数が0です", 0);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("テスト1: " + divide(12, 4));
		System.out.println("テスト2: " + divide(12, 0));
		System.out.println("テスト3: " + divide(12, 2));
	}
}