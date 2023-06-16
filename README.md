# testing.system.project
# Android приложение "Quizz App"

## **Состав:**

#### Многострадальная четверка

* Анастасия Хоменко – тимлид / главный разработчик [nastuaah](https://github.com/nastuaah)

* Гагулина Полина – разработчик [Polineska](https://github.com/Polineska)

* Лапшина Татьяна – разработчик [Tatyanka25](https://github.com/Tatyanka25)

* Лумбова Софья – разработчик [SofiaLumbik](https://github.com/SofiaLumbik)

## **Описание проекта:**
В рамках проекта необходимо разработать интеллектуальную систему тестирования в рамках
произвольной предметной области (ПО).

Основной принцип работы системы: внутри содержится база вопросов на знание некоторой ПО.
Вопросы объединены в группы согласно своей тематике (минимальное количество: групп – 5, вопросов в группе - 15).
При регистрации в системе пользователю предлагается пройти тестирование. В начальный момент времени пользователю дается количество вопросов, соответствующих количеству групп. 
При ответе на вопрос проводится анализ не менее двух параметров, в том числе: правильность ответа – если 
пользователь дает неправильный ответ, ему дается дополнительный вопрос из соответствующей группы,
время ответа – если время ответа значительно меньше предполагаемого времени, необходимого для ответа
на вопрос (рассчитывается как время на прочтение вопроса +- погрешность), то ему задается вопрос из
соответствующей группы, чтобы убедиться в том, что ответ был дан верно по знанию, а не по наитию.
Таким образом, цепочка теста для каждого пользователя генерируется автоматически и не содержит
фиксированное количество вопросов.

## Архитектура приложения:

![База данных](https://github.com/nastuaah/testing.system.project/raw/database/Arkhitektura_prilozhenia.jpg)

Система поддерживает 1 режима доступа, который характеризуется отдельным
функционалом:
## Пользователь:

   • **Регистрация:**

Пользователь имеет право зарегистрироваться в системе, используя отдельную
вкладку. При этом осуществляется ввод основной информации о пользователе (login
(уникальный у каждого пользователя), password (удовлетворяющий заданным условиям
сложности), имя, фамилия, отчество (опционально), дата рождения, группа, секретный
вопрос (один из нескольких) для восстановления пароля и ответ на него, адрес электронной
почты (для подтверждения регистрации и/или восстановления пароля), номер телефона
(опционально, для подтверждения регистрации и/или восстановления пароля), файл с
фотографией etc).

   • **Вход в систему:**

После подтверждения регистрации, пользователь имеет право войти в систему,
используя свои login-password. 

   • **Доступ к прохождению тестов:**

После успешного прохождения регистрации и входа в систему под своим login-
password пользователь может пройти существующие тесты системы. Существует 2 типа 
тестов, которые он может пройти: тест по теме (=вопросы одной группы), итоговый тест
(=вопросы всех групп). В зависимости от правильности ответа на вопросы во время прохождения теста 
верные ответы на вопросы загораются зеленым цветом, неверные - красным, тем самым пользователь уже 
во время прохождения теста примерно понимает свой результат.
По итогам прохождения теста результаты пользователя выводятся
на экран и сохраняются – в будущем они доступны ему для просмотра в личном кабинете.

   • **Работа с личным кабинетом:**

В личном кабинете доступны 2 основных раздела: личной информации, а также
раздел результатов тестирования.
В первом разделе пользователю доступна для просмотра и редактирования вся
основная информация, введенная им при регистрации. Кроме того, доступна функция
удаления пользователя.
Во втором разделе пользователь видит список своих пройденных тестов и
результаты за них.

## Интерфейс приложения:
1. Activity_main - страница входа 
2. Activity_register - страница регистрации (с возможностью переключения между этими страницами по вопросам на них)
3. Activity_start - стартовая страница с возможностью начать игру или перейти в аккаунт пользователя 
4. Activity_options - страница с выбором категории для дальнейшей игры, категории из базы данных 
5. Activity_quizz - страница игры, в которую подгружаются вопросы из базы данных, кнопки с выбором ответа на вопрос + таймер, счет, количество вопросов, нужно доделать добавление вопросов при быстром/неправильном ответе
6. Activity_account - страница пользователя с переходом во вкладку с подсчетом результатов и вкладку с информацией о пользователе,a также кнопка с возможностью удалить аккаунт,
информация в полях (email,result, nickname) подгружается из базы данных
7. Activity_inform - страница, в которой доступна для просмотра и редактирования вся основная информация, введенная им при регистрации.
8. Test_result - страница, в которой пользователю виден список его пройденных тестов и
   результаты по ним.

В базе данных (Room - высокоуровневый интерфейс для низкоуровневых привязок SQLite, встроенных в Android) хранится информация о пользователях, вопросы, варианты ответов, ответы пользователя, 
категории вопросов, секретные вопросы для восстановления аккаунта + прописаны Dao, repositories и models с методами вызовов информации из бд,
в assets загружены сами вопросы и бд для вопросов, ответов, пользователей.
![База данных](https://github.com/nastuaah/testing.system.project/raw/database/baza-dannykh_2.png)

## Окружение:
**ОС:** Android

**Платформа:** Android
