package com.springframework.msscbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

/**
 * Created by Jens Andrae on 2020-10-15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {

    public UUID id;

    @NotBlank
    @Size(min = 3, max = 100)
    public String customerName;
}
