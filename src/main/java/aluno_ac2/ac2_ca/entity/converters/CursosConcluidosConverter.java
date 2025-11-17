package aluno_ac2.ac2_ca.entity.converters;

import aluno_ac2.ac2_ca.domain.CursosConcluidos;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CursosConcluidosConverter implements AttributeConverter<CursosConcluidos, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CursosConcluidos cursosConcluidos) {
        // Pega o objeto 'CursosConcluidos' e extrai o 'int' de dentro dele
        return (cursosConcluidos == null) ? null : cursosConcluidos.value();
    }

    @Override
    public CursosConcluidos convertToEntityAttribute(Integer dbData) {
        // Pega o 'int' do banco e usa para criar um objeto 'CursosConcluidos'
        return (dbData == null) ? null : CursosConcluidos.of(dbData);
    }
}