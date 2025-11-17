package aluno_ac2.ac2_ca.entity.converters;

import aluno_ac2.ac2_ca.domain.Media;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MediaConverter implements AttributeConverter<Media, Double> {

    @Override
    public Double convertToDatabaseColumn(Media media) {
        return (media == null) ? null : media.value();
    }

    @Override
    public Media convertToEntityAttribute(Double dbData) {
        return (dbData == null) ? null : Media.of(dbData);
    }
}