package com.barbershop.common.utils.document_type;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class DocumentTypeConverter implements AttributeConverter<DocumentType, String> {

    @Override
    public String convertToDatabaseColumn(DocumentType documentType) {
        return documentType.getValue();
    }

    @Override
    public DocumentType convertToEntityAttribute(String value) {
        return DocumentType.fromValue(value);
    }

}



