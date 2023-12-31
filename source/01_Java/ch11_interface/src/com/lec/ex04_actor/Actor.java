package com.lec.ex04_actor;

public class Actor implements IChef, IFireFighter, IPoliceMan {

	private String name;
	
	
	public Actor(String name) {
		this.name = name;
	}

	@Override
	public void canCatchCriminal() {
		System.out.println(name + " 은(는) 경찰관입니다. 범죄자를 잡습니다.");

	}

	@Override
	public void canSearch() {
		System.out.println(name + " 은(는) 경찰관입니다. 분실물을 찾습니다.");

	}

	@Override
	public void outFire() {
		System.out.println(name + " 은(는) 소방관입니다. 불을 끕니다.");

	}

	@Override
	public void saveMan() {
		System.out.println(name + " 은(는) 소방관입니다. 사람을 구합니다.");

	}

	@Override
	public void makePizza() {
		System.out.println(name + " 은(는) 요리사입니다. 피자를 굽습니다.");

	}

	@Override
	public void makeSpaghetti() {
		System.out.println(name + " 은(는) 요리사입니다. 스파게티를 만듭니다.");

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
