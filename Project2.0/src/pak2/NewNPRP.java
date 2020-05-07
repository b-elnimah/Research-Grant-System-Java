package pak2;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ListSelectionModel;

import pak1.Faculty;
import pak1.NPRP;
import pak1.Project;
import pak1.QNRFTest;
import pak1.Researcher;

@SuppressWarnings("serial")
public class NewNPRP extends JFrame {

	private JPanel contentPane;
	private JTextField Title;
	private JTextField ID;
	private JTextField Le;
	private JTextField Duration;
	private JTextField Error;
	private JTextField ID2;
	private JList<Integer> CList;
	private JList<Integer> SList;
	QNRFTest QNRFTest_1;
	private static ArrayList<Researcher> ResearchersC= new ArrayList<Researcher>(); ; 
	private static ArrayList<Researcher> ResearchersS= new ArrayList<Researcher>(); 
	DefaultListModel<Integer> ClistModel=new DefaultListModel<Integer>();
	DefaultListModel<Integer> SlistModel=new DefaultListModel<Integer>();
	private JTextField Status;

	int Dispose()
	{
		ClistModel.clear();
		SlistModel.clear();
		ResearchersC.clear();
		ResearchersS.clear();
		return JFrame.DISPOSE_ON_CLOSE;
	}

	public NewNPRP(QNRFTest QNRFTest) {

		for(Researcher Researchers :  QNRFTest.getNPRP())

			ResearchersC.add(Researchers);

		QNRFTest_1 =  QNRFTest;

		setResizable(false);
		setTitle("New NPRP");
		setDefaultCloseOperation(Dispose());
		setBounds(100, 100, 810, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 794, 388);
		contentPane.add(panel);

		JLabel label = new JLabel("Project Title");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(10, 76, 139, 14);
		panel.add(label);

		JLabel label_1 = new JLabel("Project ID");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(10, 117, 139, 14);
		panel.add(label_1);

		Title = new JTextField();
		Title.setColumns(10);
		Title.setBounds(165, 74, 240, 20);
		panel.add(Title);

		ID = new JTextField();
		ID.setColumns(10);
		ID.setBounds(165, 115, 240, 20);
		panel.add(ID);

		JLabel lblProjectLeaderId = new JLabel("Project Leader ID (LPI)");
		lblProjectLeaderId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProjectLeaderId.setBounds(10, 160, 168, 14);
		panel.add(lblProjectLeaderId);

		Le = new JTextField();
		Le.setColumns(10);
		Le.setBounds(165, 158, 240, 20);
		panel.add(Le);

		JLabel label_3 = new JLabel("Project Duration");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(10, 248, 139, 14);
		panel.add(label_3);

		for( Researcher researcher : ResearchersC)
			ClistModel.addElement(researcher.getId());

		CList = new JList<Integer>(ClistModel);
		CList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		CList.setBounds(441, 56, 139, 237);
		JScrollPane scrollPane = new JScrollPane(CList);
		scrollPane.setBounds(441, 56, 139, 237);
		scrollPane.setVisible(true);
		panel.add(scrollPane);


		SList = new JList<Integer>();
		SList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		SList.setBounds(645, 56, 139, 237);
		JScrollPane scrollPane_1 = new JScrollPane(SList);
		scrollPane_1.setBounds(645, 56, 139, 237);
		scrollPane_1.setVisible(true);
		panel.add(scrollPane_1);


		JButton button_1 = new JButton("Add A New Researcher");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewResearcher frame = new NewResearcher(QNRFTest_1);
				frame.setVisible(true);


			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBounds(10, 304, 395, 23);
		panel.add(button_1);

		JLabel label_4 = new JLabel("Complete list");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(464, 31, 101, 14);
		panel.add(label_4);

		JLabel label_5 = new JLabel("Selected List");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(659, 31, 112, 14);
		panel.add(label_5);

		JLabel label_7 = new JLabel("List of Researchers");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_7.setBounds(540, 11, 139, 14);
		panel.add(label_7);

		Duration = new JTextField();
		Duration.setColumns(10);
		Duration.setBounds(165, 242, 240, 20);
		panel.add(Duration);

		JButton Create = new JButton("Create");
		Create.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				boolean check;


				if(ID.getText().matches("\\d+"))
				{
					if(Le.getText().matches("\\d+"))
					{
						int pfm = Integer.parseInt(Le.getText()); 
						if(Duration.getText().matches("\\d+"))
						{
							int duration = Integer.parseInt(Duration.getText());
							if(duration>0 && duration<4)
							{
								check=false;

								for(Researcher Researchers :  ResearchersS)
									if(Researchers.getId()==pfm)
										if(Researchers instanceof Faculty)
										{check=true;break;}
								if(check)
								{

									for(Project project : QNRFTest_1.getProjects())
										if(pfm ==project.getId())
											check=false;

									if(check){
										NPRP NPRP =new NPRP ();
										NPRP.setTitle(Title.getText());
										NPRP.setId(Integer.parseInt(ID.getText()));
										NPRP.setDuration(Integer.parseInt(Duration.getText()));
										NPRP.setStartDate(Calendar.getInstance());
										NPRP.setStatus(Status.getText());
										NPRP.setTeam(ResearchersS);
										int PI = Integer.parseInt(Le.getText());
										for(Researcher Researchers :  ResearchersS)
											if(Researchers.getId()==PI)
												NPRP.setLead_PI(Researchers);

										QNRFTest_1.getProjects().add(NPRP);

										ClistModel.clear();
										SlistModel.clear();
										ResearchersC.clear();
										ResearchersS.clear();
										dispose();


									}
									else 
										Error.setText("Invalid Project ID(Existing ID)");

								}
								else
									Error.setText("Invalid LPI ID(NON Existing ID For Faculty");
							}
							else
								Error.setText("Invalid Duration ID(OutOfBound)");
						}
						else
							Error.setText("Invalid Duration ID(Type MisMatch");
					}
					else
						Error.setText("Invalid LPI ID(Type MisMatch");
				}
				else 
					Error.setText("Invalid Project ID(Type MisMatch");

			}
		});
		Create.setFont(new Font("Tahoma", Font.BOLD, 12));
		Create.setBounds(10, 338, 112, 23);
		panel.add(Create);

		JButton Refresh = new JButton("Refresh");
		Refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean Check1;
				for( Researcher researcher : QNRFTest_1.getNPRP())
				{
					Check1=true;
					for( Researcher researcher2 : ResearchersC)
						if(researcher.getId() == researcher2.getId())
						{Check1=false;break;}
					for( Researcher researcher2 : ResearchersS)
						if(researcher.getId() == researcher2.getId())
						{Check1=false;break;}
					if(Check1)
						ResearchersC.add(researcher);

				}

				ClistModel.clear();
				for( Researcher researcherC : ResearchersC)
					ClistModel.addElement(researcherC.getId());
				CList.setModel( ClistModel );

				SlistModel.clear();
				for( Researcher researcherS : ResearchersS)
					SlistModel.addElement(researcherS.getId());
				SList.setModel( SlistModel );




			}
		});
		Refresh.setFont(new Font("Tahoma", Font.BOLD, 12));
		Refresh.setBounds(153, 338, 112, 23);
		panel.add(Refresh);

		JButton Cancel = new JButton("Cancel");
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		Cancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		Cancel.setBounds(304, 338, 101, 23);
		panel.add(Cancel);

		JButton Add = new JButton("Add");
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ID2.getText().matches("\\d+"))
				{
					int i = Integer.parseInt(ID2.getText());
					int ID=0;
					boolean check=false;
					for(int x=0; x<ResearchersC.size();x++)
						if(i == ResearchersC.get(x).getId())
						{check=true;ID=x;}
					if(check)
					{

						{
							ResearchersS.add(ResearchersC.get(ID));
							ResearchersC.remove(ID);
						}

					}
					else
						Error.setText("Invalid ID");

					ClistModel.clear();

					for( Researcher researcher : ResearchersC)
						ClistModel.addElement(researcher.getId());
					CList.setModel( ClistModel );

					SlistModel.clear();
					for( Researcher researcher : ResearchersS)
						SlistModel.addElement(researcher.getId());
					SList.setModel( SlistModel );


				}
				else 
					Error.setText("Enter ID");
			}


		});
		Add.setFont(new Font("Tahoma", Font.BOLD, 12));
		Add.setBounds(451, 338, 155, 23);
		panel.add(Add);

		Error = new JTextField();
		Error.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		Error.setEditable(false);
		Error.setColumns(10);
		Error.setBounds(10, 273, 395, 20);
		panel.add(Error);

		JButton Delete = new JButton("Delete");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ID2.getText().matches("\\d+"))
				{
				int i = Integer.parseInt(ID2.getText());
				int ID=0;
				boolean check=false;
				for(int x=0; x<ResearchersS.size();x++)
					if(i == ResearchersS.get(x).getId())
					{check=true;ID=x;}
				if(check)
				{
					{
						ResearchersC.add(ResearchersS.get(ID));
						ResearchersS.remove(ID);
					}

				}
				else
					Error.setText("Invalid ID");

				ClistModel.clear();

				for( Researcher researcher : ResearchersC)
					ClistModel.addElement(researcher.getId());
				CList.setModel( ClistModel );

				SlistModel.clear();
				for( Researcher researcher : ResearchersS)
					SlistModel.addElement(researcher.getId());
				SList.setModel( SlistModel );

				}
				else 
					Error.setText("Enter ID");
			}
		});
		Delete.setFont(new Font("Tahoma", Font.BOLD, 12));
		Delete.setBounds(635, 338, 149, 23);
		panel.add(Delete);

		JLabel lblEnterId = new JLabel("Enter ID");
		lblEnterId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnterId.setBounds(441, 308, 68, 14);
		panel.add(lblEnterId);

		ID2 = new JTextField();
		ID2.setColumns(10);
		ID2.setBounds(519, 304, 265, 20);
		panel.add(ID2);

		JLabel label_2 = new JLabel("Project Status");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(10, 202, 139, 14);
		panel.add(label_2);

		Status = new JTextField();
		Status.setColumns(10);
		Status.setBounds(165, 200, 236, 20);
		panel.add(Status);
	}


}
