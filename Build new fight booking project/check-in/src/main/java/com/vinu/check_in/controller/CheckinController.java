package com.vinu.check_in.controller;

import com.vinu.check_in.dto.CheckinRequest;
import com.vinu.check_in.dto.CheckinResponse;
import com.vinu.check_in.service.CheckinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkin")
public class CheckinController {

    @Autowired
    private CheckinService checkinService;

    @PostMapping
    public CheckinResponse doCheckin(@RequestBody CheckinRequest request) {
        return checkinService.checkin(request);
    }

    @GetMapping("/{bookingId}")
    public CheckinResponse getCheckinInfo(@PathVariable Long bookingId) {
        return checkinService.getCheckinByBookingId(bookingId);
    }
}
