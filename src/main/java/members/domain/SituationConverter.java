package members.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SituationConverter implements AttributeConverter<Situation, String> {
    @Override
    public String convertToDatabaseColumn(Situation situation) {
        return situation.getLabel();
    }

    @Override
    public Situation convertToEntityAttribute(String s) {
        return Situation.findByLabel(s);
    }
}