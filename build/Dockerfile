FROM alpine

RUN apk add --no-cache curl
RUN apk add --no-cache git
RUN apk add --no-cache openjdk17-jdk

WORKDIR /outer-space/build-tools
RUN curl -sL -o BuildTools.jar https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar
RUN mkdir out

WORKDIR /outer-space
ENTRYPOINT ["tail", "-f", "/dev/null"]
