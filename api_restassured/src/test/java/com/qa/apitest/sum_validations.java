package com.qa.apitest;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import files.payload;
import io.restassured.path.json.JsonPath;

public class sum_validations {
    @Test
    public void sumOfCources() {

        JsonPath jsTest = new JsonPath(payload.Courseprice());
        int countcourse = jsTest.getInt("courses.size()");
        int sum = 0;
        for (int i = 0; i < countcourse; i++) {
            int courseprice = jsTest.get("courses[" + i + "].price");
            int coursecopies = jsTest.get("courses[" + i + "].copies");
            int amount = courseprice * coursecopies;
            System.out.println(amount);
            sum = sum + amount;

        }
        System.out.println(sum);
        int amountpurchase = jsTest.getInt("dashboard.purchaseAmount");
        System.out.println(amountpurchase);
        Assert.assertEquals(sum, amountpurchase);

    }
}
