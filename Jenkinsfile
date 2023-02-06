#!/sur/bin/env groovy
library identifier: 'jenkins-SL@master', retriever: modernSCM(
        [
                $class: 'GitSCMSource',
                remote: 'https://github.com/waynelee08/jenkins-SL.git',
                credentialId: 'github-redential'
        ]
)

def gv

pipeline {

    agent any
    tools {
        maven "maven-3.6"
    }
    
    stages {
        stage("init") {
            steps {
                script {
//                     gv = load "script.groovy"
                    buildJar()
                }
            }
        }

        stage("build jar") {
            steps {
                script {
//                             gv.buildJar()
                    buildImage()
                }
             }
        }

        stage("build and push image") {
            steps {
                script {
//                    gv.buildImage
                   buildImage 'wayneleedevops/demo-app:jma-2.0'
                    dockerLogin()
                    dockerPush 'wayneleedevops/demo-app:jma-2.0'
                }
                    
            }
        }
        
        stage("deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}
