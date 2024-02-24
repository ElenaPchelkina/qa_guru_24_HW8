package utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
        Faker faker = new Faker(new Locale("ru"));
        Faker emailFaker = new Faker(new Locale("eng"));

        public String getFirstName() {
            return faker.name().firstName();
        }

        public String getLastName() {
            return faker.name().lastName();
        }

        public String getGender() {
            String[] genders  = {"Male", "Female", "Other"};
            int index = faker.random().nextInt(0, genders.length - 1);
            return genders[index];
        }

        public String getEmail() {
            return emailFaker.internet().emailAddress();
        }

        public String getPhoneNumber(int length) {
            return faker.phoneNumber().subscriberNumber(10);
            }

        public String getAddress() {
            return faker.address().streetAddress();
        }

    public String getMonth() {
        String[] months  = {"January", "February",
                "March", "April", "May",
                "June", "July", "August",
                "September", "October", "November",
                "December"};
        int index = faker.random().nextInt(0, months.length - 1);
        return months[index];
    }

    public String getYear() {
        return String.valueOf(faker.random().nextInt(1900, 2024));
    }

    public String getDay() {
        return String.format("%02d", faker.number().numberBetween(1,28));
    }

    public String getSubject() {
        String[] subjects  = {"English", "Chemistry",
                "Computer Science", "Commerce", "Economics",
                "Social Studies", "Arts", "History",
                "Maths", "Accounting", "Physics",
                "Biology", "Hindi", "Civics"};
        int index = faker.random().nextInt(0, subjects.length - 1);
        return subjects[index];
    }

    public String getHobby() {
        String[] hobbies  = {"Sports", "Reading",
                "Music"};
        int index = faker.random().nextInt(0, hobbies.length - 1);
        return hobbies[index];
    }

    public String getPicture() {
        String[] pictures  = {"123.jpg", "124.jpg",
                "125.jpg"};
        int index = faker.random().nextInt(0, pictures.length - 1);
        return pictures[index];
    }

    public String getState() {
        String[] states  = {"NCR", "Uttar Pradesh",
                "Haryana", "Rajasthan"};
        int index = faker.random().nextInt(0, states.length - 1);
        return states[index];
    }

    public String getCity(String state) {
        Map<String, String> city = new HashMap<>() {{
            put("NCR","Delhi");
            put("NCR","Gurgaon");
            put("NCR","Noida");
            put("Uttar Pradesh","Agra");
            put("Uttar Pradesh","Lucknow");
            put("Uttar Pradesh","Merrut");
            put("Haryana","Karnal");
            put("Haryana","Panipat");
            put("Rajasthan","Jaipur");
            put("Rajasthan","Jaiselmer");
        }};
        return city.get(state);
    }



    }


