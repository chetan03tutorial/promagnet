FROM tomcat:8.5.37-jre8-slim
COPY target/promagnet.war /usr/local/tomcat/webapps
ENV JAVA_TOOL_OPTIONS="-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n"
CMD ["catalina.sh","run"]