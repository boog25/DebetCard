package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestSelenide {
    @Test
    void shouldNewRequest() {
        Configuration.browser = "Firefox";
        Configuration.headless = true;
        open("http://localhost:9999/");
        $("[type='text']").setValue("Чиков Андрей Андреевич");
        $("[type='tel']").setValue("+79126893813");
        $("[data-test-id='agreement']").click();
        $("[type='button']").click();
        $(withText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."))
                .shouldBe(Condition.visible);
    }
}
