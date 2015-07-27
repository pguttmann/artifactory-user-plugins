<h1> remoteDownload User Plugin </h1>

This plugin receives a remote file URL and deploys the file into Artifactory.

<h2> Dependencies </h2>

The plugin requires two third-party dependencies in order to run:

[http-builder](https://jcenter.bintray.com/org/codehaus/groovy/modules/http-builder/http-builder/0.7.2/http-builder-0.7.2.jar)

[json-lib](https://jcenter.bintray.com/net/sf/json-lib/json-lib/2.4/json-lib-2.4-jdk15.jar)

To install the dependencies, create the $ARTIFACTORY_HOME/etc/plugins/lib directory, and place the above two jars in it.

<h2> Logging </h2>

To enable logging for the plugin, add the below logger to your $ARTIFACTORY_HOME/logback.xml:

```xml
<logger name="remoteDownload">
    <level value="info"/>
  </logger>
  ```
  
<h2> Executing & Parameters </h2>

The plugin can be executed with the below command:

`curl -X POST -uadmin:password "http://localhost:8081/artifactory/api/plugins/execute/remoteDownload" -T conf.json`

The content of conf.json should include the below parameters:
```JSON
{
"repo": "libs-release-local",
"path": "my/new/path/docker.png",
"url": "https://d3oypxn00j2a10.cloudfront.net/0.18.0/img/nav/docker-logo-loggedout.png",
"username": "admin",
"password": "password"
}
```

repo - The repository to which the file will be deployed <br>
path - The deployment path within the repository <br>
url - The remote file URL <br>
username - Username for basic authentication for the remote endpoint (Optional) <br>
password - Password for basic authentication for the remote endpoint (Optional) 

The above example deploys the remote file into "libs-release-local:my/new/path/docker.png"
