package com.qa.apitest;

import org.junit.Test;

import files.payload;
import io.restassured.path.json.JsonPath;

public class sum_validations {
    @Test
    public void sumOfCources() {

        JsonPath jsTest = new JsonPath(payload.Courseprice());
        int countcourse = jsTest.getInt("courses.size()");
        for (int i = 0; i < countcourse; i++) {
            int courseprice = jsTest.get("courses[" + i + "].price");
            int coursecopies = jsTest.get("courses[" + i + "].copies");
            int amount = courseprice * coursecopies;
            System.out.println(amount);

        }

    }
}
