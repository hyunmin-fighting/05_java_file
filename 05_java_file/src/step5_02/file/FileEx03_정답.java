package step5_02.file;

import java.io.FileWriter;
import java.io.IOException;

//210408 16:41 ~ 16:51

//# 파일 저장하기 : 연습문제1


public class FileEx03_정답 {

	public static void main(String[] args) {
		
		// 김철수/20,이만수/30,이영희/40
		
		String[] names = {"김철수", "이만수", "이영희"};
		int[] ages     = {	   20,     30,     40};
		
		String fileName = "fileTest01.txt";
		
		String data = "";
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(fileName);
			
				for(int i=0; i<names.length; i++) {
					data += names[i] + "/" + Integer.toString(ages[i]) + ",";
				}
				data = data.substring(0,data.length()-1);
				
				fw.write(data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		


		
	}

}
