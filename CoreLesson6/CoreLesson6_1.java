package CoreLesson6;

/*
    1. С помощью http запроса получить в виде json строки погоду в Санкт-Петербурге на период времени,
    пересекающийся со следующим занятием (например, выборка погода на следующие 5 дней - подойдет)
    2. Подобрать источник самостоятельно. Можно использовать api accuweather, порядок следующий: зарегистрироваться,
    зарегистрировать тестовое приложение для получения api ключа, найдите нужный endpoint и изучите документацию.
    Бесплатный тарифный план предполагает получение погоды не более чем на 5 дней вперед
    (этого достаточно для выполнения д/з).

    After setting your password, you will be able to log in at https://developer.accuweather.com/user in the future using:

    Once you are logged in, you can create an App and get your API Key using
    these basic instructions: http://developer.accuweather.com/getting-started

 */

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.io.IOException;

public class CoreLesson6_1 {

    public static void main(String[] args) throws IOException {
        //String apiKey = "Wd0awaiGsTkVlEF3Qs8V3TWOClW2SiYi";
        // http://dataservice.accuweather.com/forecasts/v1/daily/5day/332287?apikey=Wd0awaiGsTkVlEF3Qs8V3TWOClW2SiYi&language=ru-ru&metric=true
        // ответ - тест через онлайн curl, ответ приходит (200).

        // Вариант получения JSON через RestAssured

        // файрволл пропускает, есть подозрение, что не так настроены dependency (если создаю проект maven (pom),
        // то не вижу проекты java, при попытке их как-то объединить, слетают конфигурации java (запуск main)
        // okhttp и rest assured - по методичке file -> project structure -> modules -> Dependencies -> '+'

        RestAssured.baseURI = "http://dataservice.accuweather.com/";
        Response response = given()
                .when()
                .get("forecasts/v1/daily/5day/332287?apikey=Wd0awaiGsTkVlEF3Qs8V3TWOClW2SiYi&language=ru-ru&metric=true");
        System.out.println(response.asPrettyString());
    }
}

