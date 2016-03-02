package lambdaTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Supplier;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    int age;

    public void testEnum(){
        gender = Sex.FEMALE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void printPerson() {
        System.out.println("Person  = " + name+"-"+birthday+"-"+gender+"-"+emailAddress+"-"+age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress, int age) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.age = age;
    }

    public Person() {
    }

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithinAgeRange(
            List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    public static void printPersons(
            List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    interface CheckPerson {
        boolean test(Person p);
    }

    class CheckPersonEligibleForSelectiveService implements CheckPerson {
        public boolean test(Person p) {
            return p.gender == Person.Sex.MALE &&
                    p.getAge() >= 18 &&
                    p.getAge() <= 25;
        }
    }

    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        LocalDate date = LocalDate.now();
        String text = date.format(formatter);
        System.out.println(text);

        date = LocalDate.of(2000,1,1);
        System.out.println(date.format(formatter));


        Person person = new Person("A",LocalDate.of(1990,10,4),Sex.MALE,"1",10);
        Person person2 = new Person("B",LocalDate.of(1990,10,3),Sex.MALE,"1",19);
        Person person3 = new Person("B",LocalDate.of(1990,10,9),Sex.MALE,"1",19);
        List<Person> roster = new ArrayList<Person>();
        roster.add(person);
        roster.add(person2);
        roster.add(person3);

    //   printPersons(roster,person.new CheckPersonEligibleForSelectiveService());
    //   printPersons(roster,p -> p.getAge()<=18);


        //----------------
//        Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);
    //  Arrays.sort(rosterAsArray, new PersonAgeComparator());
//        Arrays.sort(rosterAsArray,
//                (Person a, Person b) -> a.getBirthday().compareTo(b.getBirthday())
//        );
//        Arrays.sort(rosterAsArray, Person::compareByAge);
//        rosterAsArray[0].printPerson();
//        rosterAsArray[1].printPerson();
//        rosterAsArray[2].printPerson();

        Set<Person> rosterSetLambda =
                transferElements(roster, () -> { return new HashSet<>(); });

        Set<Person> rosterSet = transferElements(roster, HashSet::new);

        Set<Person> rosterSet2 = transferElements(roster, HashSet<Person>::new);

        roster.get(0).printPerson();

//        String[] stringArray = { "Barbara", "James", "Mary", "John",
//                "Patricia", "Robert", "Michael", "Linda" };
//        Arrays.sort(stringArray, String::compareToIgnoreCase);
//
//        System.out.println(stringArray[2]);


    }
    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    static class PersonAgeComparator implements Comparator<Person> {
        public int compare(Person a, Person b) {
            return a.getBirthday().compareTo(b.getBirthday());
        }
    }




    //---------------//
    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
    DEST transferElements(
            SOURCE sourceCollection,
            Supplier<DEST> collectionFactory) {

        DEST result = collectionFactory.get();
        for (T t : sourceCollection) {
            result.add(t);
        }
        return result;
    }

    public void testTT(List<Person> roster){
        Set<Person> rosterSetLambda =
                transferElements(roster, () -> { return new HashSet<>(); });
    }

}