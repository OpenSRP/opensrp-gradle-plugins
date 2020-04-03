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
