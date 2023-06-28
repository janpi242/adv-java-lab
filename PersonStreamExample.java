import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonStreamExample {
    public static void main(String[] args) {
        // Tworzenie listy osób
        Person person1 = new Person("Anna", "Kowalska", 30, Gender.FEMALE);
        Person person2 = new Person("Jan", "Nowak", 40, Gender.MALE);
        Person person3 = new Person("Ewa", "Lis", 25, Gender.FEMALE);
        Person person4 = new Person("Grzegorz", "Kowalczyk", 35, Gender.MALE);
        Person person5 = new Person("Magda", "Szymańska", 50, Gender.FEMALE);
        Person person6 = new Person("Grażyna", "Kaczmarek", 60, Gender.FEMALE);

        person1.addFriend(person2);
        person1.addFriend(person3);
        person2.addFriend(person4);
        person3.addFriend(person5);
        person4.addFriend(person5);
        person4.addFriend(person6);
        person4.addFriend(person2);

        List<Person> people = Arrays.asList(person1, person2, person3, person4, person5, person6);

        // Znajdź wszystkie kobiety i wypisz je na ekran
        System.out.println("Kobiety:");
        people.stream()
                .filter(person -> person.getGender() == Gender.FEMALE)
                .forEach(System.out::println);

        System.out.println();

        // Znajdź nazwiska wszystkich mężczyzn
        System.out.println("Nazwiska mężczyzn:");
        people.stream()
                .filter(person -> person.getGender() == Gender.MALE)
                .map(Person::getLastName)
                .forEach(System.out::println);

        System.out.println();

        // Policz sumę wieku wszystkich osób
        int sumOfAges = people.stream()
                .mapToInt(Person::getAge)
                .sum();
        System.out.println("Suma wieku wszystkich osób: " + sumOfAges);

        System.out.println();

        // Policz sumę wieku wszystkich mężczyzn, których imię zaczyna się na 'G'
        int sumOfAgesForMaleNamesStartingWithG = people.stream()
                .filter(person -> person.getGender() == Gender.MALE && person.getFirstName().startsWith("G"))
                .mapToInt(Person::getAge)
                .sum();
        System.out.println("Suma wieku mężczyzn, których imię zaczyna się na 'G': " + sumOfAgesForMaleNamesStartingWithG);

        System.out.println();

        // Zgrupuj do mapy gdzie kluczem jest płeć, a wartością lista osób
        Map<Gender, List<Person>> groupedByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        System.out.println("Grupowanie osób według płci:");
        System.out.println(groupedByGender);

        System.out.println();

        // Znajdź wszystkie osoby, których liczba znajomych jest większa niż 2
        System.out.println("Osoby z liczbą znajomych większą niż 2:");
        people.stream()
                .filter(person -> person.getFriends().size() > 2)
                .forEach(System.out::println);

        System.out.println();

        // Znajdź wszystkie osoby, których liczba znajomych kobiet jest większa niż mężczyzn
        System.out.println("Osoby, których liczba znajomych kobiet jest większa niż mężczyzn:");
        people.stream()
                .filter(person -> countFemaleFriends(person) > countMaleFriends(person))
                .forEach(System.out::println);

        System.out.println();

        // Znajdź wszystkie relacje dwustronne
        System.out.println("Relacje dwustronne:");
        people.stream()
                .flatMap(person -> person.getFriends().stream()
                        .filter(friend -> friend.getFriends().contains(person)))
                .forEach(System.out::println);
    }

    // Metoda pomocnicza do zliczania liczby znajomych kobiet
    private static long countFemaleFriends(Person person) {
        return person.getFriends().stream()
                .filter(friend -> friend.getGender() == Gender.FEMALE)
                .count();
    }

    // Metoda pomocnicza do zliczania liczby znajomych mężczyzn
    private static long countMaleFriends(Person person) {
        return person.getFriends().stream()
                .filter(friend -> friend.getGender() == Gender.MALE)
                .count();
    }

    public static class Person {
        private String firstName;
        private String lastName;
        private int age;
        private Gender gender;
        private List<Person> friends;

        public Person(String firstName, String lastName, int age, Gender gender) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.gender = gender;
            this.friends = new ArrayList<>();
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }

        public List<Person> getFriends() {
            return friends;
        }

        public void addFriend(Person person) {
            friends.add(person);
        }

        @Override
        public String toString() {
            return firstName + " " + lastName + " (" + gender + ", " + age + " lat)";
        }
    }

    public enum Gender {
        MALE,
        FEMALE
    }
}

