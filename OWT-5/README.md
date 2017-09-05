
# OWT-5: Deploying a Web Application in Karaf

The purpose of this tutorial is to create the following:
1. A single-page web application
2. A mechanism which will consume the service(s) defined in OWT-4, by using jQuery.



karaf.bat clean

feature:install pax-cdi 
install -s wrap:mvn:javax.inject/javax.inject/1

repo-add cxf 3.1.8
feature:install cxf-jaxrs cxf-jackson

bundle:install -s mvn:com.owt5.demo/bundle-lib/1.0.0-SNAPSHOT
bundle:install -s mvn:com.owt5.demo/bundle-api/1.0.0-SNAPSHOT
bundle:install -s mvn:com.owt5.demo/bundle-impl/1.0.0-SNAPSHOT
bundle:install -s mvn:com.owt5.demo/bundle-rest/1.0.0-SNAPSHOT
    
    
feature:install cxf-commands

cxf:list-endpoints

http://localhost:8181/cxf

http://localhost:8181/cxf/api?_wadl

http://localhost:8181/cxf/api/echo


// bundle and ui.. 






chacnge at bundle-ui pom.xml:

   <plugins>
            <plugin>
                <groupId>org.apache.felix</groupId>
                <artifactId>maven-bundle-plugin</artifactId>
                <version>${maven-bundle-plugin.version}</version>
                <extensions>true</extensions>
                <configuration>
                    <instructions>
                        <Web-ContextPath>/</Web-ContextPath>
                        <_wab>src/main/webapp</_wab>
                    </instructions>
                </configuration>
            </plugin>






feature:install war


bundle:install -s mvn:com.owt5.demo/bundle-ui/1.0.0-SNAPSHOT



![](img/installingUIbuindle.png)



by default it uses index.html at:
http://localhost:8181

if there is any other html name page .. it may accessed 
http://localhost:8181/{anyotherhtml}.html



