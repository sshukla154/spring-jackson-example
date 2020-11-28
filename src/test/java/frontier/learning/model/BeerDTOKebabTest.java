package frontier.learning.model;

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

@ActiveProfiles("kebab")
@JsonTest
public class BeerDTOKebabTest extends BaseTest {

	@Test
	void testSerializeDTO() throws JsonProcessingException {
		BeerDTO beerDTO = getBeerDTO();
		String jsonString = objectMapper.writeValueAsString(beerDTO);
		System.out.println("Serializing : " + jsonString);
		//{"id":"327388aa-8bc5-4a44-80e1-50f3685d42f2","beer_name":"Budwiser","beer_style":"Ale","upc":123321123,"price":12.99,"created_date":"2020-11-28T06:36:04.7695482+05:30","last_updated_date":"2020-11-28T06:36:04.7705456+05:30"}
	}

	@Test
	void testDeserializeDTO() throws JsonProcessingException {
		String jsonString = "{\"id\":\"b8038dae-22ed-4040-aa78-9dc7898ff9cd\",\"beer-name\":\"Budwiser\",\"beer-style\":\"Ale\",\"upc\":123321123,\"price\":12.99,\"created-date\":\"2020-11-28T06:45:11.0749547+05:30\",\"last-updated-date\":\"2020-11-28T06:45:11.0749547+05:30\"}";
		BeerDTO beerDTO = objectMapper.readValue(jsonString, BeerDTO.class);
		System.out.println("Deserializing - 1 : " + beerDTO.toString());
		
		jsonString = "{\"beer-name\":\"Budwiser\",\"beer-style\":\"Ale\",\"upc\":123321123,\"price\":12.99,\"created-date\":\"2020-11-28T06:55:44.4675254+05:30\",\"last-updated-date\":\"2020-11-28T06:55:44.4675254+05:30\",\"beerId\":\"519350c6-a42e-46b4-8904-2d543c3bf0c3\"}";
		beerDTO = objectMapper.readValue(jsonString, BeerDTO.class);
		System.out.println("Deserializing - 2 : " + beerDTO.toString());
	}

}
