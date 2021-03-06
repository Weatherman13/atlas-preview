#  Atlas Telegram Bot 

![bandicam 2022-05-10 17-03-30-362](https://user-images.githubusercontent.com/82045585/167647629-f8785efc-f46c-4b8c-b83d-068a1ee16a71.jpg)


Можете опробовать актуальную версию в телеграмм https://t.me/atlas_syndicate_bot 
## Краткое описание
Приложение представляет собой телеграмм бота, который предоставляет след. данные:
- Актуальную информацию о рынке криптовалют (топ 15 валют по капитализации, индекс страха и жадности)
- Поиск актуальной информации об определённой криптовалюте (high, low, marketcap, rate и т.д.)
- Позволяет конвертировать криптовалюту в рубли или доллары и наоборот, по актуальному курсу.

Также бот поддерживает 2 языка:

- RU
- EN

Телеграм бот состоит из 3 микросервисов:

### ATLAS BOT

- ### Описание:

Сервис реализующий телеграм бота со своей бизнес логикой.

### EUREKA

- ### Описание:

Spring cloud сервис, реализующий паттерн Service Discovery для облегчения общения между двумя сервисами и возможностью быстро и безболезненно подключить новый.
### CRYPTOHOUSE

- ### Описание:

Небольшой сервис, подтягивающий данные из разных источников по REST API. Из него телеграм бот подтягивает нужные данные. (В previw версии всего 1 биржа, в полной уже 8, ещё добавляются подключение по GRPS. Также сделан рефакторинг сервисов)

## Стек технологий:
- Java 11
- Spring(Boot,Data,Web,Cloud(Eureka))
- Lombok
- БД MySql
- MupStruct
- Swagger
- Docker
- Telegrambots (библиотека для Telegram Api https://github.com/rubenlagus/TelegramBots)

## Сборка проекта:
Перед началом вам необходимо получить токен у Bot Father в телеграмм https://core.telegram.org/api

Далее в классе src/main/java/ru/thirteenth/atlas/CryptoBotConfig/CryptoBot.java меняете BOT_TOKEN и BOT_USERNAME на свои данные.

Далее:
```sh
$ cd atlas
$ mvn spring-boot:build-image
$ cd ..
$ cd crypto-house
$ mvn spring-boot:build-image
$ cd ..
$ cd eureka
$ mvn spring-boot:build-image
$ cd ..
$ docker-compose up --build
```

## Docker:

### В docker-compose есть всё необходимое для мониторинга бота:
- 8089 порт : консоль для управления базой данных (данные из базы перемещены с помощью маппинга томов на хост докера, так что они не пропадают после перезагрузки)




