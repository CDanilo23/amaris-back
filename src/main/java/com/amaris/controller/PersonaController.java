package com.amaris.controller;

import com.amaris.dto.PersonaDto;
import com.amaris.service.PersonaService;
import com.amaris.util.Validations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
public class PersonaController {

    Logger logger = LoggerFactory.getLogger(PersonaController.class);

    @Autowired
    private PersonaService personaService;

    @RequestMapping(value = "/findByTypeAndNum/{tipoDoc}/{numDoc}", method = RequestMethod.GET)
    public ResponseEntity getPersonaByTypeAndNumDocumento(@PathVariable String tipoDoc, @PathVariable Integer numDoc) {

        try {
            PersonaDto personaDto = personaService.findByTipoDocumentoAndNumDocumento(tipoDoc, numDoc);
            logger.info("objeto personaDto recuperado de db: "+ personaDto.toString());
            return ResponseEntity.ok(personaDto);
        } catch (Exception e) {
            logger.warn("Error de validación");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El tipo de documento no debe ser null o vacio y debe ser 'P' o 'C'");
        }

    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity createPerson(@RequestBody PersonaDto personaDto){

        try {
            logger.info("parametro personaDto de entrada al servicio: "+ personaDto.toString());
            PersonaDto personaDto1 = personaService.createPerson(personaDto);
            logger.info("objeto personaDto creado en db: "+ personaDto1.toString());
            return ResponseEntity.status(HttpStatus.OK).body(personaDto1);
        } catch (Exception e) {
            logger.warn("Error de validación");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El tipo de documento no debe ser null o vacio y debe ser 'P' o 'C'");
        }

    }
}
