package com.hellojd.jpetstore.app.convert;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
@Component
public class StringToLocalDateTimeConverter
  implements Converter<String, LocalDateTime> {
 
    @Override
    public LocalDateTime convert(String source) {
        DateTimeFormatter sf = DateTimeFormat.shortDate();
        return LocalDateTime.parse(source, sf);
    }
}