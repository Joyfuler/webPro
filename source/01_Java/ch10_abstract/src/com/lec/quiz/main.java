package com.lec.quiz;

public class main {
	public static void main(String[] args) {
<<<<<<< HEAD
		Employee[] sawon = { new SalaryEmployee("홍길동", 48000000), new SalaryEmployee("강동원", 70000000),
				new SalaryEmployee("김고은", 26000000), new HourlyEmployee("홍길구", 100, 9700),
				new HourlyEmployee("김길자", 160, 10000) };
		for (Employee temp : sawon) {
			System.out.println("~ ~ ~ 월급명세서 ~ ~ ~");
			System.out.println("성 함 : " + temp.getName());
			System.out.println("월 급 : " + temp.computePay());
			// System.out.println("상 여 : "+ temp.computeIncentive());
			int tempIncen = temp.computeIncentive();
			if (tempIncen != 0) {
				System.out.println("상 여 : " + tempIncen);
=======
		Employee[] sawon = {
				new SalaryEmployee("홍길동", 48000000),
				new SalaryEmployee("강동원", 70000000),
				new SalaryEmployee("김고은", 26000000),
				new HourlyEmployee("홍길구", 100,9700),
				new HourlyEmployee("김길자", 160,10000)};
		for(Employee temp : sawon){
			System.out.println("~ ~ ~ 월급명세서 ~ ~ ~");
			System.out.println("성 함 : "+temp.getName());
			System.out.println("월 급 : "+temp.computePay());
			//System.out.println("상 여 : "+ temp.computeIncentive());
			int tempIncen = temp.computeIncentive();
			if(tempIncen!=0){
				System.out.println("상 여 : "+ tempIncen);
>>>>>>> febfb5a (9th)
			}
		}
	}

}
