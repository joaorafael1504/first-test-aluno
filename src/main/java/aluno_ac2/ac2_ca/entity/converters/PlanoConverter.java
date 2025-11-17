package aluno_ac2.ac2_ca.entity.converters;

import aluno_ac2.ac2_ca.domain.Plano;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PlanoConverter implements AttributeConverter<Plano, String> {

    @Override
    public String convertToDatabaseColumn(Plano plano) {
        // Pega o objeto 'Plano' e o transforma na String "Premium" ou "Básico"
        return (plano == null) ? null : plano.asLabel();
    }

    @Override
    public Plano convertToEntityAttribute(String dbData) {
        // Pega a String "Premium" ou "Básico" do banco e transforma no objeto 'Plano'
        return (dbData == null) ? null : Plano.fromLabel(dbData);
    }
}