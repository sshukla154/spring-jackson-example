package frontier.learning.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseTest {

	@Autowired
	public ObjectMapper objectMapper;

	BeerDTO getBeerDTO() {
		return BeerDTO.builder()//
				.id(UUID.randomUUID()).beerName("Budwiser")//
				.beerStyle("Ale")//
				.createdDate(OffsetDateTime.now())//
				.lastUpdatedDate(OffsetDateTime.now())//
				.price(new BigDecimal("12.99"))//
				.upc(123321123L)//
				.withFormatLocalDate(LocalDate.now())//
				.withoutFormatLocalDate(LocalDate.now())//
				.build();
	}
}
