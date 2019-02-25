package catService;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class Cat {
    private String name;
    private String petKeeper;
    private LocalDate date;
    private double weight;

    // CONSTRUCTORS

    Cat() {
        this.name = null;
        this.petKeeper = null;
        this.date = null;
        this.weight = 0.0;
    }

    public Cat(String name, String petKeeper) {
        this.name = name;
        this.petKeeper = petKeeper;
    }
}
