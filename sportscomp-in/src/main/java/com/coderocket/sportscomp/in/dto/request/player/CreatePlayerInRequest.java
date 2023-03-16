package com.coderocket.sportscomp.in.dto.request.player;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record CreatePlayerInRequest (
        @NotBlank(message = "first name cannot be a blank value")
        @Pattern(regexp = "[a-zA-Z]+", message = "first name must contain only alphabets")
        @Length(min = 3, max = 20, message = "last name can be min 3 and max 20 length")
        String firstName,

        @NotBlank(message = "last name cannot be a blank value")
        @Pattern(regexp = "[a-zA-Z]+", message = "last name must contain only alphabets")
        @Length(min = 3, max = 20, message = "first name can be only min 3 and max 20 length")
        String lastName,

        @Min(value = 1000, message = "min rating is 1000")
        Integer rating
)
{

}
