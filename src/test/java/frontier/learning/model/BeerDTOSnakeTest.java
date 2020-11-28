package frontier.learning.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.core.JsonProcessingException;

/*
 * By-default spring calls the application.properties files but when @ActiveProfiles then spring 
 * calls for the profile mentioned.
 * 
 * EG: @ActiveProfiles("snake")-- this will call application-snake.properties
 *
 */

@ActiveProfiles("snake")
@JsonTest
public class BeerDTOSnakeTest extends BaseTest {

	@Test
	void testSerializeDTO() throws JsonProcessingException {
		BeerDTO beerDTO = getBeerDTO();
		String jsonString = objectMapper.writeValueAsString(beerDTO);
		System.out.println("Serializing : " + jsonString);
		// {"id":"327388aa-8bc5-4a44-80e1-50f3685d42f2","beer_name":"Budwiser","beer_style":"Ale","upc":123321123,"price":12.99,"created_date":"2020-11-28T06:36:04.7695482+05:30","last_updated_date":"2020-11-28T06:36:04.7705456+05:30"}
	}

	@Test
	void testDeserializeDTO() throws JsonProcessingException {
		String jsonString = "{\"beer_name\":\"Budwiser\",\"beer_style\":\"Ale\",\"upc\":123321123,\"price\":\"12.99\",\"created_date\":\"2020-11-28T07:53:18+0530\",\"last_updated_date\":\"2020-11-28T07:53:18.6526305+05:30\",\"without_format_local_date\":\"2020-11-28\",\"with_format_local_date\":\"20201128\",\"beerId\":\"c65d8bda-700d-446d-807f-f5dbc56e2218\"}";
		BeerDTO beerDTO = objectMapper.readValue(jsonString, BeerDTO.class);
		System.out.println("Deserializing - 1 : " + beerDTO.toString());
	}

}
