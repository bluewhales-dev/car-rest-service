package sample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CarController {

    private static final String getTemplate = "Car is return, %s!";
    private static final String postTemplate = "New Car added, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/car", method = RequestMethod.GET)
    public Car getNewCar(@RequestParam(value = "name", defaultValue = "Vitz") String name) {
        Random random = new Random();
        int size = random.ints(8, (18 + 1)).findFirst().getAsInt() * 1000;
        return new Car(String.format(getTemplate, name), counter.incrementAndGet(), size, "Red");
    }

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public Car setNewCar(@RequestParam String name, @RequestParam String color,
                         @RequestParam Integer engineSize) {
        return new Car(String.format(postTemplate, name), counter.incrementAndGet(), engineSize, color);
    }

}

