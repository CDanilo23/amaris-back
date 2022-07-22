package com.amaris.util;

import com.amaris.dto.PersonaDto;
import com.amaris.entity.PersonaEntity;

public class PersonaMapper {

    public static PersonaDto entityToDto(PersonaEntity personaEntity){
        PersonaDto personaDto = new PersonaDto();
        personaDto.setId(personaEntity.getId());
        personaDto.setTipoDocumento(personaEntity.getTipoDocumento());
        personaDto.setNumDocumento(personaEntity.getNumDocumento());
        personaDto.setPrimerNombre(personaEntity.getPrimerNombre());
        personaDto.setSegundoNombre(personaEntity.getSegundoNombre());
        personaDto.setPrimerApellido(personaEntity.getPrimerApellido());
        personaDto.setSegundoApellido(personaEntity.getSegundoApellido());
        personaDto.setTelefono(personaEntity.getTelefono());
        personaDto.setDireccion(personaEntity.getDireccion());
        personaDto.setCiudadResidencia(personaEntity.getCiudadResidencia());
        return personaDto;
    }


    public static PersonaEntity dtoToEntity(PersonaDto personaDto) {
        PersonaEntity personaEntity = new PersonaEntity();
        personaEntity.setTipoDocumento(personaDto.getTipoDocumento());
        personaEntity.setNumDocumento(personaDto.getNumDocumento());
        personaEntity.setPrimerNombre(personaDto.getPrimerNombre());
        personaEntity.setSegundoNombre(personaDto.getSegundoNombre());
        personaEntity.setPrimerApellido(personaDto.getPrimerApellido());
        personaEntity.setSegundoApellido(personaDto.getSegundoApellido());
        personaEntity.setTelefono(personaDto.getTelefono());
        personaEntity.setDireccion(personaDto.getDireccion());
        personaEntity.setCiudadResidencia(personaDto.getCiudadResidencia());
        return personaEntity;
    }
}
