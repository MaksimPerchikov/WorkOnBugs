# WorkOnBugs

Исправляю саму структуру своего
             итогового проекта(этого - https://github.com/MaksimPerchikov/team8.git).
Так же сам принцип принятия запросов и отдачи ответов.

Искать по пути : WorkOnBugs/UpdateHrHappiness/src/main/java/ru/mysait/

Создание карточки можно проверить по эндпоинту  "/my/create" с Джейсоном

{
    "nameProject": "mynamequ",
    "nameCustomer": "qu",
    "firstType": "Черновик",
    "secondType":"Новый",
    "userName":"Max",
    "surname":"Perchikov",
    "university":"University name of M.I.Lobachevscogo",
    "faculty":"RF"
}

(изменять можно все поля на свои значени,кроме firstType и secondType.
Эти два поля проверяются по базе и у них свои значения.
firstType: "Архив","Черновик", ""В работе"
secondType: "Новый" или "Старый"
)
