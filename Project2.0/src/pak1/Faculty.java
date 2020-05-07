package pak1;

@SuppressWarnings("serial")
public class Faculty extends Researcher{

	private double salary;


	public double getPayment(Project x) {
		if(x instanceof UREP)
		{
			int N=0, M=0;
			for(Researcher researcher: x.getTeam())
			{
				if(researcher instanceof Faculty)
					M++;
				if(researcher instanceof UnderGraduate)
					N++;
				}
			return (N*7300)/M;
			}	
		return 2*salary;
		}





	// Getters And Setters
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}



}
