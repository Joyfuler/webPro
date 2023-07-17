package com.lec.ex1_InputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// ����?! 1) ��Ʈ�� ����(���Ͽ���..) 2) ������ �б� (read �޼ҵ� ���) 3) ������ �ݴ´�. (�� �о��ٸ� ���뻩���۾�..close �޼ҵ� ���)
public class Ex01_FileInputStream {
	public static void main(String[] args) {
		InputStream is = null;
		try { // ������ �ҷ��µ� ���� ���� �̸��� �߸� �ļ� ������ ���ٸ�? --> ���ܰ� �⺻������ �߻��ϹǷ� try-catch�� �� �־������.
			is = new FileInputStream("txtFile/inTest");
			// 2. �����͸� �д´� (���� ������ �ݺ������� �д´�)
			while (true) {
				int i = is.read(); // 1����Ʈ ����. read�� int�� �ޱ� ����.
				if (i == -1) { // �д� ��ġ�� ������ -1�� ��.
					break;
				}
				System.out.print((char)i);
			}
			System.out.println("\n ===== �� =====");
		} catch (FileNotFoundException e) {
			System.out.println("���� �޽��� (������ �� ã��)" + e.getMessage());
		} //
		catch (IOException e) {
			// ������ ����������, ���� �� �ִ� ������ ���ų�, ������ ���� �� ���� ������ ���.
			System.out.println("���� �޽��� (���� ������ ���ų� ��������." + e.getMessage());
			// �߰��� catch�� �ɸ� �� �����Ƿ�, finally�� ������ �ݴ� ������ �ִ´�.
		}
		finally {
			try {
				if (is != null) { // ���� ���� ��ΰ� �߸��Ǿ� is�� null�� �� ���� close�� �� �Ǳ� ����.
					is.close();
				
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}