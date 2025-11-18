package aluno_ac2.ac2_ca.entity.converters;

import aluno_ac2.ac2_ca.domain.Plano;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PlanoConverter implements AttributeConverter<Plano, String> {

    @Override
    public String convertToDatabaseColumn(Plano plano) {
        return (plano == null) ? null : plano.asLabel();
    }

    @Override
    public Plano convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : Plano.fromLabel(dbData);
    }
}