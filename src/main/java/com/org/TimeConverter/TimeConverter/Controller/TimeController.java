package com.org.TimeConverter.TimeConverter.Controller;

import com.org.TimeConverter.TimeConverter.Service.TimeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping("/timeConversion")
public class TimeController {

        private final TimeServiceImpl timeService;

        public TimeController(TimeServiceImpl timeService) {
            this.timeService = timeService;
        }

        @GetMapping("/currentTime")
        public ResponseEntity<String> convertCurrentTimeToWords() {
            try {
                LocalTime currentTime = LocalTime.now();
                String timeInWords = timeService.convertTimeToWords(currentTime);
                return ResponseEntity.ok(timeInWords);
            } catch (Exception ex) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
            }
        }
    }


