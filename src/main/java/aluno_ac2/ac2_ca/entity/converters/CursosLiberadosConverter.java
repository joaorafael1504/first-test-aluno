package aluno_ac2.ac2_ca.entity.converters;

import aluno_ac2.ac2_ca.domain.CursosLiberados;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CursosLiberadosConverter implements AttributeConverter<CursosLiberados, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CursosLiberados cursosLiberados) {
        return (cursosLiberados == null) ? null : cursosLiberados.value();
    }

    @Override
    public CursosLiberados convertToEntityAttribute(Integer dbData) {
        return (dbData == null) ? null : CursosLiberados.of(dbData);
    }
}