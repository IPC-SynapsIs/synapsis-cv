FROM java:8

MAINTAINER mbasri<basrimohamed@live.fr>

#RUN apt-get update

ADD build/libs/*.jar /etc/synapsis/synapsis-cv/synapsis-cv.jar
ADD src/main/resources/docker/run.sh /etc/synapsis/synapsis-cv/run.sh

RUN chmod +x /etc/synapsis/synapsis-cv/synapsis-cv.jar
RUN chmod +x /etc/synapsis/synapsis-cv/run.sh

EXPOSE 8080

ENTRYPOINT ["bash","run.sh"]

WORKDIR /etc/synapsis/synapsis-cv