package strategy3quiz;

import java.util.Arrays;

public class TestMain {
	public static void main(String[] args) {
		Student st1 = new Student("ere", "ȫ�浿", "�����ڹ�");
		Student st2 = new Student("dbd", "��浿", "�ڹٴܱ�");
		Lecturer l1 = new Lecturer("aaa", "���浿", "������");
		Lecturer l2 = new Lecturer("bdc", "ȫ�浿", "�����α׷���");
		Staff s1 = new Staff("sss", "������", "����");
		Person[] person = { st1, st2, l1, l2, s1 };
		for (Person p : person) {
			p.print();
			p.job();
			p.get();

		}

	}
}
