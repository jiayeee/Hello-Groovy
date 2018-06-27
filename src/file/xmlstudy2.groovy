package file

import groovy.xml.MarkupBuilder

/**
 * xml数据生成
 *
 <langs type="current" count="3" mainstream="true">
 <language flavor="static" version="1.5">java<language>
 <language flavor="dynamic" version="1.6.0">groovy<language>
 <language flavor="dynamic" version="1.9">javascript<language>
 </langs>
 *
 * */
def sw = new StringWriter()
def xmlBuilder = new MarkupBuilder()
xmlBuilder.langs(type: "current", count: "3", mainstream: "true") {
    language(flavor: "static", version: "1.5", value: "java") {
        age(10)
    }
    language(flavor: "dynamic", version: "1.6.0", value: "groovy") {
        age(16)
    }
    language(flavor: "dynamic", version: "1.9", value: "javascript")
}
println sw

class Language {
    String flavor
    String version
    String value
}

class Langs {
    String type
    int count
    boolean mainstream
    def languages = [
            new Language(flavor: "static", version: "1.5", value: "java"),
            new Language(flavor: "dynamic", version: "1.6.0", value: "groovy"),
            new Language(flavor: "dynamic", version: "1.9", value: "javascript")
    ]
}

//
def langs = new Langs()
xmlBuilder.langs(type: langs.type, count: langs.count, mainstream: langs.mainstream) {
    langs.languages.each {
        lang -> language(flavor: lang.flavor, version: lang.version, value: lang.value)
    }
}
println sw