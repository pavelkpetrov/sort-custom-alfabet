package com.qittiq.order.test;

import com.qittiq.order.serivce.Sorter;
import org.junit.Assert;
import org.junit.Test;

public class SorterTest {

    @Test
    public void all_alfabet_present_test(){
        String expected = "tse";
        String result = Sorter.getSorter().apply("est",expected);
        Assert.assertTrue(expected.equals(result));
    }

    @Test
    public void not_all_alfabet_present_test(){
        String expected = "tsea";
        String result = Sorter.getSorter().apply("esta","tse");
        Assert.assertTrue(expected.equals(result));
    }

    @Test
    public void not_all_in_arbitrary_present_test(){
        String expected = "tsa";
        String result = Sorter.getSorter().apply("sta","tsea");
        Assert.assertTrue(expected.equals(result));
    }
}
