# Getting Started

### In memory DB
http://localhost:8080/h2-ui/
user: co2level
password: co2levelpassword

### Auth
curl -u username:password

barcelona:barcelona

wien:wien

münchen:münchen

### Create a sensor

curl --location --request POST 'http://localhost:8080/v1/sensor' \
--header 'Authorization: Basic YmFyY2Vsb25hOmJhcmNlbG9uYQ==' \
--header 'Content-Type: application/json' \
--data-raw '{
"sensorId": "1",
"cityDistrictId": "1"
}'

### Create a reading

curl --location --request POST 'http://localhost:8080/v1/reading' \
--header 'Authorization: Basic YmFyY2Vsb25hOmJhcmNlbG9uYQ==' \
--header 'Content-Type: application/json' \
--data-raw '{
"readingValue": 12.35,
"time": "2021-11-23T21:03:17",
"sensorId": 1
}'

### Get Sensor readings

curl --location --request GET 'http://localhost:8080/v1/sensor/1' \
--header 'Authorization: Basic YmFyY2Vsb25hOmJhcmNlbG9uYQ==' \
--header 'Cookie: JSESSIONID=F20157FE8709FFD508170C2EF0268C36'

