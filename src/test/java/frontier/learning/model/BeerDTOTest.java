package frontier.learning.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonTest
public class BeerDTOTest extends BaseTest {

	@Autowired
	ObjectMapper objectMapper; 
	
	@Test
	void testSerializeDTO() throws JsonProcessingException {
		BeerDTO beerDTO = getBeerDTO();
		String jsonString = objectMapper.writeValueAsString(beerDTO);
		/*Spring is default LOWER_CAMEL_CASE*/
		System.out.println("Serializing : " + jsonString);
	}
	
	@Test
	void testDeserializeDTO() throws JsonProcessingException {
		String jsonString = "{\"id\":\"f780f42d-b88a-4d65-b48d-0e1ee7baebdb\",\"beerName\":\"Budwiser\",\"beerStyle\":\"Ale\",\"upc\":123321123,\"price\":12.99,\"createdDate\":\"2020-11-27T08:17:41.5677316+05:30\",\"lastUpdatedDate\":\"2020-11-27T08:17:41.5677316+05:30\"}";
		BeerDTO beerDTO = objectMapper.readValue(jsonString, BeerDTO.class);
		System.out.println("Deserializing : " + beerDTO.toString());
	}

}
