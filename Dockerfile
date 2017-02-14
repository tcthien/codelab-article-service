FROM java:8-jre
MAINTAINER Thien Tran <thientran1986@gmail.com>


ADD ./target/codelab-article-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/codelab-article-service.jar"]

EXPOSE 20083
