package aluno_ac2.ac2_ca.entity.converters;

import aluno_ac2.ac2_ca.domain.CursosLiberados;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CursosLiberadosConverter implements AttributeConverter<CursosLiberados, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CursosLiberados cursosLiberados) {
        // Pega o objeto 'CursosLiberados' e extrai o 'int' de dentro dele
        return (cursosLiberados == null) ? null : cursosLiberados.value();
    }

    @Override
    public CursosLiberados convertToEntityAttribute(Integer dbData) {
        // Pega o 'int' do banco e usa para criar um objeto 'CursosLiberados'
        return (dbData == null) ? null : CursosLiberados.of(dbData);
    }
}