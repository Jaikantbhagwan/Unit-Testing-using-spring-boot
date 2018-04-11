

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
        assertEquals(6, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        when(someDataService.retrieveAllData()).thenReturn(new int[] { });
        assertEquals(0, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        when(someDataService.retrieveAllData()).thenReturn(new int[] { 10 });
        assertEquals(10, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSum_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        assertEquals(6, business.calculateSum(new int[] { 1, 2, 3 }));
    }

    @Test
    public void calculateSum_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        assertEquals(0, business.calculateSum(new int[] { }));
    }

    @Test
    public void calculateSum_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        assertEquals(10, business.calculateSum(new int[] { 10 }));
    }

}
