package com.coderocket.sportscomp.in.dto.request.player;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record UpdatePlayerInRequest (
    @NotBlank(message = "first name cannot be a blank value")
    @Pattern(regexp = "[a-zA-Z]+")
    @Length(min = 3, max = 20)
    String firstName,

    @NotBlank(message = "last name cannot be a blank value")
    @Pattern(regexp = "[a-zA-Z]+")
    @Length(min = 3, max = 20)
    String lastName,

    @Min(value = 1000, message = "min rating is 1000")
    Integer rating
) {
}
