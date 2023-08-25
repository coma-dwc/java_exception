package kensareigai;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

//Files#readAllBytes()を使用したファイルの読み込みサンプルを改変して
//try～catch部分を取り除く

//public class Main {
//	private static String readFile(File file, String encoding) {
//		return new String(Files.readAllBytes(file.toPath()), encoding);
//	}
//	
//	public static void main(String[] args) {
//		System.out.println("テスト1: " + readFile(new File("file1.txt"), "utf-8"));
//		System.out.println("テスト2: " + readFile(new File("file2.txt"), "utf-8"));
//		System.out.println("テスト3: " + readFile(new File("file1.txt"), "unknown"));
//	}
//}
//検査例外とは必ずtry～catchを用いて例外の処理を行わなければならない例外のこと
//クラス構造的には検査例外はExceptionクラスのサブクラスで、かつ
//RuntimeExceptionのサブクラスでないものが検査例外となる


//・throwsを宣言する
//検査例外を処理する方法の1つはtry～catchで括ること
//もう一つの方法はメソッドにthrows節をつけて、「このメソッドはこの検査例外をthrowする可能性がある」
//ということを宣言する方法

//readFile()メソッドにthrowsIOExceptionを宣言してIOExceptionが発生する可能性があることを示す

public class Main {
	private static String readFile(File file, String encoding) throws IOException {
		return new String(Files.readAllBytes(file.toPath()), encoding);
	}
	
	public static void main(String[] args) {
		System.out.println("テスト1: " + readFile(new File("file1.txt"), "utf-8"));
		System.out.println("テスト2: " + readFile(new File("file2.txt"), "utf-8"));
		System.out.println("テスト3: " + readFile(new File("file1.txt"), "unknown"));
	}
}