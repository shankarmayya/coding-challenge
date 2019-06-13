package com.shankar;

import com.shankar.exception.ZipRestrictionException;
import com.shankar.service.ZipRestrictionService;

public class Main {


    public static void main(String[] args) throws ZipRestrictionException {

        ZipRestrictionService zipRestrictionService = new ZipRestrictionService();
        System.out.println("Output is:"+zipRestrictionService.compute(args));

    }
}
