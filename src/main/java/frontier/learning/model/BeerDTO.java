package frontier.learning.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTO {

	/*
	 * @JsonProperty - Will over-ride the Naming property defined. Will give the
	 * property name as "beerId" instead of "id".
	 */
	@Null
	@JsonProperty("beerId")
	private UUID id;

	@NotBlank
	private String beerName;

	@NotBlank
	private String beerStyle;

	@Positive
	private Long upc;

	/*
	 * @JsonFormat - Will over-ride the fomat of the property.
	 * 
	 * Eg: in price it is BigDecimal, which is formatted to String
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private BigDecimal price;

	/*
	 * @JsonFormat - Will over-ride the fomat of the property.
	 * 
	 * Eg: in price it is BigDecimal, which is formatted to String
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	private OffsetDateTime createdDate;

	private OffsetDateTime lastUpdatedDate;

}
