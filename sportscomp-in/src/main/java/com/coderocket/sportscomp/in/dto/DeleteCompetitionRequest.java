package com.coderocket.sportscomp.in.dto;


import com.coderocket.sportscomp.domain.Competition;
import lombok.Data;

@Data
public class DeleteCompetitionRequest {
    Competition competition;
}
