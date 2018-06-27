package datastruct

/*===============字符串与闭包结合使用===============*/
/*===============each、find、findAll、any、every、collect===============*/
String str = "2 add 3 is 5"
str.each { c -> print c }

println ""

str.each { c -> print c.multiply(2) }

println ""
println "----------------------------"

println str.find {
    c -> c.isNumber()
}

println "----------------------------"

def list = str.findAll {
    c -> c.isNumber()
}
println list.toListString()
println "----------------------------"

def result = str.any {
    c -> c.isNumber()
}
println result

result = str.every {
    c -> c.isNumber()
}
println result

result = str.collect {
    c -> c.toUpperCase()
}
println result

