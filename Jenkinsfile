@Library("jenkins-SL")

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

        stage("build image") {
            steps {
                script {
//                    gv.buildImage()
                   buildImage()
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
