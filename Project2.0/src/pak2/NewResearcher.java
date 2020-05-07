package pak2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import pak1.QNRFTest;
@SuppressWarnings("serial")
public class NewResearcher extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField ID;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();


	JRadioButton Faculty ;
	JRadioButton UndrGrad;
	JRadioButton PostDoc ;
	JRadioButton Master ;
	JRadioButton PHD ;
	JRadioButton ResearchA ;
	JLabel lblHours;
	private JButton btnAdd;
	private JTextField Error;
	private JLabel lblMajor;
	private JTextField Major;
	private JLabel lblSalary;
	private JTextField Salary;
	private JTextField Hours;

	
	public NewResearcher(final QNRFTest QNRFTest_1) {

		setResizable(false);
		setTitle("Add A New Researcher");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblResearcherName = new JLabel("Researcher Name");
		lblResearcherName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblResearcherName.setBounds(10, 11, 127, 14);
		contentPane.add(lblResearcherName);

		Name = new JTextField();
		Name.setColumns(10);
		Name.setBounds(146, 9, 308, 20);
		contentPane.add(Name);

		JLabel lblResearcherId = new JLabel("Researcher ID");
		lblResearcherId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblResearcherId.setBounds(10, 46, 127, 14);
		contentPane.add(lblResearcherId);

		ID = new JTextField();
		ID.setColumns(10);
		ID.setBounds(146, 44, 308, 20);
		contentPane.add(ID);

		JLabel lblResearcherType = new JLabel("Researcher Type");
		lblResearcherType.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblResearcherType.setBounds(10, 79, 127, 14);
		contentPane.add(lblResearcherType);

		Faculty = new JRadioButton("Faculty :-");
		Faculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Master.setEnabled(false);
				PHD.setEnabled(false);
				lblHours.setEnabled(false);
				Hours.setEnabled(false);

				lblMajor.setEnabled(false);
				Major.setEnabled(false);

				lblSalary.setEnabled(true);
				Salary.setEnabled(true);

			}
		});
		buttonGroup.add(Faculty);
		Faculty.setBounds(10, 139, 109, 23);
		contentPane.add(Faculty);

		UndrGrad = new JRadioButton("UnderGrad :-");
		UndrGrad.setSelected(true);
		UndrGrad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Master.setEnabled(false);
				PHD.setEnabled(false);
				lblSalary.setEnabled(false);
				Salary.setEnabled(false);
				lblHours.setEnabled(false);
				Hours.setEnabled(false);


				lblMajor.setEnabled(true);
				Major.setEnabled(true);
			}
		});
		buttonGroup.add(UndrGrad);
		UndrGrad.setBounds(10, 100, 109, 23);
		contentPane.add(UndrGrad);

		PostDoc = new JRadioButton("Post - Doc :-");
		PostDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Master.setEnabled(false);
				PHD.setEnabled(false);
				lblHours.setEnabled(false);
				Hours.setEnabled(false);

				lblMajor.setEnabled(false);
				Major.setEnabled(false);

				lblSalary.setEnabled(true);
				Salary.setEnabled(true);
			}
		});
		buttonGroup.add(PostDoc);
		PostDoc.setBounds(10, 165, 109, 23);
		contentPane.add(PostDoc);

		Master = new JRadioButton("Master's");
		Master.setSelected(true);
		Master.setEnabled(false);
		buttonGroup_1.add(Master);
		Master.setBounds(146, 200, 75, 23);
		contentPane.add(Master);

		PHD = new JRadioButton("PHD");
		PHD.setEnabled(false);
		buttonGroup_1.add(PHD);
		PHD.setBounds(235, 200, 58, 23);
		contentPane.add(PHD);

		ResearchA = new JRadioButton("Research Assistant :-");
		ResearchA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSalary.setEnabled(false);
				Salary.setEnabled(false);
				lblMajor.setEnabled(false);
				Major.setEnabled(false);

				Master.setEnabled(true);
				PHD.setEnabled(true);
				lblHours.setEnabled(true);
				Hours.setEnabled(true);


			}
		});
		buttonGroup.add(ResearchA);
		ResearchA.setBounds(10, 200, 134, 23);
		contentPane.add(ResearchA);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean x=true,y=true;



				if(ID.getText().matches("\\d+"))
				{
					int i =Integer.parseInt(ID.getText()) ;
					if( UndrGrad.isSelected() )
					{
						x=QNRFTest_1.newUnder(Name.getText(),i,Major.getText());
						y=false;
						Error.setText("Researcher Has Been Created, Cancel To Exit");
					}
					else if(Faculty.isSelected() )
					{
						if(Salary.getText().matches("\\d+"))
						{
							int s =Integer.parseInt(Salary.getText()) ;
							x=QNRFTest_1.newFaculty(Name.getText(),i,s);
							y=false;
							Error.setText("Researcher Has Been Created, Cancel To Exit");
						}
						else                                 
							Error.setText("Invalid Salary(Type MisMatch)");

					}
					else if(PostDoc.isSelected())
					{
						if(Salary.getText().matches("\\d+"))
						{
							int s =Integer.parseInt(Salary.getText()) ;	
							x=QNRFTest_1.newPostDoc(Name.getText(),i,s);
							y=false;
							Error.setText("Researcher Has Been Created, Cancel To Exit");
						}
						else                                 
							Error.setText("Invalid Salary(Type MisMatch)");
					}
					else if(ResearchA.isSelected())
					{
						if(Master.isSelected() )
						{
							
							if(Hours.getText().matches("\\d+"))
							{
								Integer h = Integer.parseInt(Hours.getText());
								if(h>0 && h<7400)
								{
									x=QNRFTest_1.newRA(Name.getText(), i, pak1.Type.MASTERS, h);
									y=false;
									Error.setText("Researcher Has Been Created, Cancel To Exit");
								}
								else
									Error.setText("Invalid Hours(Out Of Bounds)");
							}
							else
								Error.setText("Invalid Hours(Type MisMatch)");
							
						}
						
						else
						{

							if(Hours.getText().matches("\\d+"))
							{
								Integer h = Integer.parseInt(Hours.getText());
								if(h>0 && h<7400)
								{
									x=QNRFTest_1.newRA(Name.getText(), i, pak1.Type.PHD, h);
									Error.setText("Researcher Has Been Created, Cancel To Exit");
									y=false;
								}
								else
									Error.setText("Invalid Hours(Out Of Bounds)");
							}
							else
								Error.setText("Invalid Hours(Type MisMatch)");
						}
						
					}
					
					if(y)
						Error.setText(Error.getText()+"");
					else if(!x)
						Error.setText("Invalid ID(Existing ID");
						
				}
				else
					Error.setText("Invalid ID(Type MisMatch)");

			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setBounds(10, 267, 158, 23);
		contentPane.add(btnAdd);

		Error = new JTextField();
		Error.setEditable(false);
		Error.setColumns(10);
		Error.setBounds(10, 236, 422, 20);
		contentPane.add(Error);

		lblHours = new JLabel("Hours :");
		lblHours.setEnabled(false);
		lblHours.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHours.setBounds(299, 203, 69, 14);
		contentPane.add(lblHours);

		lblMajor = new JLabel("Major :");
		lblMajor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMajor.setBounds(125, 103, 58, 14);
		contentPane.add(lblMajor);

		Major = new JTextField();
		Major.setColumns(10);
		Major.setBounds(193, 101, 261, 20);
		contentPane.add(Major);

		lblSalary = new JLabel("Salary :");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSalary.setEnabled(false);
		lblSalary.setBounds(125, 148, 58, 14);
		contentPane.add(lblSalary);

		Salary = new JTextField();
		Salary.setEnabled(false);
		Salary.setColumns(10);
		Salary.setBounds(193, 146, 261, 20);
		contentPane.add(Salary);

		Hours = new JTextField();
		Hours.setEnabled(false);
		Hours.setBounds(364, 201, 90, 20);
		contentPane.add(Hours);

		JButton button = new JButton("Cancel");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(274, 267, 158, 23);
		contentPane.add(button);
	}
}
