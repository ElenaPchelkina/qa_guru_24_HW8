package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

public class RegistrationWithFaker extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();

    @Test
    void successfulRegistrationTest() {

        String firstName = randomUtils.getFirstName();
        String lastName = randomUtils.getLastName();
        String gender = randomUtils.getGender();
        String userEmail = randomUtils.getEmail();
        String userNumber = randomUtils.getPhoneNumber(10);
        String address = randomUtils.getAddress();
        String year = randomUtils.getYear();
        String month = randomUtils.getMonth();
        String day = randomUtils.getDay();
        String subject = randomUtils.getSubject();
        String hobby = randomUtils.getHobby();
        String filename = randomUtils.getPicture();
        String state = randomUtils.getState();
        String city = randomUtils.getCity(state);

        registrationPage.openPage().closeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .setSubject(subject)
                .setHobbies(hobby)
                .setPicture(filename)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", filename)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);

    }

    @Test
    void registrationMinTest() {

        String firstName = randomUtils.getFirstName();
        String lastName = randomUtils.getLastName();
        String gender = randomUtils.getGender();
        String userNumber = randomUtils.getPhoneNumber(10);

        registrationPage.openPage().closeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .submit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber);

    }

    @Test
    void registrationNegativeTest() {

        String firstName = randomUtils.getFirstName();
        String gender = randomUtils.getGender();
        String userNumber = randomUtils.getPhoneNumber(10);

        registrationPage.openPage().closeBanners()
                .setFirstName(firstName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .submit();

        registrationPage.checkModalDialog();

    }
}

