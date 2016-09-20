FROM java:8

MAINTAINER mbasri<basrimohamed@live.fr>

#RUN apt-get update

ADD *.jar /etc/synapsis/synapsis-cv/synapsis-cv.jar
ADD docker/run.sh /etc/synapsis/synapsis-cv/run.sh

RUN chmod +x /etc/synapsis/synapsis-cv/synapsis-cv.jar
RUN chmod +x /etc/synapsis/synapsis-cv/run.sh

ENV USER_DB_SYNAPSIS="${USER_DB_SYNAPSIS}"
ENV PASSWORD_DB_SYNAPSIS="${PASSWORD_DB_SYNAPSIS}"

EXPOSE 8080

ENTRYPOINT ["bash","run.sh"]

WORKDIR /etc/synapsis/synapsis-cv