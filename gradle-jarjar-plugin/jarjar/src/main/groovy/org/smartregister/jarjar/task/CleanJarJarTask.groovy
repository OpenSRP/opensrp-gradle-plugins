package org.smartregister.jarjar.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * @author Dmitriy Tarasov
 */
class CleanJarJarTask extends DefaultTask {

    @TaskAction
    def taskAction() {
        project.fileTree(dir: 'build/libs', include: '*.original').each { file ->
            file.delete()
        }
    }

}