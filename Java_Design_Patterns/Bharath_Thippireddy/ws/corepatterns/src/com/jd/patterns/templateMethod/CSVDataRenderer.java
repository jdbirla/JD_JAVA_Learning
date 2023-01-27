package com.jd.patterns.templateMethod;

public class CSVDataRenderer extends DataRenderer {

	@Override
	public String readData() {

		return "CSV Data";
	}

	@Override
	public String processData(String data) {
		// TODO Auto-generated method stub
		return "Processed " + data;
	}

}
