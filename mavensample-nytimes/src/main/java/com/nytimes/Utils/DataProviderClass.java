package com.nytimes.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	    @DataProvider(name = "searchData")
	    public static Object[][] getData() {
	        List<Object[]> data = new ArrayList<>();
//	        String filePath = "src/main/resources/testdata.csv";
	        String filePath = "src/test/resources/Test_Data.xlsx";
	        
	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                data.add(new Object[] { line });
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return data.toArray(new Object[0][]);
	    }
}
