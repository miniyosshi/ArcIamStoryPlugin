package com.github.miniyosshi.arciamstoryplugin;

public enum CSVFiles {
	AreaData(8),
	BankAccount(2),
	ChapterData(7),
	ScenarioData(2),
	SpawnPoints(5),
	UserData(11),
	ViewPoint(8);
	
	private int numberofdata;
	
	private CSVFiles (int numberofdata){
		this.numberofdata = numberofdata;
	}
	
	int getNumberofData() {
		return numberofdata;
	}
	
	//ChapterDataが読み込まれてはじめてViewpoitnも読み込むべき(この順で記述するべきだろう？？)
	
	
	
	//public void readCSV(){
		
	//}
	
	//public void writeCSV() {
		
	//}
	
}
