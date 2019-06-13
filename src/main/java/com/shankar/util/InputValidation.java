package com.shankar.util;

import com.shankar.exception.ZipRestrictionException;

import java.util.regex.Pattern;

public class InputValidation {

    private final static String REGX="\\[\\d{5}\\,\\d{5}\\]";

    /**
     * Validate the input , throws exception when input is null and if zip code is not valid.
     * @param input
     * @throws ZipRestrictionException
     */

    public static void validateInput(String[] input) throws ZipRestrictionException {

        if(input==null || input.length==0)
        {
            throw new ZipRestrictionException("Null input supplied");
        }
        for(String range: input )
        {
            if(!Pattern.matches(REGX,range))
            {
                throw new ZipRestrictionException("Invalid input");
            }
            //System.out.println("ZipCode range:"+range);
        }
    }

    public static String usage()
    {
        return "Usage: [zipcode,zipcode] ... [zipcode-n,zipcode-n]  zipcode in range";
    }
}
