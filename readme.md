# Магазин электроники

Этот проект представляет собой RESTful веб-сервис, реализованный на основе Spring Boot, для управления различными продуктами в магазине электроники. Система поддерживает управление продуктами, такими как компьютеры, холодильники, смартфоны, телевизоры и пылесосы. В проекте используются такие технологии, как Hibernate, JPA и Springdoc OpenAPI.

Порт сервера 8080.
Для просмотра разных типов товаров нужно перейти по url:
- http://localhost:8080/api/smartphones
- http://localhost:8080/api/computers
- http://localhost:8080/api/tvs
- http://localhost:8080/api/fridges
- http://localhost:8080/api/vacuum_cleaners

Более подробная документация сгенерирована и представлена на http://127.0.0.1:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/

В файле resources/backup.sql находится dump БД.
Пользователь postgres, пароль postgres, БД store_db.

ProductType - сущность отражающая тип товара.
Product - родительский класс для моделей (классы Smartphone, Fridge, VacuumCleaner, TV, Computer).

