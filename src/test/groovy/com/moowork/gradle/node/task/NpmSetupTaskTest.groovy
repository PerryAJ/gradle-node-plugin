package com.moowork.gradle.node.task

import org.gradle.process.ExecSpec

class NpmSetupTaskTest
    extends AbstractNodeTaskTest
{
    def "exec npmSetup task"()
    {
        given:
        this.props.setProperty( 'os.name', 'Linux' )
        this.execSpec = Mock( ExecSpec )

        def task = this.project.tasks.create( 'simple', NpmSetupTask )

        when:
        this.project.evaluate()
        task.exec()

        then:
        task.result.exitValue == 0
        1 * this.execSpec.setArgs( [] )
    }

    def "exec npmSetup task (version specified)"()
    {
        given:
        this.props.setProperty( 'os.name', 'Linux' )
        this.ext.npmVersion = '2.1.6'
        this.execSpec = Mock( ExecSpec )

        this.execSpec = Mock( ExecSpec )
        def task = this.project.tasks.create( 'simple', NpmSetupTask )

        when:
        this.project.evaluate()
        task.exec()

        then:
        task.result.exitValue == 0
        1 * this.execSpec.setArgs( [] )
    }
}
