package datastruct

def x_1 = "a is a single 'a' string"
def x_2 = 'a is a single \'a\' string'

println x_1
println x_2

println x_1.class
println x_2.class

def thupleString = '''\
line one
line two
line three
'''

println thupleString

def name = "groovy"
def sayHello = "hello, ${name}"

println sayHello
println sayHello.class


// 可扩展表达式
def sum = "the sum of 2 and 3 is ${2 + 3}"
println sum

def result = echo(sum)
println result
println result.class

String echo(String msg){
    return msg;
}

/*======================字符串的方法====================*/
println "---------------------------------------"

def str = "groovy hello"
println str.center(18, "*")

println str.padLeft(18, "*");

def str2 = "hello"
println str.compareTo(str2)
println str > str2

println str[0]
println str[0..1]
println str - str2

println str.reverse()
println str.capitalize()
println str.isNumber()  // 首字母大写

