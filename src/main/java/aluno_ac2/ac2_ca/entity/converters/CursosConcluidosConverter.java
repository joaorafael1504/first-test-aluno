package aluno_ac2.ac2_ca.entity.converters;

import aluno_ac2.ac2_ca.domain.CursosConcluidos;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CursosConcluidosConverter implements AttributeConverter<CursosConcluidos, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CursosConcluidos cursosConcluidos) {
        return (cursosConcluidos == null) ? null : cursosConcluidos.value();
    }

    @Override
    public CursosConcluidos convertToEntityAttribute(Integer dbData) {
        return (dbData == null) ? null : CursosConcluidos.of(dbData);
    }
}