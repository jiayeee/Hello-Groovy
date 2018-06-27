package objectorention

class PersonManager {

    static Person createPerson(String name, int age) {
        return Person.newInstance(name, age)
    }
}
