package com.example.modelmapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Field {
    private String field;
    private String value;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Field> fields;
}
