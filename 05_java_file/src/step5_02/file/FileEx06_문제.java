package step5_02.file;
// 210409 15:20 ~ 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//# 파일 컨트롤러[1단계] : 벡터

public class FileEx06_문제 {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		

		
		int[] vector = null;
		int elementCnt = 0;
		
		String fileName = "vector.txt";
		
		while (true) {
			
			for(int i=0; i<elementCnt; i++) {
				System.out.print(vector[i] + " ");
			}
			System.out.println();
			
			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가하기");
			System.out.println("[2]삭제하기");
			System.out.println("[3]저장하기");
			System.out.println("[4]로드하기");
			System.out.println("[5]종료하기");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if		(sel == 1) {
				if(elementCnt == 0) {
					vector = new int[elementCnt + 1];
				}
				else if(elementCnt > 0) {
					int[] temp = vector;
					vector = new int[elementCnt + 1];
					for(int i=0; i<temp.length; i++) {
						vector[i] = temp[i];
					}
					temp = null;
				}
				System.out.print("추가할 숫자를 입력 : ");
				int addNum = scan.nextInt();
				vector[elementCnt] = addNum;
				elementCnt++;
			}
			else if (sel == 2) {
				
				System.out.print("삭제할 숫자의 인덱스 입력 : ");
				int subStraction = scan.nextInt();
				
				if(subStraction < 0 || subStraction > vector.length - 1) {
					System.out.println("해당 인덱스는 존재하지 않습니다.");
					continue;
				}
				
				if(elementCnt == 1) {
					vector = null;
				}
				else if(elementCnt > 1) {
					int[] temp = vector;
					vector = new int[elementCnt - 1];
					
					int j=0;
					for(int i=0; i<temp.length; i++) {
						if(i != subStraction) {
							vector[j] = temp[i];
							j++;
						}
					}
					temp = null;
				}
				elementCnt--;
			}

			else if (sel == 3) {
				//저장하기
				String data = "";

				if(elementCnt > 0) {
					for(int i=0; i<elementCnt; i++) {
						data += vector[i] + "\n";
					}
				}
				data = data.substring(0, data.length()-1);

				FileWriter fw = null;

				try {
					fw = new FileWriter(fileName);
					fw.write(data);
					
				} catch (IOException e) {
					e.printStackTrace();
				} finally {try {fw.close();} catch (IOException e) {e.printStackTrace();}}
			}
			
			else if (sel == 4) {
				//읽어오기
				String data ="";
				File file = new File(fileName);
				
				
				while(file.exists()) {
					
					FileReader fr = null;
					BufferedReader br = null;

					try {
						
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						
						while(true) {
							String readData = br.readLine();
							if(readData == null) {
								break;	
							}
							data += readData;
							data += "\n";
						}
						data = data.substring(0, data.length()-1);
						String temp[] = data.split("\n");
						elementCnt = temp.length;
						
						vector = new int[elementCnt];
						
						for(int i=0; i<elementCnt; i++) {
							vector[i] = Integer.parseInt(temp[i]);
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {br.close();} catch (IOException e) {e.printStackTrace();}
						try {fr.close();} catch (IOException e) {e.printStackTrace();}
					}
				}
			}
			else if (sel == 5) {
				System.out.println("프로그램 종료");
				break;
			}
			
		}
		
	}
}
