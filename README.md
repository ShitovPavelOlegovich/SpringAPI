Weather Sensor Repository
----------------
Данный репозиторий содержит Spring REST API приложение, моделирующее метеорологический датчик, 
который измеряет температуру окружающего воздуха и определяет, идет ли дождь. 
В качестве сенсора используется наш собственный компьютер. Работа происходит с JSON.

Технологии
------------------
Для написания данного приложения используется следующий стек технологий:

- Spring Boot
- Spring Web
- RestTemplate
- Spring Validator

REST API
-------
Приложение предоставляет следующие REST API эндпоинты:

- POST /sensors/registration - Регистрирует новый сенсор в системе.
- POST /measurements/add - Добавляет новое измерение.
- GET /measurements - Возвращает все измерения из БД.
- GET /measurements/rainyDaysCount - Возвращает количество дождливых дней из БД.

Отказ от ответственности
----------------------------
Обратите внимание, что это приложение предназначено только для демонстрационных целей, 
и смоделированные значения датчиков могут неточно отражать реальные условия.

Не стесняйтесь использовать и изменять этот код для своих собственных проектов. 
Если у вас есть какие-либо вопросы или предложения, пожалуйста, свяжитесь со мной по адресу [https://t.me/Pavel_Oleg]. 
Спасибо, что заглянули в этот репозиторий! 🌦️🌡️

Приятного кодирования! 🚀
