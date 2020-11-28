package frontier.learning.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

	@Autowired
	ObjectMapper objectMapper;

	@Test
	void testSerializeDTO() throws JsonProcessingException {
		BeerDTO beerDTO = getBeerDTO();
		String jsonString = objectMapper.writeValueAsString(beerDTO);
		/* Spring is default LOWER_CAMEL_CASE */
		System.out.println("Serializing : " + jsonString);
		//{"id":"327388aa-8bc5-4a44-80e1-50f3685d42f2","beer_name":"Budwiser","beer_style":"Ale","upc":123321123,"price":12.99,"created_date":"2020-11-28T06:36:04.7695482+05:30","last_updated_date":"2020-11-28T06:36:04.7705456+05:30"}
	}

	@Test
	void testDeserializeDTO() throws JsonProcessingException {
		String jsonString = "{\"id\":\"327388aa-8bc5-4a44-80e1-50f3685d42f2\",\"beer_name\":\"Budwiser\",\"beer_style\":\"Ale\",\"upc\":123321123,\"price\":12.99,\"created_date\":\"2020-11-28T06:36:04.7695482+05:30\",\"last_updated_date\":\"2020-11-28T06:36:04.7705456+05:30\"}";
		BeerDTO beerDTO = objectMapper.readValue(jsonString, BeerDTO.class);
		System.out.println("Deserializing : " + beerDTO.toString());
	}

}
