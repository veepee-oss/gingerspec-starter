/**
 * ****************************************************************************************************
 * PIPELINE SCRIPT FOR AUTOMATION PROJECTS
 * ****************************************************************************************************
 *
 * This pipeline groovy file is inherited by all automation projects. In jenkins job, the
 * following parameters must be configured and assigned a proper value for this script to run properly
 *
 * SELENIUM_NODE: Indicates the job that it will be necessary to create a new selenium node for the job.
 * This node will be created in a docker container with a random generated UID (stored in BROWSER_NAME)
 * and will connect to the specified selenium instance. You can later force your selenium tests to use
 * this node using -DFORCE_BROWSER=BROWSER_TYPE_browser_name.
 *
 * BROWSER_TYPE: Type of the selenium node that will be created for the job, Currently, it only supports
 * "chrome"
 *
 * BRANCH: Branch of the repository to build. This branch should contain a version of this groovy file
 * to work
 *
 * SELENIUM_GRID_HOST: Host where the selenium grid instance is running
 *
 * SELENIUM_GRID_PORT: Port  of the selenium grid instance that is listening for requests of the nodes
 *
 * *****************************************************************************************************
 */

/**Default maven image*/
def image_maven = docker.image("spdc1k8sregistry11.privalia.pin/privalia-qa-worker:0.1.0")

/**Function to get the url of the jenkins server*/
def jenkins_ip = InetAddress.localHost.canonicalHostName

/**Random UID for the selenium node name*/
def BROWSER_NAME = UUID.randomUUID().toString()

/**Global variable to store the selected browser*/
def image_browser

/**Global variable to store the valid open port*/
def open_port

/** Initial set of staments to execute in the job*/
statementArray = ["EXIT_STATUS=0", "mvn clean || EXIT_STATUS=\$?", "exit \$EXIT_STATUS"]

/** **************************************************************************************************/
/** Function to get an aleatory open port. This will be necessary when starting the Selenium node
 to avoid collisions if several tests are executed in parallel */
while (!open_port) {
    try {
        Random random = new Random()
        def PORT = random.nextInt(9999)
        PORT = PORT + 50000
        new ServerSocket(PORT).close();
        open_port = PORT
    } catch (IOException e) {
        println e
    }
}
/** **************************************************************************************************/

/** **************************************************************************************************/
/** This functions build the final statement to be executed in the maven container*/
def addStamenet(String stament) {
    statementArray.add(statementArray.size() - 1, stament + " || EXIT_STATUS=\$?")
}
/** **************************************************************************************************/


node('master') {

    echo 'Starting the build phase'

    stage("Build") {

        /** Specify the correct URL of the repository*/
        git branch: '${BRANCH}', credentialsId: 'devops_automation_ssh_key', url: 'git@gitlab.privalia.pin:qa-automation/pilot-project.git'

        /** Create new selenium docker of type specified and with aleatory UID and port */
        if ("${SELENIUM_NODE}" == "allocate new node") {

            if ("${BROWSER_TYPE}" == "chrome") {
                image_browser = docker.image("spdc1k8sregistry11.privalia.pin/privalia-selenium-chrome:62")
            }

            image_browser.pull()
            echo "Starting Selenium node in available port: " + open_port
            containerService = image_browser.run(" -p " + open_port + ":" + open_port + " --dns 192.168.1.1 --dns 172.16.215.110 --dns 172.16.214.1 --dns 172.16.214.2 -e ID=${BROWSER_NAME} -e SELENIUM_GRID=${SELENIUM_GRID_HOST}:${SELENIUM_GRID_PORT} -e HUB_PORT_4444_TCP_ADDR=${SELENIUM_GRID_HOST} -e HUB_PORT_4444_TCP_PORT=${SELENIUM_GRID_PORT} -e SE_OPTS=\"-host " + jenkins_ip + " -port " + open_port + "\" -e NODE_PORT=" + open_port)
        }

        /** Specify the commands to be executed by the docker maven image
         *
         * You can make use of the available variables in your commands
         * SELENIUM_GRID_HOST (Stores the URL of the selenium grid instance)
         * SELENIUM_GRID_PORT (Stores the port of the selenium grid instance)
         * BROWSER_TYPE (Stores the browser type i.e. "chrome")
         * BROWSER_NAME (Stores the randomly generated browser name)
         * */
        this.addStamenet("mvn verify -Dit.test=com.privalia.${artifactId}.${package}.CucumberRestIT")
        this.addStamenet("mvn verify -Dit.test=com.privalia.${artifactId}.${package}.CucumberSeleniumIT -DSELENIUM_GRID=${SELENIUM_GRID_HOST}:${SELENIUM_GRID_PORT} -DFORCE_BROWSER=${BROWSER_TYPE}_${BROWSER_NAME}")

        image_maven.pull()

        try {
            ansiColor('xterm') {
                image_maven.inside("-v m2-cache:/home/jenkins/.m2") {
                    sh statementArray.join("\n")
                }
            }

        } finally {

            /** Terminate the selenium node docker */
            if ("${SELENIUM_NODE}" == "allocate new node") {
                containerService.stop()
            }

            /** Publish the generated cucumber reports */
            cucumber 'target/*.json'

        }
    }
}
