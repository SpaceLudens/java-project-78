### Hexlet tests and linter status:
[![Actions Status](https://github.com/SpaceLudens/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/SpaceLudens/java-project-78/actions) [![GitHub Actions Demo](https://github.com/SpaceLudens/java-project-78/actions/workflows/main.yaml/badge.svg)](https://github.com/SpaceLudens/java-project-78/actions/workflows/main.yaml) [![Maintainability](https://api.codeclimate.com/v1/badges/42d35bfced4609fa364f/maintainability)](https://codeclimate.com/github/SpaceLudens/java-project-78/maintainability) [![Test Coverage](https://api.codeclimate.com/v1/badges/42d35bfced4609fa364f/test_coverage)](https://codeclimate.com/github/SpaceLudens/java-project-78/test_coverage)
# Учебный проект - Валидатор данных
**Описание проекта:**
 Валидатор данных - это библиотека, предназначенная для проверки корректности различных данных. Она позволяет проводить валидацию различных типов данных, таких как строки, числа. Данный проект основан на библиотеке `yup`, одной из популярных библиотек для валидации данных во многих языках программирования.  
**Пример использования**
Для использования репозитория через JShell, вам нужно выполнить следующие шаги:
1.  **Запустить JShell:** Запустите интерпретатор JShell, который предоставляет интерактивную среду для выполнения кода на Java.
  2.  **Импортировать классы:** Импортируйте необходимые классы из репозитория, чтобы использовать их функциональности в JShell. Например:
  
    import hexlet.code.Validator;
    import hexlet.code.schemas.StringSchema;
    import hexlet.code.schemas.NumberSchema;
    import hexlet.code.schemas.MapSchema;
    
  3.  **Создать объект валидатора:** Создайте объект валидатора с помощью конструктора Validator()`:

    Validator validator = new Validator();

4.  **Настроить схемы валидации:** Настройте схемы валидации, вызвав соответствующие методы объекта валидатора.
Для валидации строк:

    StringSchema stringSchema = validator.string().required().minLength(3);

Для валидации чисел:

    NumberSchema numberSchema = validator.number().required().positive().range(5, 10);

Для валидации объектов типа Map:

    MapSchema mapSchema = validator.map().required().sizeof(2);

5.  **Проверить данные:** Проверьте корректность данных, вызвав метод `isValid()` на соответствующей схеме валидации. 
