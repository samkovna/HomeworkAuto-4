package ru.netology.web;

import com.codeborne.selenide.SetValueOptions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class RegistrationTest {

    @Test
    void shouldBook() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Владимир");
        LocalDate date = LocalDate.now();
        $("[data-test-id=date] input").setValue(String.valueOf(date.plusDays(3)));
        $("[data-test-id=name] input").setValue("Сергеев Андрей");
        $("[data-test-id=phone] input").setValue("+79005888885");
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id=notification]").shouldBe(visible, Duration.ofSeconds(15));
        $x("//*[contains(text(), 'Встреча успешно забронирована')]").shouldBe(visible);
    }
}

