package pak1;

import pak2.QNRF;


public class Main {

	public static void main(String[] args) throws Exception{
	
		QNRFTest QNRFTest_1= new QNRFTest();
		QNRFTest_1.ReadFile();
		
		QNRF frame = new QNRF(QNRFTest_1);
		frame.setVisible(true);
		
		
	}

}
