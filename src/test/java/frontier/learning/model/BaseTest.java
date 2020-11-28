package frontier.learning.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseTest {

	BeerDTO getBeerDTO() {
		return BeerDTO.builder()//
				.id(UUID.randomUUID())
				.beerName("Budwiser")//
				.beerStyle("Ale")//
				.createdDate(OffsetDateTime.now())//
				.lastUpdatedDate(OffsetDateTime.now())//
				.price(new BigDecimal("12.99"))//
				.upc(123321123L)//
				.build();
	}
}
