1. Проверка полей ввода "Username" и "Password" на странице Login.
2. Проверка работы гиперссылок в панели бокового меню.
3. Проверка кнопки "ADD TO CART" на странице Products.
4. Проверка деталей продукта(стоимость, описание) после добавления в корзину.
5. Проверка перехода на страницу товара.
6. Проверка кнопки Remove на странице Products.
7. Проверка полей ввода на странице Checkout: Your Information. (First Name, Last Name, Zip/Postal Code)
8. Проверка общей стоимости товаров с учетом налога.
9. Проверка кнопок Finish и Cancel.
10. Проверка оплаты товаров.



1. Обновить версии всех библиотек в проекте и ее вывод:
[INFO] --- versions-maven-plugin:2.7:display-dependency-updates (default-cli) @ SauceDemo ---
[INFO] The following dependencies in Dependencies have newer versions:
[INFO]   org.seleniumhq.selenium:selenium-java ...... 3.141.59 -> 4.0.0-alpha-5

2. Запустить тесты используя mvn clean test команду и ее вывод:
Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 21.783 sec

3. Использовать параметрв для запуска конкретных тестов и методов:
mvn clean test -Dtest=CartTest#continueShoppingTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 3.967 sec

mvn -Dtest=SauceDemoTest#loginTest+lockedUserTest test
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 5.022 s - in tests.SauceDemoTest

4. Создать альтернативный pom.xml и запустить из него mvn билд:
mvn -f /Users/design3/IdeaProjects/HerokuAppTest/pom.xml clean test
Tests run: 24, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 18.542 sec

5. Пробросить параметр из mvn command line внутрь теста:
mvn clean test -Dtest=SauceDemoTest#lockedUserTest -DuserName=standard_user
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 2.571 s - in tests.SauceDemoTest
