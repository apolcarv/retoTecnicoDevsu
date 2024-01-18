package co.com.devsu.project.helpers;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

import static co.com.devsu.project.helpers.Constant.ONE;
import static co.com.devsu.project.helpers.Constant.SIX;

public class DataFaker {
    private DataFaker() {}

    private static Faker faker = Faker.instance(new Locale("es", "CO"), new Random());

    public static String fakerNumberOneAndSix(){
        return  String.valueOf(faker.number().numberBetween(ONE,SIX));
    }
}
