import static org.jfrog.artifactory.client.ArtifactoryClient.create
import spock.lang.Specification

class RemoteDownloadTest extends Specification {
    def 'example remote download plugin test'() {
        setup:
        def artifactory = create("http://localhost:8088/artifactory", "admin", "password")

        when:
        "curl -X POST -uadmin:password -T ./src/test/groovy/remoteDownloadTest/conf.json http://localhost:8088/artifactory/api/plugins/execute/remoteDownload".execute().waitFor()

        then:
        artifactory.repository('libs-release-local').file('my/new/path/docker.png').info()

        cleanup:
        artifactory.repository('libs-release-local').delete('my')
    }
}
