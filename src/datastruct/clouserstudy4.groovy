package datastruct

/*===============闭包的三个重要参数：this、owner、delegate===============*/
def scriptClouser = {
    println this // 代表闭包定义处的类
    println owner // 代表闭包定义处的类或对象
    println delegate // 代表任意对象，默认跟owner一样
}

scriptClouser()

class Person {
    def static classClouser = {
        println this
        println owner
        println delegate
    }

    def static say = {
        def classClouser = {
            println this
            println owner
            println delegate
        }

        classClouser()
    }
}

println "---------Person.classClouser()----------"
Person.classClouser()
println "---------Person.say()----------"
Person.say()

class Person2 {
    def classClouser = {
        println this
        println owner
        println delegate
    }

    def say = {

        def classClouser = {
            println this
            println owner
            println delegate
        }

        classClouser()
    }
}

Person2 p2 = new Person2()
println "--------p2.classClouser()-----------"
p2.classClouser()
println "--------p2.say()-----------"
p2.say()

/**
 * 闭包中定义闭包
 *
 * 理解：this最外层发起调用的对象，owner是离自己最近一层发起调用的对象，delegate一般情况下跟owner一致
 * */
def nestClouser = {

    def innerClouser = {
        println this
        println owner
        println delegate
    }
    innerClouser.delegate = p2 // 修改delegate的默认值
    innerClouser()
}

println "-------------------"
nestClouser()