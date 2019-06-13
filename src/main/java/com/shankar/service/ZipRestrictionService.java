package com.shankar.service;

import com.shankar.exception.ZipRestrictionException;
import com.shankar.model.ZipCode;
import com.shankar.util.InputValidation;

import java.util.ArrayList;
import java.util.List;


public class ZipRestrictionService {

    private List<ZipCode> zipRangeList = new ArrayList<>();
    private List<String> flattenZipCode = new ArrayList<>();

    /**
     *
     *   Service class responsible truncating zip code range applying following logic
     *   parses the input zip code range set into ZipCode arraylist and flattens
     *   input into flattenZIpCode list which will be used to check if zip code falls
     *   within more than one setup then that zip code will not be added into final result.
     *
     * @param zipCodeRange
     * @return
     * @throws ZipRestrictionException
     */

    public String compute(String[] zipCodeRange) throws ZipRestrictionException {

        // validate for null , empty and 5 digit zip codes
        InputValidation.validateInput(zipCodeRange);
        // flatten zipcode into
        for (String zip : zipCodeRange) {

            String zipCodeSplit[] = zip.replace("[", "").replace("]", "").split(",");
            flattenZipCode.add(zipCodeSplit[0]);
            flattenZipCode.add(zipCodeSplit[1]);
            zipRangeList.add(new ZipCode(zipCodeSplit[0], zipCodeSplit[1]));

        }
        int found = 0;
        String openingSqBracket = "[";
        String closingSqBracket = "]";
        StringBuffer finalString = new StringBuffer();
        int setCounter = 0;
        for (String zip : flattenZipCode) {
            for (ZipCode zipCode : zipRangeList) {
                int zipNum = Integer.parseInt(zip);
                int lowerBoundZipNum = Integer.parseInt(zipCode.getLowerBoundZip());
                int upperBoundzipnum = Integer.parseInt(zipCode.getUpperBoundZip());
                if (zipNum >= lowerBoundZipNum && zipNum <= upperBoundzipnum) {
                    found++;
                }
            }
            // if zip falls in only one set then add to final string.

            if (found == 1) {

                // preparing [95670
                if (setCounter == 0) {
                    finalString.append(openingSqBracket).append(zip);
                    setCounter++;

                } else if (setCounter == 1) {
                    finalString.append(",").append(zip);
                    setCounter++;
                }

            }
            // once two zip is added then close the section and append space at the end.
            //reset the counter
            if (setCounter == 2) {
                finalString.append(closingSqBracket).append(" ");
                setCounter = 0;
            }
            found = 0;
        }
        // if finalString is "" in special cases then take the first set.
        if (finalString.length() == 0) {
            finalString.append(openingSqBracket).append(zipRangeList.get(0).getLowerBoundZip()).append(",").append(zipRangeList.get(0).getUpperBoundZip()).append(closingSqBracket);
        }
        return finalString.toString();

    }
}
