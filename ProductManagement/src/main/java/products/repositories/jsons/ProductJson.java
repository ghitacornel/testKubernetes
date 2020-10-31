package products.repositories.jsons;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ProductJson {

    @NotBlank
    private String id;

    @NotBlank
    private String code;

    @NotBlank
    private String name;

    @NotNull
    private BigDecimal quantity;

    @NotNull
    private BigDecimal price;

    @NotBlank
    private String personId;

}
