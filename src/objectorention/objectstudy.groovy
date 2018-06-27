package objectorention

def person = new Person(name: "张三", age: 33)
person.incrementAge(10)

println person.toString()
println "${person.name}'s age is ${person.age}"


println person.cry()

// 使用MetaClass为类添加的方法属性在整个应用都生效
ExpandoMetaClass.enableGlobally()

Person.metaClass.gender = "male"
def person2 = new Person(name: "李四", age: 22)
println "${person2.name}'s age is ${person2.age}, gender is ${person2.gender}"
person2.gender = "female"
println "${person2.name}'s age is ${person2.age}, gender is ${person2.gender}"

// 为类动态添加方法
println "---------------------------------------"

Person.metaClass.genderUpperCase = { -> gender.toUpperCase() }
def person3 = new Person(name: "王五", age: 11)
println person3.genderUpperCase()

println "---------------------------------------"
Person.metaClass.static.newInstance = { String name, int age, String gender ->
    Person p = new Person(name: name, age: age, gender: gender)
    return p
}

Person person4 = Person.newInstance("james", 32, "female")
println "${person4.name}'s age is ${person4.age}, gender is ${person4.gender}"


