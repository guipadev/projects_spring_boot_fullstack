package co.yom.crud.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AuthorParam {

	private String q;
	@JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate birthdate;
}
