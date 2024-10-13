def localDir = '/var/lib/jenkins' // Set your local directory path here

// Check if the directory exists
def repoExists = new File(localDir).exists()

def runPipeline() {
    if (repoExists) {
        println "Repository exists at ${localDir}. Performing a git pull..."
        // Execute git pull
        def processPull = "git -C ${localDir} pull".execute()
        processPull.waitFor()
        println processPull.text
    } else {
        println "Repository does not exist at ${localDir}. Cloning from ${repoUrl}..."
        // Execute git clone
        def processClone = "git clone ${repoUrl} ${localDir}".execute()
        processClone.waitFor()
        println processClone.text
    }
}
