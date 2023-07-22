package order;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class OrderClient {
    public static final String ORDER_PATH = "/api/v1/orders";
    public static final String CANCEL_ORDER_PATH = "/api/v1/orders/cancel";
    public static final String BASE_URL = "http://qa-scooter.praktikum-services.ru/";

    @Step("Создание заказа")
    public ValidatableResponse createNewOrder(Order order) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .body(order)
                .when()
                .post(ORDER_PATH)
                .then();
    }

    @Step("Получение списка заказов")
    public ValidatableResponse getOrderList() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .when()
                .get(ORDER_PATH)
                .then();
    }

    @Step("Отмена заказа")
    public ValidatableResponse cancelOrder(int track) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .body(track)
                .when()
                .put(CANCEL_ORDER_PATH)
                .then();
    }
}