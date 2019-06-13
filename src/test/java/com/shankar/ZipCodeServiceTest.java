package com.shankar;

import com.shankar.exception.ZipRestrictionException;
import com.shankar.service.ZipRestrictionService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZipCodeServiceTest {

    ZipRestrictionService zipRestrictionService;
    @Before
    public  void setUp()
    {
        zipRestrictionService=new ZipRestrictionService();
    }
    @Test
    public void serviceTestcase1() throws ZipRestrictionException {
        String validInput = "[94133,94133] [94200,94299] [94600,94699]";
        String output = zipRestrictionService.compute(validInput.split(" "));
        assertEquals("[94133,94133] [94200,94299] [94600,94699] ",output);
    }
    @Test
    public void serviceTestcase2() throws ZipRestrictionException {
        String validInput = "[94133,94133] [94200,94299] [94226,94399]";
        String output = zipRestrictionService.compute(validInput.split(" "));
        assertEquals("[94133,94133] [94200,94399] ",output);
    }
}
