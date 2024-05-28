# 使用官方的Java镜像作为基础镜像
FROM openjdk:17-jdk-alpine

# 设置环境变量，例如时区等
ENV JAVA_OPTS=""

# 将当前目录下的jar包复制到Docker容器中的/opt/app目录下
COPY target/urban-admin-api-0.0.1-SNAPSHOT.jar /opt/app/app.jar

# 允许外部访问8080端口，因为Spring Boot应用默认监听8080端口
EXPOSE 8080

# 运行应用，这里使用Spring Boot的jar启动命令
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /opt/app/app.jar"]