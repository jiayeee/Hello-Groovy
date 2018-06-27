package objectorention

class Person implements Serializable {

    String name
    Integer age

    def incrementAge(Integer year) {
        this.age += year
    }

    def invokeMethod(String name, Object args) {
        return "the method is ${name} and the args is ${args}"
    }

    def methodMissing(String name, Object args) {
        return "the method is ${name} is missing"
    }
}
