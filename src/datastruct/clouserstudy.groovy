package datastruct

def clouser = {println "hello groovy"}

clouser.call()
clouser()

clouser = {String name -> println "hello ${name}"}
clouser("james")

// 闭包有一个隐式的参数，it，如果显式地指明了一个参数，隐式的参数将不存在
clouser = {println "hello ${it}"}
clouser("james")

clouser = {String name, int age -> println "i am ${name}, my age is ${age}"}
clouser("james", 33)

// 闭包是有返回值的，如果代码中没有写return语句，会返回null
def result = clouser("james", 33)
println result