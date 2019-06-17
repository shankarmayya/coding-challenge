package com.shankar;

import com.shankar.exception.ZipRestrictionException;
import com.shankar.util.InputValidation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ZipCodeValidation {

    @Test
    public void testInputValidation() {
        String validInput = "[94133,94133] [94200,94299] [94600,94699]";
        try {
            InputValidation.validateInput(validInput.split(" "));
            InputValidation.validateInput(null);
        } catch (ZipRestrictionException e) {
            assertEquals("Null input supplied", e.getMessage());
            System.out.println(e);
        }

    }

    @Test(expected = ZipRestrictionException.class)
    public void testInvalidInputValidation() throws ZipRestrictionException {
        InputValidation.validateInput("[94133d,s94133]".split(" "));
    }

    @Test
    public void testInvalidZipInputValidation() throws ZipRestrictionException {
        try {
            InputValidation.validateInput("[9413,94133]".split(" "));
        }
        catch (ZipRestrictionException e) {
            assertEquals("Invalid input", e.getMessage());
            System.out.println(e);
        }
    }

    @Test
    public void testInvalidBoundZipInputValidation() throws ZipRestrictionException {
        try {
            InputValidation.validateInput("[95670,95669]".split(" "));
        }
        catch (ZipRestrictionException e) {
            assertEquals("Invalid bounds, lower bound should be less than upper bound", e.getMessage());
            System.out.println(e);
        }
    }
}

