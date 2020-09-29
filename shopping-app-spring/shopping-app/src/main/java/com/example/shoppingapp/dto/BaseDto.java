package com.example.shoppingapp.dto;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class BaseDto {

    private UUID uuid;
    private Instant createdDate;
    private Instant updatedDate;
}
