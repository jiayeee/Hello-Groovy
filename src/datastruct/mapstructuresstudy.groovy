package datastruct

def colors = [
        red  : "ff0000",
        green: "00ff00",
        blue : "0000ff"
]

//def colors = [
//        red  : "ff0000",
//        green: "00ff00",
//        blue : "0000ff"
//] as Hashtable

// 索引方式
println colors["red"]
println colors.red

// 添加元素
colors.yello = "ffff00"
println colors.toMapString()

colors.leftShift(dark: "ffffff")
println colors.toMapString()

colors.complex = [a: 1, b: 3]
println colors.toMapString()
println colors.getClass()