## OWT-3 Code


### Requirements
1. Java 8
2. Maven 3

### Build Instructions

1. Navigate to the 'bundle-parent' directory
2. Execute :
```
    mvn clean install
```

### Deploy Instructions
```
karaf.bat clean


 feature:install pax-cdi 
 install -s wrap:mvn:javax.inject/javax.inject/1


 repo-add cxf 3.1.8 
 feature:install cxf-jaxrs cxf-jackson 

bundle:install -s mvn:com.owt4.demo/bundle-lib/1.0.0-SNAPSHOT
bundle:install -s mvn:com.owt4.demo/bundle-api/1.0.0-SNAPSHOT
bundle:install -s mvn:com.owt4.demo/bundle-impl/1.0.0-SNAPSHOT
bundle:install -s mvn:com.owt4.demo/bundle-rest/1.0.0-SNAPSHOT



feature:install cxf-commands


cxf:list-busses 

cxf:list-endpoints 


```
