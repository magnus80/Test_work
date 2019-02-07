package rs;

import com.github.javafaker.Faker;
import rs.entity.User;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class TestData {

    public static User getCorrectUser() {
        Faker faker = new Faker();
        return new User()
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName());
    }

    public static User getLongNameUser() {
        return new User()
                .setFirstName(randomAlphabetic(255))
                .setLastName(randomAlphabetic(255));
    }

    public static User getEmptyFirstNameUser() {
        return new User()
                .setFirstName("")
                .setLastName(randomAlphabetic(255));
    }

    public static User getEmptyLastNameUser() {
        return new User()
                .setFirstName(randomAlphabetic(255))
                .setLastName("");
    }


}
