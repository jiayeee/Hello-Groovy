package datastruct

/*===============闭包的委托策略===============*/
class Student {
    String name
    def pretty = {"my name is ${name}"}
    String toString(){
        pretty()
    }
}

class Teacher{
    String name
}

def s = new Student(name: "sara")
def t = new Teacher(name: "jack")
println s.toString()

println "----------------"
s.pretty.delegate = t
s.pretty.resolveStrategy = Closure.DELEGATE_FIRST // 先从delegate对象找name属性，找不到再从name1找
println  s.toString()
