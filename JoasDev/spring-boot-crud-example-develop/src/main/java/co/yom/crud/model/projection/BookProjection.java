package co.yom.crud.model.projection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public interface BookProjection {

    Integer getBookId();
    String getTitle();
    
    @JsonFormat(pattern="dd-MM-yyyy")
    LocalDate getPublicationDate();
    
    Boolean getOnlineAvailability();
    
    @JsonIgnore
    String getConcatAuthors();
    
    
    default List<String> getAuthors() {
        if(getConcatAuthors()==null || getConcatAuthors().isEmpty()) {
            return new ArrayList<>();
        }
        
        return Arrays.asList(getConcatAuthors().split(", "));
    }
    
}
