# GrapnQL_Research

Проект предназначен для изучения работы **GraphQL** на практике с использованием **Spring Boot**.  
Здесь показаны основные концепции GraphQL, интеграция с базой данных, работа с запросами, мутациями и подписками.

---

## Структура проекта

- **Entities** – JPA-сущности для пользователей, постов и комментариев.
- **Repositories** – интерфейсы для работы с базой данных через Spring Data JPA.
- **Services** – бизнес-логика приложения.
- **Controllers** – GraphQL-контроллеры с методами `@QueryMapping`, `@MutationMapping`, `@SubscriptionMapping`.
- **GraphQL Schema** – описание типов, скаляров, enums, интерфейсов, input types, queries, mutations и subscriptions.
- **Config** – настройки GraphQL и DataFetcherExceptionResolver для обработки ошибок.
- **application.yml** – настройки Spring Boot, базы данных H2 и GraphiQL.

---

## Основные возможности

1. **GraphQL Queries**
    - Получение пользователей (`users`) с фильтрацией, сортировкой и пагинацией.
    - Получение конкретного пользователя по `id` (`user`).

2. **GraphQL Mutations**
    - Создание нового пользователя (`createUser`).

3. **GraphQL Subscriptions**
    - Подписка на создание нового пользователя (`newUser`).

4. **Custom Scalars**
    - `UUID` и `DateTime` для работы с уникальными идентификаторами и временными метками.

5. **Enums и Interfaces**
    - Роли пользователя (`Role`).
    - Интерфейс `Node` для общих полей сущностей (`id`, `createdAt`).

6. **Error Handling**
    - Настройка `DataFetcherExceptionResolver` для кастомной обработки ошибок.
    - Пример: `UserNotFoundException` возвращает `GraphQLError` с `NOT_FOUND`.

7. **Spring Boot + H2**
    - Встроенная база данных H2 для быстрого тестирования.
    - Консоль H2 доступна по пути `/h2-console`.

8. **GraphiQL**
    - Интерактивный UI для тестирования GraphQL-запросов и мутаций.

---

## Примеры использования

### Запрос пользователей с фильтрацией
```graphql
query($limit: Int, $offset: Int) {
  users(filter: {limit: $limit, offset: $offset}) {
    id
    name
    email
    role
  }
}
```

### Мутация создания пользователя
```graphql
mutation {
  createUser(input: {name: "Alice", email: "alice@example.com", role: USER}) {
    id
    name
    email
    role
  }
}
```

### Подписка на нового пользователя
```graphql
subscription {
  newUser {
    id
    name
    email
    role
  }
}
```

---

## Настройка и запуск

1. Клонировать репозиторий:
```bash
git clone https://github.com/Oleborn/GrapnQL_Research.git
```

2. Запустить проект через Maven:
```bash
mvn spring-boot:run
```

3. Перейти в GraphiQL:
```
http://localhost:8080/graphiql
```

4. Использовать H2-консоль для просмотра данных:
```
http://localhost:8080/h2-console
```

---

@Oleborn