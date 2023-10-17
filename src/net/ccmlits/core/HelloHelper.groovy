package bet.ccmlits.core

def sayHello1FromClass(name) {
  sayHello2FromClass("${name} (1)")
}

def sayHello2FromClass(name) {
  echo "Hello, ${name}. (2)"
}
