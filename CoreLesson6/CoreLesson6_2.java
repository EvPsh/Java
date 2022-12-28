package CoreLesson6;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class CoreLesson6_2 {
    public static void main(String[] args) throws IOException {
        // Вариант получения JSON через OkHttpClient
        // из методички, но у меня не запускается (ошибки под комментами в конце файла)
        // файрволл пропускает, есть подозрение, что не настроил dependency (если создаю проект maven,
        // то не вижу проекты java, при попытке их как-то объединить, слетают конфигурации java (запуск main)
        // okhttp и rest assured - по методичке file -> project structure -> modules -> Dependencies -> '+'

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/332287?apikey=Wd0awaiGsTkVlEF3Qs8V3TWOClW2SiYi&language=ru-ru&metric=true")
                .build();

        Response response = client.newCall(request).execute();

        String body = response.body().string();
        System.out.println(response.code());

    }
}