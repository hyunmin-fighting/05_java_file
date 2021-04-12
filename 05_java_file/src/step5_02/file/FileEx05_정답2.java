package step5_02.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//# 파일 로드하기 : 연습문제
//20210409 09:06 ~ 


public class FileEx05_정답2 {

	public static void main(String[] args) {
		
		
		// 4번 연습문제에서 작성된 테스트파일을 읽어들여와 아래 배열에 저장하시오.
		
		String[] names = new String[3];			// momk , megait , github
		String[] pws   = new String[3];			// 1111 , 2222   , 3333
		int[] moneys   = new int[3];			// 20000, 30000 , 40000
		
		String fileName = "fileTest02.txt";

		File file = new File(fileName);
		
		
		
		if(file.exists()) {
			
			FileReader fr = null;
			BufferedReader br =null;
			
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				int i = 0;
				while(true) {

					String tempFile = br.readLine();

					if(tempFile == null) {
						break;
					}
					
					String[] temp = tempFile.split("/");
					names[i] = temp[0];
					pws[i] = temp[1];
					moneys[i] = Integer.parseInt(temp[2]);
					
					i++;
				}
				br.close();
				fr.close();
				
				for(int j=0; j<names.length; j++) {
					System.out.println(names[j] + ":" + pws[j] + ":" + moneys[j]);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
