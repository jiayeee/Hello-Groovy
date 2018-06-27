package datastruct

/**
 * Map 操作详解
 * */
def students = [
        1: [number: '001', name: 'Bob', score: 55, gender: 'male'],
        2: [number: '002', name: 'Johny', score: 33, gender: 'female'],
        3: [number: '003', name: 'Lily', score: 63, gender: 'female'],
        4: [number: '004', name: 'Lucy', score: 72, gender: 'male']
]

// 遍历
students.each {
    def student -> println "the key is ${student.key}, the value is ${student.value}"
}

println "-----------------------------"
students.each {
    key, value -> println "the key is ${key}, the value is ${value}"
}

// 带索引的遍历
println "-----------------------------"
students.eachWithIndex {
    def student, int i -> println "the key is ${student.key}, the value is ${student.value}, and the index is ${i}"
}
println "-----------------------------"
students.eachWithIndex {
    key, value, i -> println "the key is ${key}, the value is ${value}, and the index is ${i}"
}

// 查找
def result = students.find {
    def student -> return student.value.score > 60
}
println "-----------------------------"
println result

result = students.findAll {
    def student -> return student.value.score > 60
}
println "-----------------------------"
println result

def count = students.count {
    def student -> return student.value.score > 60 && student.value.gender == 'male'
}
println "-----------------------------"
println count

result = students.findAll {
    def student -> return student.value.score > 60
}.collect {
    return it.value.name
}
println "-----------------------------"
println result

// 分组
def group = students.groupBy {
    return it.value.score >= 60 ? "及格" : "不及格"
}
println "-----------------------------"
println group
println group.getClass()

// 排序
result = students.sort {
    def s1, def s2 ->
        Number score1 = s1.value.score
        Number score2 = s2.value.score
        return score1 == score2 ? 0 : score1 > score2 ? -1 : 1
}
println "-----------------------------"
println result