FROM java:8
EXPOSE 8282
ADD /target/abonnement-1.0.jar abonnement-micro.jar
ENTRYPOINT ["java","-jar","abonnement-micro.jar"]