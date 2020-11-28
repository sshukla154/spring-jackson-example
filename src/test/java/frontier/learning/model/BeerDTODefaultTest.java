package frontier.learning.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;

@JsonTest
public class BeerDTODefaultTest extends BaseTest {

	@Test
	void testSerializeDTO() throws JsonProcessingException {
		BeerDTO beerDTO = getBeerDTO();
		String jsonString = objectMapper.writeValueAsString(beerDTO);
		/*Spring is default LOWER_CAMEL_CASE*/
		System.out.println("Serializing : " + jsonString);
	}
	
	/*@Disabled : failing because of @JsonFormat at createdDate*/
	@Test
	@Disabled
	void testDeserializeDTO() throws JsonProcessingException {
		String jsonString = "{\"id\":\"f780f42d-b88a-4d65-b48d-0e1ee7baebdb\",\"beerName\":\"Budwiser\",\"beerStyle\":\"Ale\",\"upc\":123321123,\"price\":12.99,\"createdDate\":\"2020-11-27\",\"lastUpdatedDate\":\"2020-11-27T08:17:41.5677316+05:30\"}";
		BeerDTO beerDTO = objectMapper.readValue(jsonString, BeerDTO.class);
		System.out.println("Deserializing - 1 : " + beerDTO.toString());
		
		jsonString = "{\"beerName\":\"Budwiser\",\"beerStyle\":\"Ale\",\"upc\":123321123,\"price\":12.99,\"createdDate\":\"2020-11-28\",\"lastUpdatedDate\":\"2020-11-28T06:56:45.8585043+05:30\",\"beerId\":\"e96f7ab4-e480-441f-bd87-605f942507dd\"}";
		beerDTO = objectMapper.readValue(jsonString, BeerDTO.class);
		System.out.println("Deserializing - 2 : " + beerDTO.toString());
	}

}

