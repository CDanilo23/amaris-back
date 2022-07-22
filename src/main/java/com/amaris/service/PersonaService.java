package com.amaris.service;

import com.amaris.dto.PersonaDto;
import org.springframework.stereotype.Service;

@Service
public interface PersonaService {

    PersonaDto createPerson(PersonaDto personaDto) throws Exception;
    PersonaDto findByTipoDocumentoAndNumDocumento(String tipoDocumento, Integer numDocumento) throws Exception;
}
