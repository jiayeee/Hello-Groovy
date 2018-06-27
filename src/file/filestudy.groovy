package file

import objectorention.Person

File file = new File("../../Hello Groovy.iml")
file.eachLine {
    println it
}

println "----------------"
println file.getText()

println "----------------"
file.readLines().each {
    println it
}

println "----------------"
println file.withReader { reader ->
    def result = ""

    char[] tmp = new char[4]
    int len = -1
    for (; ;) {
        len = reader.read(tmp)
        if (len == -1)
            break

        result += new String(tmp, 0, len)
    }

    return result
}

def copy(String sourcePath, String destPath) {
    try {
        def lineSeparator = System.getProperty("line.separator")

        def destFile = new File(destPath)
        if (!destFile.exists()) {
            destFile.createNewFile()
        }

        new File(sourcePath).withReader { reader ->
            def lines = reader.readLines()
            destFile.withWriter { writer ->
                lines.each { line ->
                    writer.append("$line$lineSeparator")
                }
            }
        }

        return true
    } catch (Exception e) {
        e.printStackTrace()
    }

    return false
}

copy("../../Hello Groovy.iml", "../../Hello Groovy2.iml")

def saveObject(Object obj, String path) {
    try {
        def file = new File(path)
        if (!file.exists()) {
            file.createNewFile()
        }

        file.withObjectOutputStream { out ->
            out.writeObject(obj)
        }

        return true
    } catch (Exception e) {
        e.printStackTrace()
    }

    return false
}

def readObject(String path) {
    def obj = null

    try {
        def file = new File(path)
        if (file == null || !file.exists())
            return null

        file.withObjectInputStream { input ->
            obj = input.readObject()
        }

    } catch (Exception e) {
        e.printStackTrace()
    }

    return obj
}

def person = new Person(name: "张三", age: 23)
println saveObject(person, "../../person")

def p = readObject("../../person")
println "${p.name}'s age is ${p.age}"