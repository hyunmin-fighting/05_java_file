package step5_02.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//# 파일 저장하기 : 연습문제2
//210408 16:52 ~ 17:02

public class FileEx04_정답 {

	public static void main(String[] args) {
		
		// momk/1111/20000
		// megait/2222/30000
		// github/3333/40000
		
		String[] names = {"momk", "megait", "github"};
		String[] pws   = {"1111",   "2222",   "3333"};
		int[]    moneys= { 20000,    30000,    40000};
		
		String fileName = "fileTest02.txt";
		File file = new File(fileName);
		
		String data = "";
		FileWriter fw = null;
		
		
		try {
			fw = new FileWriter(file);
			
				for(int i=0; i<names.length; i++) {
					data += names[i] + "/" + pws[i] + "/" + Integer.toString(moneys[i]) + "\n";
				}
				
			fw.write(data);
				
		} catch (IOException e) {
			e.printStackTrace();
		} finally {try {fw.close();} catch (IOException e) {e.printStackTrace();}}
	}
}
