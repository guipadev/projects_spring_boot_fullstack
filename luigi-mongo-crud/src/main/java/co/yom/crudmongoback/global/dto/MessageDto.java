package co.yom.crudmongoback.global.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MessageDto {

    @NotBlank(message = "product name is mandatory")
    private String name;
    @Min(value = 1, message = "product price is mandatory")
    private int price;
}
