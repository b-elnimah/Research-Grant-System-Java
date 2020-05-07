package pak1;

@SuppressWarnings("serial")
public class RA extends Researcher{

	private int hours;
	private Type type;
	


	public double getPayment(Project X) {
			if(type == Type.PHD)
				return 80*hours;
			return 100*hours;
	}



	// Getters And Setters
	public int getHours() {
		return hours;
	}
	public Type getType() {
		return type;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public void setType(Type type) {
		this.type = type;
	}

}
