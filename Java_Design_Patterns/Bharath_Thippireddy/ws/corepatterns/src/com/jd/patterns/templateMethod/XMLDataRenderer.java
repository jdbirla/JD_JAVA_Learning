package com.jd.patterns.templateMethod;

public class XMLDataRenderer extends DataRenderer {

	@Override
	public String readData() {

		return "XML Data";
	}

	@Override
	public String processData(String data) {
		// TODO Auto-generated method stub
		return "Processed " + data;
	}

}
