package com.qa.apitest;

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

    }

}
