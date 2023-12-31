package com.lec.ex1_InputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// 파일 copy
public class Ex4_fileCopyStep1 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis(); // 시작할 때의 밀리세컨. 이후 파일 카피하고 난 후의 시간을 계싼할 것.
		InputStream is = null; 
		OutputStream os = null;
		try {
			is = new FileInputStream("D:/WebPro/source/01_Java/ch16_io/txtFile/bts_7.mp4");
			os = new FileOutputStream("D:/WebPro/source/01_Java/ch16_io/txtFile/bts_copy.mp4");
			int cnt = 0;
			while (true) {
				int i = is.read(); // 1바이트 읽음
				if (i == (-1)) break; // 읽은 것이 모두 종료되면 멈춤.
				os.write(i); // 읽은 i값을 그대로 쏨. 마지막까지. (총 7메가이므로 약 740만번정도 읽고 쓰고를 반복함.)
				cnt++; // 몇번 카운트했는지를 계싼함.
				if (cnt % 100000 == 0){
					System.out.println(cnt +"/7,460,545 " + (int)(cnt/7460545.0 * 100) + "퍼센트 진행됨");
				}
			}
			System.out.println(cnt + "번 while문을 실행하여 복사 성공");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());			
		} finally {
			try {
				if (os != null)	os.close(); // 일반적으론 나중에 설정한 것을 먼저 닫아줘야함.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (is != null) is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		long end = System.currentTimeMillis();
		System.out.println("걸린 시간 = " + (end-start) / (1000.0) + "초 걸림");
	}
}
