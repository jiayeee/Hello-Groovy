package file

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import objectorention.Person

def list = [new Person(name: "james", age: 23), new Person(name: "jack", age: 20)]
def json = JsonOutput.toJson(list)
println JsonOutput.prettyPrint(json)

def slurper = new JsonSlurper()
slurper.parseText(json).each {
    println it
}