package com.coderocket.sportscomp.in.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record AddPlayerToCompetitionRequest(
        @NotNull
        Integer id,

        @NotBlank
        @Pattern(regexp = "[a-zA-Z]+")
        @Length(min = 3, max = 20)
        String firstName,

        @NotBlank
        @Pattern(regexp = "[a-zA-Z]+")
        @Length(min = 3, max = 20)
        String lastName,

        @Min(1000)
        Integer rating
) {
}
