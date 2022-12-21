FROM openjdk:17

WORKDIR /usr/share/app
#Copy tất cả các file trong folder project vào trong /usr/share/app
COPY . .
#Câu lệnh trên sẽ tương đương
#COPY ./usr/share/app

#Boot spring aplication
CMD ./mvnw spring-boot:run

# mở post 8080
EXPOSE 8080
