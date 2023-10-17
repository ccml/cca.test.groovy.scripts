package bet.ccmlits.core

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
