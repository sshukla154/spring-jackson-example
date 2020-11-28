package frontier.learning.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

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

	/* Will give the property name as "beerId" instead of "id" */
	@Null
	@JsonProperty("beerId")
	private UUID id;

	@NotBlank
	private String beerName;

	@NotBlank
	private String beerStyle;

	@Positive
	private Long upc;

	private BigDecimal price;
	private OffsetDateTime createdDate;
	private OffsetDateTime lastUpdatedDate;

}
