FROM eclipse-temurin:17-jre-alpine

COPY build/libs/ /opt/app/libs/
COPY docker-entrypoint.sh /opt/app/docker-entrypoint.sh
RUN chmod 764 /opt/app/docker-entrypoint.sh
RUN chmod -R 764 /opt/app/libs
EXPOSE 8080
ENTRYPOINT ["sh", "/opt/app/docker-entrypoint.sh"]