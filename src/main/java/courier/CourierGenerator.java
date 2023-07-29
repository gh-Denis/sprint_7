package courier;

import com.github.javafaker.Faker;

public class CourierGenerator {
private static Faker faker = new Faker();
    public Courier getRandomCourier() {
        return new Courier(faker.name().username(), faker.internet().password(), faker.name().firstName());
    }
}