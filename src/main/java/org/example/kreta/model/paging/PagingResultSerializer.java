package org.example.kreta.model.paging;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class PagingResultSerializer extends JsonSerializer<PagingResult> {
    @Override
    public void serialize(PagingResult value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value!=null) {

            gen.writeStartObject();
            gen.writeNumberField("NumberOfItem", value.getNumberOfItem());
            gen.writeNumberField("PageSize",value.getPageSize());
            gen.writeNumberField("CurrentPage",value.getCurrentPage());
            gen.writeNumberField("NumberOfPage",value.getNumberOfPage());
            gen.writeEndObject();
        }
    }
}
