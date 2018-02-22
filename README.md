Automation archetype
=============================

A maven archetype for creating new automation projects.

When creating new automation projects that make use of the bdt-lib library (http://gitlab.privalia.pin/qa-automation/bdt-lib), you can use this maven archetype to rapidly bootstrap a simple project layout, with all dependencies pre-configured and ready to use. The layout also provides code examples on how to use the library, making it easy to create your own tests

This archetype makes use of **maven-archetype-archetype**, a maven archetype for creating archetypes
``` bash
$ mvn archetype:generate -B -DarchetypeArtifactId=maven-archetype-archetype -DgroupId=com.privalia -DartifactId=automation-archetype -Dpackage=package
```

# How to use this maven archetype

## Using this archetype

Before you can create projects using this archetype, you will have to modify your settins.xml file in ~/.m2/ in order to indicate maven where to look for this archetype. 

Copy the following configuration in your settings.xml file (~/.m2/settings.xml)

    <?xml version="1.0" encoding="UTF-8"?>
    <settings xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.1.0 http://maven.apache.org/xsd/settings-1.1.0.xsd" xmlns="http://maven.apache.org/SETTINGS/1.1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
        <profiles>
            <profile>
                <repositories>
                    <repository>
                        <snapshots>
                            <enabled>false</enabled>
                        </snapshots>
                        <id>releases</id>
                        <name>libs-release</name>
                        <url>http://artifactory.mkp.privalia.pin/artifactory/privalia-maven2</url>
                    </repository>
                    <repository>
                        <snapshots/>
                        <id>snapshots</id>
                        <name>libs-snapshot</name>
                        <url>http://artifactory.mkp.privalia.pin/artifactory/privalia-maven2</url>
                    </repository>
                </repositories>
                <id>artifactory</id>
            </profile>
        </profiles>
        <activeProfiles>
            <activeProfile>artifactory</activeProfile>
        </activeProfiles>
    </settings>



Now, you can execute from your computer:

    $ mvn -U archetype:generate -DarchetypeGroupId=com.privalia -DarchetypeArtifactId=automation-archetype -DarchetypeVersion=0.0.1-SNAPSHOT


About the version number

In this example, we are using the version 0.0.1-SNAPSHOT, but you can take a look in

http://artifactory.mkp.privalia.pin/artifactory/privalia-maven2/com/privalia/automation-archetype/

To check all the different versions. Using -DarchetypeVersion=LATEST will automatically download the lastest snapshopt, or you can also use -DarchetypeVersion=RELEASE


Follow the on-screen instructions and provide the properties **artifactId**, **groupId** , **version** and  **package**


## Using this archetype locally (optional)

If for any reason you are unable to access this archetype using the internal privalia's artifactory (or you want to make changes to this archetype configuration), you can download the project and build it in your local machine:

    Currently, the versioning of artifacts is being handled directly by the pipeline, so you will find a generic <version>##VERSION##</version> tag in the project's pom file. If you are going to make tests locally, you can change this value by a more apropiate version number. For this example, lets say 1.0-SNAPSHOT. The pipeline will require this tag in the pom file of the master branch when generating SNAPSHOTS or RELEASES, so remember to return it to ##VERSION##

``` bash
$ git clone git@gitlab.privalia.pin:som-qa/automation-archetype.git
$ cd automation-archetype
$ mvn install
$ mvn archetype:update-local-catalog
$ mvn archetype:crawl
```
This will update the local archetype repository (~/.m2/repository/archetype-catalog.xml) with this new archetype. You can now execute the following command

    $ mvn archetype:generate -DarchetypeCatalog=local -DarchetypeGroupId=com.privalia -DarchetypeArtifactId=automation-archetype -DarchetypeVersion=1.0-SNAPSHOT

Follow the on-screen instructions and provide the properties **artifactId**, **groupId** , **version** and  **package**


## Consideration when modifying this archetype

The basic project structure is located under:

> src/main/resources/archetype-resources

And the file located at 

> META-INF/maven/archetype-metadata.xml

Indicates what files are to be included in the archetype. If a file is not included, it will not be present in the final project structure when a user generates a project using this artifact, so, make sure to updated if you make any changes in the project tree structure

All projects that make use of this archetype will inherit the same project structure, and the properties 
**artifactId**, **groupId** , **version** and  **package** specified during the project creation will be used in the corresponding places inside the code to change directory/package names, dependencies in classes, pom settings, etc

The properties are used in the same way:
   

     __property__ -> used in folders and file names
      $property   -> Used within files (the from ${property} can also be used)


For example, using 

 - groupId=com.privalia 
 - artifactId=myproject  
 - version=1.0-SNAPSHOT
 - package=mypackage

pom.xml

      <groupId>${groupId}</groupId>
      <artifactId>${artifactId}</artifactId>
      <version>${version}</version>
      <packaging>jar</packaging>

  
Properties are changed in the specified places

      <groupId>com.privalia</groupId>
      <artifactId>myproject</artifactId>
      <version>1.0-SNAPSHOT</version>
      <packaging>jar</packaging>


Directories/packages names are changed accordingly, from this:

    │           │           │   └── com
    │           │           │       └── privalia
    │           │           │           ├── __artifactId__
    │           │           │           │   ├── __package__
    │           │           │           │   │   ├── CucumberBackendIT.java
    │           │           │           │   │   ├── CucumberRestIT.java
    │           │           │           │   │   └── CucumberSeleniumIT.java
    │           │           │           │   └── specs
    │           │           │           │       └── CustomStepsDefinition.java

To this

        ├── com
        │   └── privalia
        │       ├── myproject
        │       │   ├── mypackage
        │       │   │   ├── CucumberBackendIT.class
        │       │   │   ├── CucumberRestIT.class
        │       │   │   └── CucumberSeleniumIT.class
        │       │   └── specs
        │       │       └── CustomStepsDefinition.class

 