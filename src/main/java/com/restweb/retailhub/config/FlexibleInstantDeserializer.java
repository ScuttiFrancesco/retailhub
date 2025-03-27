package com.restweb.retailhub.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class FlexibleInstantDeserializer extends JsonDeserializer<Instant> {
    @Override
    public Instant deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String dateString = p.getText().trim();
        
        // Intenta como Instant completo
        try {
            return Instant.parse(dateString);
        } catch (Exception e) {
            // Intenta como fecha simple yyyy-MM-dd
            try {
                LocalDate date = LocalDate.parse(dateString);
                return date.atStartOfDay().toInstant(ZoneOffset.UTC);
            } catch (Exception e2) {
                throw new IOException("Formato de fecha no válido: " + dateString);
            }
        }
    }
}