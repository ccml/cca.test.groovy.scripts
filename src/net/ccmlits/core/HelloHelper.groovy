package net.ccmlits.core

class HelloHelper {

    /** A map that holds all constants and data members that can be override when constructing  */
    final helloHelperEnv

    /**
    * Imitates a constructor
    * Defines an instance of HelloHelper object. All according to api
    * @param hiWord - word that say hello
    * @param helloSentenceEnd - end of the hello sentence
    * @return
    */
    HelloHelper(String hiWord, String helloSentenceEnd){

        this.helloHelperEnv = [
                hiWord : hiWord,
                helloSentenceEnd: helloSentenceEnd,
                defaultName: 'World'

        ]
    }

    def changeDefaultName(String name) {
        HelloHelper.put('defaultName', name)
    }

    def sayHelloSentence(String name) {
        if(!name) {
            Script.environment.sh "echo" + "${helloHelperEnv.hiWord}, ${helloHelperEnv.defaultName} ${helloHelperEnv.helloSentenceEnd}"
        } else {
            Script.environment.sh "echo" + "${helloHelperEnv.hiWord}, ${name} ${helloHelperEnv.helloSentenceEnd}"
        }
    }

    def sayHello1FromClass(String name) {
        sayHello2FromClass("${name} (1)")
    }

    def sayHello2FromClass(String name) {
        Script.environment.sh "echo" + "Hello, ${name}. (2)"
    }

    def displaySomeVariables() {
        Script.environment.sh "echo" + "${env.PATH}"
        Script.environment.sh "echo" + "${BUILD_NUMBER}"
        DATETIME_TAG = java.time.ZonedDateTime.now().format(java.time.format.DateTimeFormatter.ISO_INSTANT)
        Script.environment.sh "echo" + "${DATETIME_TAG}"
    }

}
