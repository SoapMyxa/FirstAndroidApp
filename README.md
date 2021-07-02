# FirstAndroidApp

## Обоснование выбора БД 

Изменения по БД еще не внесены

Преимущества Room
1. Честный SQL, реляционная база. (привык с ними работать) Возможность написать сложный запрос при необходимости (например, отобразить какую-нибудь статистику, типа сколько слов в среднем в день переводит пользователь итп. С нормальными SQL запросами это сделать легче, чем через методы realm)
2. Легковесность (200 кб против 2мб realm)
3. Расширяемость (пишут, что Realm со временем становится тяжело сопровождаемым http://orion-int.ru/bystryj-prostoj-slozhnyj-kak-my-vypilili-realm/)
4. Поддержка русских символов в where запросах. Realm не поддерживает (https://docs.mongodb.com/realm/sdk/android/fundamentals/query-engine/), для данного приложения это может стать проблемой, если сделать поиск по словарю переведенных слов.
5. Insertы быстрее, чем в Realm (https://dzone.com/articles/how-realm-is-better-as-compared-to-sqlite). В данном приложении инсерты будут производиться гораздо чаще, чем чтения

Преимущества Realm
1. Работает быстрее SQLite (https://dzone.com/articles/how-realm-is-better-as-compared-to-sqlite)
2. Более "нативный" для Java, т.к. предметная область в БД разделена на объекты
3. Realm больше подходит для небольших (как это) приложений (https://medium.com/bitrise/realm-vs-sqlite-which-database-is-better-for-android-apps-c751dc8b150c), где не требуются все возможности реляционной БД 
4. Не создает копию БД во время работы, данные вносятся непосредственно в хранилище

Обе БД переносимы, что теоретически позволяет синхронизировать данные между устройствами одного пользователя.

Сделаю выбор в пользу Realm, т.к.
1. С реляционными БД работаю каждый день, с No-SQL не работал никогда, хочу научиться.
2. Судя по всему, SQLite (room) в данном приложении будет излишним, для функционала достаточно Realm 
3. Полагаю, что на таком маленьком объеме данных более высокая производительность Insertов в SQLite никак не скажется на работе приложения, следовательно этим недостатком Realm можно пренебречь.

## Запросы к апи Reqres
Логи
https://github.com/SoapMyxa/FirstAndroidApp/blob/master/app/sampledata/Reqres%20logs.txt

Активити
![alt text](https://github.com/SoapMyxa/FirstAndroidApp/blob/master/app/sampledata/Screenshots/ReqresActivity.jpg)

Результаты
![alt text](https://github.com/SoapMyxa/FirstAndroidApp/blob/master/app/sampledata/Screenshots/Reqres.JPG)

## Запросы к апи
Request
![alt text](https://github.com/SoapMyxa/FirstAndroidApp/blob/master/app/sampledata/Screenshots/Request.JPG)

Request Result
![alt text](https://github.com/SoapMyxa/FirstAndroidApp/blob/master/app/sampledata/Screenshots/RequestResult.JPG)

## Activities

Main window
![alt text](https://github.com/SoapMyxa/FirstAndroidApp/blob/master/app/sampledata/Screenshots/Main.jpg)

Random word
![alt text](https://github.com/SoapMyxa/FirstAndroidApp/blob/master/app/sampledata/Screenshots/RandowWord.jpg)

Dictionary
![alt text](https://github.com/SoapMyxa/FirstAndroidApp/blob/master/app/sampledata/Screenshots/Dictionary.jpg)

Settings
![alt text](https://github.com/SoapMyxa/FirstAndroidApp/blob/master/app/sampledata/Screenshots/Settings.jpg)
