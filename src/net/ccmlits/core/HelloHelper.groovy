package bet.ccmlits.core

/** A map that holds all constants and data members that can be override when constructing  */
helloHelperEnv

/**
 * Imitates a constructor
 * Defines an instance of HelloHelper object. All according to api
 * @param hiWord - word that say hello
 * @param helloSentenceEnd - end of the hello sentence
 * @return
 */
def construct(String hiWord, String helloSentenceEnd){

    helloHelperEnv = [
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
        echo "${helloHelperEnv.hiWord}, ${helloHelperEnv.defaultName} ${helloHelperEnv.helloSentenceEnd}"
    } else {
        echo "${helloHelperEnv.hiWord}, ${name} ${helloHelperEnv.helloSentenceEnd}"
    }
}

def sayHello1FromClass(name) {
  sayHello2FromClass("${name} (1)")
}

def sayHello2FromClass(name) {
  echo "Hello, ${name}. (2)"
}

def displaySomeVariables() {
  echo "${env.PATH}"
  echo "${BUILD_NUMBER}"
  DATETIME_TAG = java.time.ZonedDateTime.now().format(java.time.format.DateTimeFormatter.ISO_INSTANT)
  echo "${DATETIME_TAG}"
}
