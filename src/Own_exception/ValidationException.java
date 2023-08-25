package Own_exception;


//・ValidationExceptionの作成
//バリデーションエラーを示す例外、ValidationExceptionをExceptionを継承して定義する

//public class ValidationException extends Exception {
//	public ValidationException(String message) {
//		super(message);
//	}
//	
//	public ValidationException(String message, Throwable couse) {
//		super(message, couse);
//	}
//}

//ここではExceptionを継承して作成しているのでValidationExceptionは検知例外となる
//非検知例外としたい場合はRuntimeExceptionを継承して作成
//Exceptionを作成する場合はコンストラクタでは、エラーメッセージを引数とするものの他に
//原因となるExceptionを示す、causeを引数とするものを作っておくと汎用性が上がる


//・ValidationExceptionのサブクラスの作成
//ValidationExceptionを継承したUsernameExceptionとPasswordExceptionを作成

public class ValidationException extends Exception {
	public ValidationException(String message) {
		super(message);
	}
	
	public ValidationException(String message, Throwable cause) {
		super(message, cause);
	}
}

class UsernameException extends ValidationException {
	
	public UsernameException(String message) {
		super(message);
	}
	
	public UsernameException(String message, Throwable cause) {
		super(message, cause);
	}
}

class PasswordException extends ValidationException {
	
	public PasswordException(String message) {
		super(message);
	}
	
	public PasswordException(String message, Throwable cause) {
		super(message, cause);
	}
}

