package frontier.learning.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

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
	
	@Test
	void testDeserializeDTO() throws JsonProcessingException {
		String jsonString = "{\"beerName\":\"Budwiser\",\"beerStyle\":\"Ale\",\"upc\":123321123,\"price\":\"12.99\",\"createdDate\":\"2020-11-28T07:49:30+0530\",\"lastUpdatedDate\":\"2020-11-28T07:49:30.9863328+05:30\",\"withoutFormatLocalDate\":\"2020-11-28\",\"withFormatLocalDate\":\"20201128\",\"beerId\":\"2160f5ea-24dc-4776-a540-4b101b02841f\"}";
		BeerDTO beerDTO = objectMapper.readValue(jsonString, BeerDTO.class);
		System.out.println("Deserializing : " + beerDTO.toString());
	}

}

