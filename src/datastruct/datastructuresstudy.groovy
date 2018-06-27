package datastruct

def list = new ArrayList()
list = [1, 2, 3, 4]
println list.class
println list.size()

println "----------------------------"

def array = [1, 2, 3, 4] as int[]
int[] array2 = [1, 2, 3, 4]
println array.class
println array2.class

// 列表排序
def sortList = [1, -1, 7, 3, 8, -2]
sortList.sort()

println "----------------------------"
println sortList

sortList.sort {
    a, b -> a == b ? 0 : Math.abs(a) > Math.abs(b) ? 1 : -1
}
println "----------------------------"
println sortList


def sortStringList = ["z", "abc", "dd", "groovy", "hello"]
sortStringList.sort {
    return it.size().multiply(-1)
}
println "----------------------------"
println sortStringList

// 列表查找
def findList = [1, -1, 7, 3, 8, -2]
def result = findList.find {
    return it % 2 == 0
}
println "----------------------------"
println result
println findList.findAll {
    return it % 2 == 0
}
println findList.min()
println findList.max()
// 绝对值的最大值和最小值
println findList.min {
    return Math.abs(it)
}
println findList.max {
    return Math.abs(it)
}
println findList.count() {
    return it % 2 == 0
}