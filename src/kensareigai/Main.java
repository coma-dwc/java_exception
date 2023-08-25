package kensareigai;

import java.io.File;
import java.nio.file.Files;
import java.io.IOException;

//Files#readAllBytes()を使用したファイルの読み込みサンプルを改変して
//try～catch部分を取り除く

public class Main {
	private static String readFile(File file, String encoding) {
		return new String(Files.readAllBytes(file.toPath()), encoding);
	}
	
	public static void main(String[] args) {
		System.out.println("テスト1: " + readFile(new File("file1.txt"), "utf-8"));
		System.out.println("テスト2: " + readFile(new File("file2.txt"), "utf-8"));
		System.out.println("テスト3: " + readFile(new File("file1.txt"), "unknown"));
	}
}
//検査例外とは必ずtry～catchを用いて例外の処理を行わなければならない例外のこと
//クラス構造的には検査例外はExceptionクラスのサブクラスで、かつ
//RuntimeExceptionのサブクラスでないものが検査例外となる