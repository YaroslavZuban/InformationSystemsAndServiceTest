# Тестовое задание на должность Java Backend Разработчика

## Предусловия
- Язык программирования: Java 8
- Frameworks: Spring Boot Starter, Spring Web, Spring JPA, Spring Hibernate
- База данных: PostgreSQL
- Библиотека для генерации документации: springdoc-openapi

## Ход работ
### 1. Реализация реестра техники
Необходимо создать реестр техники с привязкой к ним моделями и характеристиками.

#### 1.1. equipment_type: Хранит информацию о типах техники.

#### 1.2. technic: Содержит информацию о технических устройствах, привязанных к определенному типу техники.

#### 1.3. model: Содержит информацию о моделях каждого технического устройства.

#### 1.4. televisions, vacuum_cleaners, refrigerators, smartphones, computers: Таблицы для конкретных типов техники, содержащие дополнительные атрибуты, специфичные для каждого типа техники.

Имееется скрипт по бд с данными (sql_script.sql)

### 2. Реализация поиска и фильтрации
Реализован поиск по наименованию (независимо от регистра) и фильтрация по виду техники, цвету и цене (от/до). Остальные фильтры зависят от выбора вида техники и фильтруются по атрибутам моделей.

### 3. Реализация сортировки
Реализована сортировка реестра техники по алфавиту и по стоимости.

### 4. Возможность добавления новых позиций и моделей
Реализована возможность добавления новых позиций и моделей в зависимости от выбранного вида техники.

### Ожидаемый результат
REST-приложение с документацией OpenAPI v3 в виде страницы Swagger. Доступ к репозиторию с исходниками приложения. README файл с инструкцией для запуска.

# Инструкция по запуску приложения на Spring

## Требования
### 1. Java Development Kit (JDK) 8 или выше
### 2. PostgreSQL

## Шаги по запуску
### 1. Настройка базы данных:
### 2. Установите PostgreSQL, если он не установлен.
### 3. Создайте базу данных для приложения.
### 4. Измените параметры подключения к базе данных в файле application.properties.

## Сборка проекта:
### 1. Откройте терминал или командную строку.
### 2. Перейдите в корневую директорию проекта.
### 3. Выполните команду mvn clean install для сборки проекта и установки зависимостей.

## Запуск приложения:
### 1. Выполните команду mvn spring-boot:run для запуска приложения

# Примечание
## Убедитесь, что порт 8080 доступен и не используется другими приложениями.
