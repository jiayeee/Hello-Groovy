package datastruct

def x = 3.14
def result

switch (x) {
    case "foo":
        result = "foo found"
        break
    case "bar":
        result = "bar found"
        break
//    case [1, 2, 3, "inlist"]:
    case [3.14, 1, 2, 3, "inlist"]:
        result = "list found"
        break
    case 12..30:
        result = "range found"
        break
    case Integer:
        result = "integer found"
        break
    case BigDecimal:
        result = "BigDecimal found"
        break
    default:
        result = "default"
        break
}

println result
println "------------------------------------"

// 对范围的for循环
def sum = 0
for (i in 0..9){
    sum += i
}
println sum

// list 循环
sum = 0
for (i in [1, 2, 3, 4, 5, 6, 7]){
    sum += i
}
println sum

// map 循环
sum = 0
for (i in ["lucy": 1, "lily": 2, "tom": 3]){
    sum += i.value
}
println sum
