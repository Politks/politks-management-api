package br.com.politks.dto;

import br.com.politks.enums.Municipality;
import br.com.politks.enums.Position;
import br.com.politks.enums.UF;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;

public record ElectionDTO(
    Long id,
    UF uf,
    Municipality municipality,
    Position position,
    @JsonFormat(pattern = "dd/MM/yyyy") Date electionDate,
    List<CandidateDTO> candidates) {}
