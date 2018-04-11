

package com.jaikant.unittesting.unittesting.business;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.jaikant.unittesting.unittesting.data.SomeDataService;


class SomeDataServiceStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] { 1, 2, 3 };
    }

}


class SomeDataServiceEmptyStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] { };
    }

}


class SomeDataServiceOneValueStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] { 10 };
    }

}


public class SomeBusinessStubTest {

    @Test
    public void calculateSumUsingDataService_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceEmptyStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceOneValueStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 10;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] { 1, 2, 3 });
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] { });
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] { 10 });
        int expectedResult = 10;
        assertEquals(expectedResult, actualResult);
    }

}
