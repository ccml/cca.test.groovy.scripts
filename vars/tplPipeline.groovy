def call(Map config) {
    def helloHelper = new net.ccmlits.core.HelloHelper()
    helloHelper.construct('Hello', '.')

    def helloHelperClaude = new net.ccmlits.core.HelloHelper()
    helloHelperClaude.construct('Hi', ' !!!')

    def helloHelperMarc = new net.ccmlits.core.HelloHelper()
    helloHelperMarc.construct('Ciao', '...')

    pipeline {
        agent any
        environment {
            CI = 'true'
        }
        parameters {
            booleanParam(name: 'executeTest', defaultValue: true, description: '')
        }
        stages {
            stage ('before') {
                steps {
                    script {
                        config.beforeHook()
                    }
                }
            }
            stage('some stage'){
                steps {
                    script {
                        helloHelper.sayHello1FromClass('Claude')
                        helloHelper.sayHello2FromClass('Claude')
                        helloHelper.displaySomeVariables()
                        
                        helloHelperClaude.sayHelloSentence()
                        helloHelperMarc.sayHelloSentence()
                        helloHelperClaude.changeDefaultName('Claude')
                        helloHelperMarc.changeDefaultName('Marc')
                        helloHelperClaude.sayHelloSentence()
                        helloHelperMarc.sayHelloSentence()
                        helloHelperClaude.sayHelloSentence('Edualc')
                        helloHelperMarc.sayHelloSentence('Cram')
                    }
                }
            }
            stage ('after') {
                when {
                    expression {
                      config.afterHook != 'none'
                    }
                }
                steps {
                    script {
                        config.afterHook()
                    }
                }
            }            
        }
    }
}
