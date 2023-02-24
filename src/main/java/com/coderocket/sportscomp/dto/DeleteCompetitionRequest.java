package com.coderocket.sportscomp.dto;


import com.coderocket.sportscomp.domain.Competition;
import lombok.Data;

@Data
public class DeleteCompetitionRequest implements Request {
    Competition competition;
}
