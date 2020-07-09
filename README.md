# opensrp-gradle-plugins
Opensrp Gradle Plugins Respository

This repository contains useful gradle plugins relevant to OpenSRP Android clients.


## Android release signing plugin

This plugin configures your Android project with release signing credentials which allows signing a release apk from the command-line.

To use the plugin, configure your app as follows:

```$xslt
buildscript {

    repositories {
        maven { url 'https://oss.sonatype.org/content/repositories/snapshots/' }
    }
    
    dependencies {
        classpath 'org.smartregister.plugin.gradle:android-release-signing-plugin:1.0-SNAPSHOT'
    }
}

apply plugin: 'org.smartregister.plugin.gradle.android-release-signing-plugin'
```

NOTE: This plugin assumes that your Android project has its release keystore uploaded to Travis CI as `android_release.keystore` and the `keystore_password`, `keystore_alias` and `keystore_alias_password` are all set as environment variables in Travis CI.



Gradle JarJar Repackage Plugin
==============================

Plugin for gradle which allows you to repackage jar-libraries with different package names using [JarJar][1] tool.

In Android development there are some situations when library packaged inside your *.apk-file already exists on the device firmware.
In such case java class loader prefer device's library version instead of your own packaged inside an *.apk.
If you using newest version of library than that that exists on a device you can stuck in a trouble.
Your newest library version can have changed signatures which can cause a runtime exception.

For example on some HTC devices there are pre-installed GSON library for sereializing/desereializing to/from JSON.
And if you use newest GSON version in your own project you'll get runtime errors with this.

Installation
------------

```groovy
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'org.smartregister:gradle-jarjar-plugin:1.0.0-SNAPSHOT'
    }
}

apply plugin: 'org.smartregister.gradle.jarjar'

dependencies {
    // Which artifacts should be repackaged
    jarJar 'com.google.code.gson:gson:2.3'

    // Repackaged jars will be placed here, adding them to classpath
    implementation fileTree(dir: './build/libs', include: ['*.jar'])
}

jarJar {

    // Dependencies and related JarJar rules
    rules  = ['gson-2.3.jar': 'com.google.gson.** ru.tinkoff.core.gson.@1']
    remove = ['gson-2.3.jar': 'com.google.gson.GsonBuilder*']
}

```
