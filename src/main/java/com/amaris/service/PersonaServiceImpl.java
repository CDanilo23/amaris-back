package com.amaris.service;

import com.amaris.dto.PersonaDto;
import com.amaris.entity.PersonaEntity;
import com.amaris.repository.PersonaRepository;
import com.amaris.util.PersonaMapper;
import com.amaris.util.Validations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    Logger logger = LoggerFactory.getLogger(PersonaServiceImpl.class);
    @Override
    public PersonaDto createPerson(PersonaDto personaDto) throws Exception {

        validateEmptyNullAndFormatParams(personaDto.getTipoDocumento(), personaDto.getNumDocumento());

        PersonaEntity personaEntity = personaRepository.save(PersonaMapper.dtoToEntity(personaDto));
        logger.info("objeto personaEntity recuperado de db: "+ personaEntity);
        return  PersonaMapper.entityToDto(personaEntity);
    }

    @Override
    public PersonaDto findByTipoDocumentoAndNumDocumento(String tipoDoc, Integer numDoc) throws Exception {

        validateEmptyNullAndFormatParams(tipoDoc,numDoc);

        PersonaEntity personaEntity = personaRepository.findByTipoDocumentoAndNumDocumento(tipoDoc, numDoc);
        logger.info("objeto personaEntity recuperado de db: "+ personaEntity);
        return PersonaMapper.entityToDto(personaEntity);
    }

    public void validateEmptyNullAndFormatParams(String tipoDoc, Integer numDoc) throws Exception {
        if (Validations.isEmptyString(tipoDoc) || numDoc == null) {
            logger.warn("Error de validación en servicio " + this.getClass().getName());
            throw new Exception("Bad request");
        }

        if(!tipoDoc.equalsIgnoreCase("C") && !tipoDoc.equalsIgnoreCase("P")) {
            logger.warn("Error de validación en servicio " + this.getClass().getName());
            throw new Exception("Bad request");
        }
    }
}
