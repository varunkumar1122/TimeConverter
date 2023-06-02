package com.org.TimeConverter.TimeConverter.Service;

import com.org.TimeConverter.TimeConverter.Utilities.NumToTimeConverter;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class TimeServiceImpl {
        public String convertTimeToWords(LocalTime time) throws Exception {
            int hour = time.getHour();
            int minute = time.getMinute();

            if (hour == 12 && minute == 0) {
                return "It's Midday";
            } else if (hour == 0 && minute == 0) {
                return "It's Midnight";
            }

            String hourInWords = NumToTimeConverter.convertNumberToWords(hour);
            String minuteInWords = NumToTimeConverter.convertNumberToWords(minute);

            return "It's " + hourInWords + " " + (minute == 0 ? "" : minuteInWords) + " " + (minute == 1 ? "minute" : "minutes");
        }
    }


