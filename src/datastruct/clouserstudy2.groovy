package datastruct

/*===============downto、upto、times===============*/
int fab(int number) {
    int result = 1
    1.upto(number, { num -> result *= num })
    return result
}

int x = fab(5)
println x


int fab2(int number) {
    def result = 1
    number.downto(1) {
        num -> result *= num
    }
    return result
}

x = fab2(5)
println x

int cal(int number) {
    def result = 0
    number.times({
        num -> result += num
    })
    return result
}

x = cal(101)
println x