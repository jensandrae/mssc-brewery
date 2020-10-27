package com.springframework.msscbrewery.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Created by Jens Andrae on 2020-10-27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    public UUID id;
    public String customerName;
}
