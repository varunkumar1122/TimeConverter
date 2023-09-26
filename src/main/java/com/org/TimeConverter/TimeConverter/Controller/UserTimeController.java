package com.org.TimeConverter.TimeConverter.Controller;

import com.org.TimeConverter.TimeConverter.Service.TimeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("/timeConversions")
public class UserTimeController {
        private final TimeServiceImpl timeService;

        public UserTimeController(TimeServiceImpl timeService) {
            this.timeService = timeService;
        }

        @PostMapping("/convertToTimes")
        public ResponseEntity<String> convertTimeToWords(@RequestBody String timeString) {
            try {
                LocalTime time = LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm"));
                String timeInWords = timeService.convertTimeToWords(time);
                return ResponseEntity.ok(timeInWords);
            } catch (DateTimeParseException ex) {
                return ResponseEntity.badRequest().body("Invalid time format. Please  enter a valid format ");
            } catch (Exception ex) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
            }
        }
    }


