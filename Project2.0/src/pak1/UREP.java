package pak1;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class UREP extends Project{
	
	public UREP() {
		super.setTeam(new ArrayList<Researcher>());
		// TODO Auto-generated constructor stub
	}

	private Researcher PFM;
	
	
	public double PersonnelCost() {
		int sum=0;
		for(Researcher researcher: super.getTeam())
			sum+=researcher.getPayment(this);
		return sum;
	}
	
	
	
	
	
	// Getters And Setters
	public Researcher getPFM() {
		return this.PFM;
	}

	public void setPFM(Researcher pFM) {
		this.PFM = pFM;
	}
	
}
