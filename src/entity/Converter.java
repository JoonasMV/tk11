package entity;

import jakarta.persistence.AttributeConverter;

@jakarta.persistence.Converter(autoApply = true)
public class Converter implements AttributeConverter<Double, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Double balance) {
        return (int) (balance * 100);
    }

    @Override
    public Double convertToEntityAttribute(Integer balanceInCents) {
        return balanceInCents / 100.0;
    }
}
