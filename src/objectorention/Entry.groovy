package objectorention

class Entry {

    static void main(def args) {
        println "程序正在启动........"
        ApplicationManager.init()
        println "程序启动完成........"

        def person = PersonManager.createPerson("jack", 32)
        println "${person.name}'s age is ${person.age}"
    }
}