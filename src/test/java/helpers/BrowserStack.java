package helpers;

import static io.restassured.RestAssured.given;

public class BrowserStack {

    public static String getBrowserstackVideoUrl(String sessionId) {
        String video_url = given()
                .auth().basic("bsuser_NKe2MJ", "rxXBo1Rxwikb2nsfN89i")
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId +".json")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .path("automation_session.video_url");

        System.out.println("video_url: " + video_url);
        return video_url;
    }
}
