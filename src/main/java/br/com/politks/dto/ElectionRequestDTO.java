package br.com.politks.dto;

import br.com.politks.enums.Municipality;
import br.com.politks.enums.Position;
import br.com.politks.enums.UF;

public record ElectionRequestDTO(UF uf, Municipality municipality, Position position) {}
