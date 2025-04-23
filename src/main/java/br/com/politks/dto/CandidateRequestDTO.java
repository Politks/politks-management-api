package br.com.politks.dto;

import br.com.politks.enums.ElectionResult;

public record CandidateRequestDTO(
    Long politicianId, Long electionId, int votes, int number, ElectionResult result) {}
