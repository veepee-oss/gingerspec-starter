GingerSpec starter
=============================

[![Build Status](https://travis-ci.com/PrivaliaTech/gingerspec-starter.svg)](https://travis-ci.org/PrivaliaTech/gingerspec-starter)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.privaliatech/gingerspec-starter/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.privaliatech/gingerspec-starter)


A maven archetype for creating new automation projects.

When creating new automation projects that make use of the gingerspec library (https://github.com/PrivaliaTech/gingerspec), you can use this maven archetype to rapidly bootstrap a simple project layout, with all dependencies pre-configured and ready to use. The layout also provides code examples on how to use the library, making it easy to create your own tests

This archetype makes use of **maven-archetype-archetype**, a maven archetype for creating archetypes
``` bash
$ mvn archetype:generate -B -DarchetypeArtifactId=maven-archetype-archetype -DgroupId=com.github.privaliatech -DartifactId=gingerspec-starter -Dpackage=package
```

# How to use this maven archetype

## Using this archetype

To bootstrap a new template, execute the following command in your terminal:

    $ mvn -U archetype:generate -DarchetypeGroupId=com.github.privaliatech -DarchetypeArtifactId=gingerspec-starter


> About the version number: <br>
> you can also use -DarchetypeVersion=RELEASE to pull an specific release number


Follow the on-screen instructions and provide the properties **artifactId**, **groupId** , **version** and  **package**


## Using this archetype locally (optional)

If for any reason you are unable to access this archetype (or you want to make changes to this archetype configuration), you can download the project and build it in your local machine:

``` bash
$ git clone git@github.com:PrivaliaTech/gingerspec-starter.git
$ cd automation-archetype
$ mvn install
$ mvn archetype:update-local-catalog
$ mvn archetype:crawl
```
This will update the local archetype repository (~/.m2/repository/archetype-catalog.xml) with this new archetype. You can now execute the following command

    $ mvn archetype:generate -DarchetypeCatalog=local -DarchetypeGroupId=com.github.privaliatech -DarchetypeArtifactId=gingerspec-starter -DarchetypeVersion=1.0-SNAPSHOT

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

``` bash
└── __groupId__
    └── __artifactId__
        ├── __package__
        │   ├── CucumberBackendIT.java
        │   ├── CucumberRestIT.java
        │   └── CucumberSeleniumIT.java
        ├── specs
        │   └── CustomStepsDefinition.java
        └── utils
            ├── BaseTest.java
            └── CukesHooks.java
``` 



To this

``` bash
└── com.privalia
    └── myproject
        ├── mypackage
        │   ├── CucumberBackendIT.java
        │   ├── CucumberRestIT.java
        │   └── CucumberSeleniumIT.java
        ├── specs
        │   └── CustomStepsDefinition.java
        └── utils
            ├── BaseTest.java
            └── CukesHooks.java
 ``` 
 
 
 ## Contributing Members to GingerSpec starter
 
 **QA Team Lead: [Oleksandr Tarasyuk](https://github.com/alejandro2003) (@oleksandr.tarasyuk)**
 
 #### Other Members:
 
 |Name     |  Slack Handle   | 
 |---------|-----------------|
 |[Jose Fernandez Duque](https://github.com/josefd8)| @josefd8        |
 