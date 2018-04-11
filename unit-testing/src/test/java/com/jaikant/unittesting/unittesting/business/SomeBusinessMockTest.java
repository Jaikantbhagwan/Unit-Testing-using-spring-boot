

package com.jaikant.unittesting.unittesting.business;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.jaikant.unittesting.unittesting.data.SomeDataService;


@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

    @InjectMocks
    SomeBusinessImpl business;

    @Mock
    SomeDataService someDataService;


    @Test
    public void calculateSumUsingDataService_basic() {
        when(someDataService.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });
        int actualResult = business.calculateSumUsingDataService();
        assertEquals(6, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        when(someDataService.retrieveAllData()).thenReturn(new int[] { });
        int actualResult = business.calculateSumUsingDataService();
        assertEquals(0, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        when(someDataService.retrieveAllData()).thenReturn(new int[] { 10 });
        int actualResult = business.calculateSumUsingDataService();
        assertEquals(10, actualResult);
    }

    @Test
    public void calculateSum_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] { 1, 2, 3 });
        assertEquals(6, actualResult);
    }

    @Test
    public void calculateSum_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] { });
        assertEquals(0, actualResult);
    }

    @Test
    public void calculateSum_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] { 10 });
        assertEquals(10, actualResult);
    }

}
