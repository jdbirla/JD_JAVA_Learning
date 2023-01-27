package com.jd.patterns.templateMethod;

public class Test {
	public static void main(String[] args) {
		DataRenderer dataRenderer = new XMLDataRenderer();
		dataRenderer.render();
		CSVDataRenderer csvdataRenderer = new CSVDataRenderer();
		csvdataRenderer.render();
	}

}
