package utilities;

import com.github.javafaker.Faker;

public class GenerateFakeMessage {

    public static String getValidZipcode() {
        Faker faker = new Faker();
        return faker.numerify("23###");
    }

    public static String getSixDigitsZipcode() {
        Faker faker = new Faker();
        return faker.numerify("23####");
    }
}
