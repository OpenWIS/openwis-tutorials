## OWT-7 Code


### Requirements
1. Java 8
2. Maven 3

### Build Instructions

1. Navigate to the 'bundle-parent' directory
2. Execute :
```
# First time
    mvn clean install 

# normally
    mvn clean install -Dskip.npm.deps=true

```

### Deploy Instructions
```
karaf.bat clean


 feature:install pax-cdi 
 install -s wrap:mvn:javax.inject/javax.inject/1


 repo-add cxf 3.1.8 
 feature:install cxf-jaxrs cxf-jackson 

feature:install war

## JPA related:

feature:install jpa transaction jndi jdbc pax-jdbc pax-jdbc-pool-dbcp2 pax-jdbc-config hibernate

feature:install pax-jdbc-h2


config:edit org.ops4j.datasource-OWT7;  
config:property-set osgi.jdbc.driver.name H2;
config:property-set databaseName test;
config:property-set user sa;
config:property-set dataSourceName owt7-ds;
config:update 





bundle:install -s mvn:com.owt7.demo/bundle-lib/1.0.0-SNAPSHOT
bundle:install -s mvn:com.owt7.demo/bundle-api/1.0.0-SNAPSHOT
bundle:install -s mvn:com.owt7.demo/bundle-impl/1.0.0-SNAPSHOT
bundle:install -s mvn:com.owt7.demo/bundle-rest/1.0.0-SNAPSHOT
bundle:install -s mvn:com.owt7.demo/bundle-ui/1.0.0-SNAPSHOT
bundle:install -s mvn:com.owt7.demo/bundle-db/1.0.0-SNAPSHOT



# check db
 jdbc:query owt7-ds SHOW TABLES

 jdbc:query owt7-ds select * from messagechat


feature:install cxf-commands


cxf:list-busses 

cxf:list-endpoints 


```
