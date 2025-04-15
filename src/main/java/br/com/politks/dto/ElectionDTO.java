package br.com.politks.dto;

import java.util.List;

import br.com.politks.enums.Municipality;
import br.com.politks.enums.Position;
import br.com.politks.enums.UF;

public record ElectionDTO(
    Long id,
    UF uf,
    Municipality municipality,
    Position position,
    List<CandidateDTO> candidates
) {} 