package datastruct

def range = 1..10
println range
println range.getClass()
println range[2]
println range.contains(3)
println range.from
println range.to

range.each {
    print "${it}-"
}
println ""

for (i in range) {
    print "${i}-"
}

def getGrade(Number number) {
    def result
    switch (number) {
        case 0..<60:
            result = "不及格"
            break
        case 60..<70:
            result = "及格"
            break
        case 70..<80:
            result = "良好"
            break
        case 80..100:
            result = "优秀"
            break
    }

    return result
}

println "-------------------"
println getGrade(70)
println getGrade(80)
println getGrade(99)