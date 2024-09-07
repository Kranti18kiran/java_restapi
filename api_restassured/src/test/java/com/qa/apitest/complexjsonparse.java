package com.qa.apitest;

import static org.hamcrest.Matchers.*;

import files.payload;
import io.restassured.path.json.JsonPath;

public class complexjsonparse {
    public static void main(String[] args) {

        JsonPath js2 = new JsonPath(payload.Courseprice());
        int countcourse = js2.getInt("courses.size()");
        int totalamount = js2.getInt("dashboard.purchaseAmount");
        String courseFirst = js2.get("courses[0].title");
        System.out.println(countcourse);
        System.out.println(totalamount);
        System.out.println(courseFirst);

        for (int i = 0; i < countcourse; i++) {

            String coursetitle = js2.get("courses[" + i + "].title");
            String courseprice = js2.getString("courses[" + i + "].price");
            String coursecopies = js2.getString("courses[" + i + "].copies");
            System.out.println("Title:" + coursetitle);
            System.out.println("Price:" + courseprice);
            System.out.println("No of Copies:" + coursecopies);

        }
        System.out.println("Using conditions in loops");

        for (int i = 0; i < countcourse; i++) {

            String coursetitle = js2.get("courses[ " + i + "].title");
            if (coursetitle.equalsIgnoreCase("Cypress")) {
                int copiescourse = js2.get("courses[" + i + "].copies");
                System.out.println("No of Copies:" + copiescourse);
                break;

            }

        }

    }

}
