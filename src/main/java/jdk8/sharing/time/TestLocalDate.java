package jdk8.sharing.time;

import java.time.LocalDate;

public class TestLocalDate {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2018, 9, 7);
		LocalDate today = LocalDate.now();
		System.out.println(today.isBefore(date));
	}

}
