package guru.springframework.msscbeerservice.web.mappers;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Component
public class DateMapper {
    public OffsetDateTime asOffsetDateTime(Timestamp ts) {
        if(ts != null) {
            var localDatetime = ts.toLocalDateTime();
            return OffsetDateTime.of(localDatetime.getYear(), localDatetime.getMonthValue(),
                    localDatetime.getDayOfMonth(), localDatetime.getHour(), localDatetime.getMinute(),
                    localDatetime.getSecond(), localDatetime.getNano(), ZoneOffset.UTC);
        } else {
            return null;
        }
    }

    public Timestamp asTimestamp(OffsetDateTime offsetDateTime) {
            if(offsetDateTime != null) {
                return Timestamp.valueOf(offsetDateTime.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
            } else {
                return null;
            }
    }
}
