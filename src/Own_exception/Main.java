package Own_exception;

//・バリデーションを行うサンプルの枠組み
//ユーザー名とパスワードのバリデーション(値の妥当性検証)を例に独自のExceptionを実装する方法
//実行するバリデーションの概要は以下の通り
//ユーザー名は40文字以下
//ユーザー名にはスペース以外の任意の文字が使用可能
//パスワードは6文字以上40文字以下
//パスワードに使用できる文字はスペース以外のASCIIの範囲の文字のみ

//public class Main {
//	private static boolean validate(String username, String password) {
//		//ToDo ここにバリデーションの処理を実装
//		return true;
//	}
//	
//	public static void main(String[] args) {
//		System.out.println("test1: " + validate("CODEPREP", "password"));  //OK
//		System.out.println("test2: " + validate("CODEPREP1234567890123456789012345678901234567890", "password"));  //ユーザー名が長すぎる
//		System.out.println("test3: " + validate("CODE PREP", "password"));  //ユーザー名にスペース
//		System.out.println("test4: " + validate("CODEPREP", "pass"));  //パスワードが短すぎる
//		System.out.println("test5: " + validate("CODEPREP", "pssword1234567890123456789012345678901234567890"));  //パスワードが長すぎる
//		System.out.println("test6: " + validate("CODEPREP", "日本語パスワード"));  //パスワードにASCII以外の文字
//	}
//}

//・ユーザー名のバリデーションの実装
//validate()メソッドの中でユーザー名のバリデーションを実装
//ここではExceptionが発生した場合はエラーメッセージを画面に表示してfalseを返すこと

//public class Main {
//	private static boolean validate(String username, String password) {
//		try {
//			if(username.length() > 40) {
//				throw new UsernameException("ユーザー名が長すぎます");
//			}
//			if(username.indexOf(" ") != -1) {
//				throw new UsernameException("ユーザー名にスペースが含まれています");
//			}
//			return true;
//		} catch (ValidationException e) {
//			System.out.println(e.getMessage());
//			return false;
//		}
//	}
//	
//	public static void main(String[] args) {
//		System.out.println("test1: " + validate("CODEPREP", "password"));  //OK
//		System.out.println("test2: " + validate("CODEPREP1234567890123456789012345678901234567890", "password"));  //ユーザー名が長すぎる
//		System.out.println("test3: " + validate("CODE PREP", "password"));  //ユーザー名にスペース
//		System.out.println("test4: " + validate("CODEPREP", "pass"));  //パスワードが短すぎる
//		System.out.println("test5: " + validate("CODEPREP", "password1234567890123456789012345678901234567890"));  //パスワードが長すぎる
//		System.out.println("test6: " + validate("CODEPREP", "日本語パスワード"));  //パスワードにASCII以外の文字
//	}
//}


//・パスワードのバリデーションの実装
public class Main {
	private static boolean validate(String username, String password) {
		try {
			if(username.length() > 40) {
				throw new UsernameException("ユーザー名が長すぎます");
			}
			if(username.indexOf(" ") != -1) {
				throw new UsernameException("ユーザー名にスペースが含まれています");
			}
			if(password.length() < 6) {
				throw new PasswordException("パスワードが短すぎます");
			}
			if(password.length() > 40) {
				throw new PasswordException("パスワードが長すぎます");
			}
			if(!password.matches("^[\\x21-\\x7F]*$")) {
				throw new PasswordException("パスワードに使用できない文字が含まれています");
			}
			return true;
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("test1: " + validate("CODEPREP", "password"));  //OK
		System.out.println("test2: " + validate("CODEPREP1234567890123456789012345678901234567890", "password"));  //ユーザー名が長すぎる
		System.out.println("test3: " + validate("CODE PREP", "password"));  //ユーザー名にスペース
		System.out.println("test4: " + validate("CODEPREP", "pass"));  //パスワードが短すぎる
		System.out.println("test5: " + validate("CODEPREP", "password1234567890123456789012345678901234567890"));  //パスワードが長すぎる
		System.out.println("test6: " + validate("CODEPREP", "日本語パスワード"));  //パスワードにASCII以外の文字
	}
}