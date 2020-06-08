package com.example.BookingDemo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// wont' return a view, it'll return a list of objects
@RestController
@RequestMapping(value = "/bookings")
public class BookingController {
    //since we aren't using a database yet, we'll use our hotelBookings in memory
    private List<HotelBooking> bookings;

    public BookingController() {
        bookings = new ArrayList<>();

        bookings.add(new HotelBooking("Marriott", 150.00, 5));
        bookings.add(new HotelBooking("Comfort Inn", 100.00, 3));
        bookings.add(new HotelBooking("Ritz-Carlton", 250.00, 4));
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<HotelBooking> getAll() {
        return bookings;
    }

    // the user will go to localhost 8080, the class mapping is "affordable" and whatever price user adds in the browser after
    // affordable will be interpreted as the PathVariable, and its value will be automatically populated

    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    // @PathVariable
    public List<Object> getAffordableHotels(@PathVariable double price) {
        // we'll return bookings. We'll create a stream and add a filter to getPricePerNight that's l<= to
        // the price that is given by the user
        return bookings.stream().filter(x -> x.getPricePerNight() <= price)
                //we'll collect the results in a list
                .collect(Collectors.toList());

        // user will go to localhost:8080/bookings/affordable
        // if s/he gives a price of 100, all hotels with cost <= 100 will be populated
    }

    // to create a new hotel booking, use POSTMAN
    // In Postman we'll send a request to bookings/create with the new hotelName, PricePerNight and NumberOfNights
    // and we'll send it
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking){
                                            // this @RequestBody will initialize a JSON
                                            // post request and if user Request Body will instruct Spring
                                            // to automatically create a booking hotel object based on the JSON
                                            // that's inside the request.
                                            // this is how the binding works between the
                                            // client and the server
        bookings.add(hotelBooking);
        // can see in Debug mode, BookingDemoApplication > Console > Frames > Variables
        // because of the default constructor, Spring knows how to bind the values from the http request,
        // to our object
    return bookings;
}
}
