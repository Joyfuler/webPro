package com.lec.ex4_human;
//������, ������ �Լ�(public), �޼ҵ�, ���Ͱ��� ������� �� ��.
// Man kim = new Man ("ȫ�浿", 22, 180, 68.0);  ������ �Լ��� �����ε�
// Man kim = (); �Ű���������
// Man kim new Man ("ȫ�浿");
// Man kim new Man (180);
// Man kim new Man (68.0); // �Ҽ����� double�� ����� ��.

public class Man {
	private String name;
	private int age;
	private int height;
	private double weight; // 68 �־ �˾Ƽ� 68.0�� ��
	// �����ڰ� ������ �Լ��� �ϳ� �̻� ����� �����Ϸ��� ����Ʈ ������ �Լ� ������ ����.
	// �׷��� ������ �Լ��� �ƹ��͵� ������ ������ �����Ϸ��� ����Ʈ ������ �Լ��� ����.
	
	public Man() {
		System.out.println("�Ű������� ���� Man �����ڰ� ��µǴ���?");
	}

	public Man(String name, int age, int height, double weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		System.out.println("������ 4���� �ʱ�ȭ�ϴ� Man ������ �Լ�");
	}
	
	public Man(String name) {
		this.name = name;
		System.out.println("�̸��� �ʱ�ȭ�ϴ� Man ������ �Լ�");
	
	}
	public Man(int height) {
		this.height= height;
		System.out.println("Ű�� �ʱ�ȭ�ϴ� Man ������ �Լ�");
	}
	
	public Man(double weight) {
		this.weight = weight;
		System.out.println("�����Ը� �ʱ�ȭ�ϴ� Man ������ �Լ�");
	}
	
	
	//BMI ������ ����ϴ� �޼ҵ�
	public double calculateBMI() {
		double result = weight / (((double)height/100) * ((double)height/100)); 
		return result; // BMI�� ����� �� �� result�� ��ȯ����	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
	

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
	
	
	
	//Setter getter �ڵ�����
	
	
	
	}
	
	
	
//	public Man(String name, int age, int height, double weight) {
//		this.name = name;
//		this.age = age;
//		this.height = height;
//		this.weight = weight; // �� ��ü�� ���� weight�� ���⿡ �ִ� �Ű������� �ʱ�ȭ
		
	
	
	
	
	

	

	
	// �Ȱ��� kim�̶�� �Լ� �̸��� �Ű����� ���ڿ� ���� �ڵ����� ���õǾ� ����.
