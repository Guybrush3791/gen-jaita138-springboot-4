package org.generation.jaita138.demo7;

import java.util.List;

import org.generation.jaita138.demo7.db.entity.Park;
import org.generation.jaita138.demo7.db.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo7Application implements CommandLineRunner {

	/*
	 * QUERY IDEAS:
	 * - trova tutti i parchi con area maggiore di 8000
	 * - trova tutti i parchi con nome che inizia con "C"
	 * - trova tutti i parchi con piu' di 3 shop e piu' di 3 toilet
	 * - trova tutti i parchi con area tra 5000 e 5500
	 * 
	 * ...
	 */

	@Autowired
	private ParkService parkService;

	public static void main(String[] args) {
		SpringApplication.run(Demo7Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Hello, World!");
		System.out.println("--------------------------------");

		testQueryMethods();

		System.out.println("--------------------------------");
		System.out.println("The end");
	}

	public void test1() {

		// CREATE NEW PARK
		Park park = new Park();
		park.setName("Central Park");
		park.setAddress("Central Park");
		park.setCity("New York");
		park.setCountry("US");

		park.setArea(843);
		park.setShop(0);
		park.setToilet(35);

		park.setSport(true);

		System.out.println("PRINT PARK BEFORE SAVE");
		System.out.println(park);
		System.out.println("--------------------------------");

		// STORE NEW PARK
		parkService.save(park);

		System.out.println("PRINT PARK AFTER SAVE");
		System.out.println(park);
		System.out.println("--------------------------------");

		// LIST ALL PARKS
		List<Park> parks = parkService.findAll();

		System.out.println("PRINT PARK LIST");
		System.out.println(parks);
		System.out.println("--------------------------------");

		// UPDATE FIRST PARK
		Park firstPark = parks.get(0);
		firstPark.setName("Parco Centrale");
		parkService.save(firstPark);

		// HARD DELETE
		// Park secondPark = parks.get(1);
		// parkService.delete(secondPark);

		// SOFT DELETE
		Park thirdPark = parks.get(2);
		parkService.softDelete(thirdPark);

		// PRINT ACTIVE PARK
		List<Park> activeParks = parkService.findActive();
		System.out.println("PRINT PARK LIST");
		System.out.println(activeParks);
		System.out.println("--------------------------------");
	}

	public void testQueryMethods() {

		List<Park> activeParks = parkService.findNotActiveParkBySQL();
		System.out.println(activeParks);
	}
}
