def localDir = '/var/lib/jenkins' // Set your local directory path here

// Check if the directory exists
def repoExists = new File(localDir).exists()

//def runPipeline() {
    //if (repoExists) {
        //println "Repository exists at ${localDir}. Performing a git pull..."
        // Execute git pull
        //def processPull = "git -C ${localDir} pull".execute()
        //processPull.waitFor()
        //println processPull.text
    //} //else {
        //println "Repository does not exist at ${localDir}. Cloning from ${repoUrl}..."
        // Execute git clone
        //def processClone = "git clone ${repoUrl} ${localDir}".execute()
        //processClone.waitFor()
        //println processClone.text
    //}
//}


def call() {
    
  pipeline {
     agent any

    tools {
        maven "maven1" // You need to add a maven with name "3.6.0" in the Global Tools Configuration page
    }

    stages {
        stage("Build") {
            steps {
                
              dir('/var/lib/jenkins/workspace/test'){
                 // if (repoExists){
                      // Performing git pull
                   //   def processPull = "git -C ${localDir} pull".execute()
                     // processPull.waitFor()
                     // println processPull.text
                  //}
                  //else{
                  //performing git clone
                    //  def processClone = "git clone ${repoUrl} ${localDir}".execute()
                     // processClone.waitFor()
                      //println processClone.text
                  //}
                sh "git clone https://github.com/MohnishBhonde/SNSImplemen"
                
               
                
              }
                
            }
         }
        stage("mvn install"){
            steps{
                 dir('/var/lib/jenkins/workspace/test'){
                  sh "mvn -version"
                  sh "mvn clean install"
                 }
            }
        }
        
            stage("mvn package"){
                steps{
                    dir('/var/lib/jenkins/workspace/test'){
                    sh "mvn package"
                    }
                }
            }
    }
  }
    }
      
