package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// ����ڿ��� �μ���ȣ�� �޾� �ߺ�üũ ��, �μ���, �ٹ����� �Է¹޾� dept ���̺��� �߰�.
public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);
		// �μ���ȣ�� �Է��ؼ� �켱 �ߺ�üũ�� �ϵ��� �ؾ���. �μ���ȣ�� sql������ �˻��ؼ� ������� ������ �ߺ�, ������ �ߺ�x
		// int result = 1,0 Ȥ�� count(*)�� �̾ƿ� ���� 0,1...

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement(); // ��������� select���� ������. �Ʒ������� insert���� �� �� ����ϰ� �Ǵ� ����.

			System.out.println("�Է��� �μ���ȣ�� (���� 2�ڸ� �̳�) ? : ");
			int deptno = scanner.nextInt();
			// �μ���ȣ �ߺ�üũ
			String selectSQL = "select count(*) cnt from dept where deptno = " + deptno; // �켱 deptno�� ���� ����� sql������ ���.
			rs = stmt.executeQuery(selectSQL); // count�� 0�̵� 1�̵� �ݵ�� ���� �������Ƿ�, next�� ���� ���� ã�ƿ´�.
			rs.next();
			int cnt = rs.getInt("cnt"); // ���� ����� cnt�ʵ��� ���� cnt�� �־��ִ� �۾�.
			if (cnt == 1) {
				System.out.println("�ߺ��� �μ���ȣ�� �ֽ��ϴ�.");
			} else {
				System.out.println("�Է��� �μ����� ? : ");
				String dname = scanner.next();
				System.out.println("�Է��� �μ���ġ�� ? : ");
				String loc = scanner.next();
				String sql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc);
				int result = stmt.executeUpdate(sql); // ����� 1(�� ���Ե�), 0(�� ���Ե�) �̹Ƿ� int�� �޾ƾ���. insert, update, delete ��
														// ���۽ÿ� �����.
				// executequery() select�� ����. executeupdate() insert update delete ����

				System.out.println(result > 0 ? "�Է¼���" : "�Է½���");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("�ߺ��� �μ���ȣ�̰ų� �μ���, ��ġ�� �ʹ� ��� �Է��� ��� : " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close(); // db�� �����ϴ� insert���� ��� �ݵ�� close�� �ؾ� ��. ���� ������ �ش� db�� ����Ϸ� �� �� ������ �߻���.
			} catch (SQLException e2) {
				// TODO: handle exception
				System.out.println(e2.getMessage());
			}
		}
	}
}