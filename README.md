# cart
[![CircleCI](https://circleci.com/gh/foobaar/cart.svg?style=svg)](https://circleci.com/gh/foobaar/cart)
[![Maintainability](https://api.codeclimate.com/v1/badges/8abe6028d712c236ac3f/maintainability)](https://codeclimate.com/github/foobaar/cart/maintainability)

## Running locally
Set the following env variables:
> MONGO_PASSWORD
> MONGO_USER

To start the app, run the following command:
```./gradlew clean bootRun```

## Healthchecks
```
http://localhost:9200/actuator/health
http://localhost:9200/actuator/info
```

## API docs
API docs are generated with swagger
```
http://localhost:9200/api/swagger-ui.html
```
