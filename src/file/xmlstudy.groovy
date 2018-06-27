package file

final String xml = '''
<response version-api="2.0">
    <value>
        <books id="1" classification="android">
            <book avaliable="20" id="1">
                <title>疯狂Android讲义</title>
                <author id="1">李刚</author>
            </book>
            <book avaliable="14" id="2">
                <title>第一行代码</title>
                <author id="2">郭林</author>
            </book>
            <book avaliable="13" id="3">
                <title>Android开发艺术探索</title>
                <author id="3">任玉刚</author>
            </book>
            <book avaliable="5" id="4">
                <title>Android源码设计模式</title>
                <author id="4">何洪辉</author>
            </book>
        </books>
        <books id="2" classification="web">
            <book avaliable="10" id="1">
                <title>Vue从入门到精通</title>
                <author id="4">李刚</author>
            </book>
        </books>
    </value>
</response>
'''

def xmlSluper = new XmlSlurper()
def response = xmlSluper.parseText(xml)

println response.value
println response.value.books[0].book[0]
println response.value.books[0].book[0].@avaliable
println response.value.books[0].book[0].title.text()
println response.value.books[0].book[0].author.text()

println "--------------------"

def list = []
response.value.books.each {
    books ->
        books.book.each {
            book ->
                if ("李刚".equals(book.author.text())) {
                    list.add(book.title.text())
                }
        }
}
println list.toListString()

println "--------------------"

// 深度遍历，这里的 depthFirst() 可以用 ** 代替
def titles = response.depthFirst().findAll { book -> return "李刚".equals(book.author.text()) }.collect {
    return it.title.text()
}
println titles

println "--------------------"

// 广度遍历，这里的 children() 可以用 * 代替
def name = response.value.books."*".findAll {
    node -> node.name() == "book" && node.@id == "2"
}.collect {
    node -> return node.title.text()
}
println name