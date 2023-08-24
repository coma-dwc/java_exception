package java_try;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Main {
	private static String readFile(File file, String encoding) {
		FileInputStream is = null;
		try {
			is = new FileInputStream(file);
			byte[] buf = new byte[(int)file.length()];
			is.read(buf);
			return new String(buf, encoding);
		} catch (FileNotFoundException e) {
			System.out.println("ファイルが見つかりませんでした：" + file);
			return "";
		} catch (UnsupportedEncodingException e) {
			System.out.println("エンコーディングが不正です：" + encoding);
			return "";
		} catch (IOException e) {
			System.out.println("ファイルの読み込みに失敗しました：" + file);
			return "";
		} finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e2) {
					//Ignore errors
				}
				System.out.println("FileInputStreamをクローズしました");
			} else {
				System.out.println("FileInputStreamは生成されていません");
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("テスト1: " + readFile(new File("file1.txt"), "utf-8"));
		System.out.println("テスト2: " + readFile(new File("file2.txt"), "utf-8"));
		System.out.println("テスト3: " + readFile(new File("file1.txt"), "unknown"));
	}
}

