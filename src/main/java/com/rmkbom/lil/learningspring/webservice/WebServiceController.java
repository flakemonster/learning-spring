package com.rmkbom.lil.learningspring.webservice;

import com.rmkbom.lil.learningspring.business.ReservationService;
import com.rmkbom.lil.learningspring.business.RoomReservation;
import com.rmkbom.lil.learningspring.data.Guest;
import com.rmkbom.lil.learningspring.data.Room;
import com.rmkbom.lil.learningspring.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api")
public class WebServiceController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public WebServiceController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<RoomReservation> getReservations(
                @RequestParam(value = "date", required = false)String dateString) {
        Date date = dateUtils.createDateFromDateString(dateString);
        return reservationService.getRoomReservationsForDate(date);
    }

    @GetMapping("/guests")
    public List<Guest> getGuests() {
        return reservationService.getAllGuests();
    }

    @PostMapping("/guests")
    @ResponseStatus(HttpStatus.CREATED)
    public void addGuest(@RequestBody Guest guest) {
        reservationService.addGuest(guest);
    }

    @GetMapping("/rooms")
    public List<Room> getRooms() {
        return reservationService.getRooms();
    }
}
