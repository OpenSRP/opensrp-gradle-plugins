package org.smartregister.jarjar

/**
 * @author Dmitriy Tarasov
 */
class JarJarPluginExtension {

    String jarJarDependency = 'com.googlecode.jarjar:jarjar:1.3'

    Map<String, String> rules = [:]

    Map<String, String> remove = [:]

}