package java_try;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

//import java.io.File;
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;

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
//・try ～ catchを使用することでtryのブロックで発生したエラーを捕捉して、
//エラー処理を行うことができる
//ここではArithmeticExceptionを捕捉して、それが発生した場合は0を返している


//・printStackTrace
//例外捕捉時に発生したExceptionのprintStackTrace()メソッドを実行

//public class Main {
//	private static int divide(int a, int b) {
//		try {
//			return a / b;
//		} catch (ArithmeticException e) {
//		  e.printStackTrace();
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
//printStackTrace()は実行することで発生したExceptionのスタックトレースを出力することが出来る


//・複数のExceptionのキャッチ
//文字コードを指定してファイルを読み込むメソッドreadFile()がある。このメソッドの中で、
//ファイルが見つからない場合に発生するNoSuchFileException
//文字コードが不正な場合に発生するUnsupportedEncodingException
//それ以外のIOException
//を別々に捕捉し、異なるエラー処理を行う

//import java.nio.file.Files;
//import java.nio.file.NoSuchFileException;
//
//public class Main {
//	private static String readFile(File file, String encoding) {
//		try {
//			return new String(Files.readAllBytes(file.toPath()), encoding);
//		} catch (NoSuchFileException e) {
//			System.out.println("ファイルが見つかりませんでした： " + file);
//			return "";
//		} catch (UnsupportedEncodingException e) {
//			System.out.println("エンコーディングが不正です： " + encoding);
//			return "";
//		} catch (IOException e) {
//			System.out.println("ファイルの読み込みに失敗しました： " + file);
//			return "";
//		}
//	}
//	
//	public static void main(String[] args) {
//		System.out.println("テスト1: " + readFile(new File("file1.txt"), "utf-8"));
//		System.out.println("テスト2: " + readFile(new File("file2.txt"), "utf-8"));
//		System.out.println("テスト3: " + readFile(new File("file1.txt"), "unknown"));
//	}
//}
//catch節は複数定義して異なるエラー処理を記述することが出来る
//ただし、catchするExceptionクラスに継承関係がある場合はサブクラスの方を先に記述しなければならない
//今回の場合、NoSuchFileException, UnsupportedEncodingExceptionの
//いずれもIOExceptionを継承しているので、
//OExceptionのcatch節はこれらのExceptionのcatch節よりも後に定義する必要がある


//複数のExceptionのキャッチ(2)
//実行するエラー処理が同じ場合は、複数のExceptionを|で区切って記述することで、
//まとめてcatch節に含めることが出来る
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;

public class Main {
	private static String readFile(File file, String encoding) {
		try {
			return new String(Files.readAllBytes(file.toPath()), encoding);
		} catch (NoSuchFileException | UnsupportedEncodingException e) {
			System.out.println("ファイルが見つからないかエンコーディングが不正です。 ");
			return "";
		} catch (IOException e) {
			System.out.println("ファイルの読み込みに失敗しました： " + file);
			return "";
		}
	}
	
	public static void main(String[] args) {
		System.out.println("テスト1: " + readFile(new File("file1.txt"), "utf-8"));
		System.out.println("テスト2: " + readFile(new File("file2.txt"), "utf-8"));
		System.out.println("テスト3: " + readFile(new File("file1.txt"), "unknown"));
	}
}