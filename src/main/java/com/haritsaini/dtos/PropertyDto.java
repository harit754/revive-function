package com.haritsaini.dtos;

import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Serdeable
public class PropertyDto {

    private Integer id;
    private List<String> buyers;
    private List<String> sellers;
    private String name;
    private String refId;


}
