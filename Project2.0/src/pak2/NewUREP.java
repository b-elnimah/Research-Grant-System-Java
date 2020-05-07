package pak2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import pak1.Faculty;
import pak1.Project;
import pak1.QNRFTest;
import pak1.Researcher;
import pak1.UREP;
import pak1.UnderGraduate;
@SuppressWarnings("serial")
public class NewUREP extends JFrame {

	private JPanel contentPane;
	private JTextField Title;
	private JTextField ID;
	private JLabel lblProjectLeaderpfm;
	private JTextField Le;
	private JLabel btnAddANew;
	private JLabel lblProjectDuration;
	private JTextField txtYearBy;
	private JList<Integer> SList;
	private JList<Integer> CList;
	private JTextField FRatio;
	private JButton Creat;
	private JLabel lblEnetrId;
	private JTextField ID2;
	private JButton Cancel;
	private JButton Add;
	private JTextField Error;
	private static ArrayList<Researcher> ResearchersC= new ArrayList<Researcher>(); ; 
	private static ArrayList<Researcher> ResearchersS= new ArrayList<Researcher>(); 
	DefaultListModel<Integer> ClistModel=new DefaultListModel<Integer>();
	DefaultListModel<Integer> SlistModel=new DefaultListModel<Integer>();
	private JButton Refresh;
	QNRFTest QNRFTest_1;
	private JLabel lblProjectStatus;
	private JTextField Status;
	private JTextField SRatio;
	private JTextField Ratio;

	int Dispose()
	{
		ClistModel.clear();
		SlistModel.clear();
		ResearchersC.clear();
		ResearchersS.clear();
		return JFrame.DISPOSE_ON_CLOSE;
	}
	public NewUREP(QNRFTest QNRFTest){
		
		QNRFTest_1 =  QNRFTest;
		for(Researcher Researchers :  QNRFTest.getUREP())
			ResearchersC.add(Researchers);


		setResizable(false);
		setTitle("New UREP");
		setDefaultCloseOperation(Dispose());
		

		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblProjectTitle = new JLabel("Project Title");
		lblProjectTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProjectTitle.setBounds(10, 56, 139, 14);
		contentPane.add(lblProjectTitle);

		JLabel lblProjectId = new JLabel("Project ID");
		lblProjectId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProjectId.setBounds(10, 101, 139, 14);
		contentPane.add(lblProjectId);

		Title = new JTextField();
		Title.setBounds(169, 54, 236, 20);
		contentPane.add(Title);
		Title.setColumns(10);

		ID = new JTextField();
		ID.setBounds(169, 99, 236, 20);
		contentPane.add(ID);
		ID.setColumns(10);

		lblProjectLeaderpfm = new JLabel("Project Leader ID(PFM)");
		lblProjectLeaderpfm.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProjectLeaderpfm.setBounds(10, 141, 155, 14);
		contentPane.add(lblProjectLeaderpfm);

		Le = new JTextField();
		Le.setBounds(169, 139, 236, 20);
		contentPane.add(Le);
		Le.setColumns(10);

		btnAddANew = new JLabel("Add A New Researcher (Faculty Member ) If He Does Not Exist");
		btnAddANew.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddANew.setBounds(10, 206, 421, 23);
		contentPane.add(btnAddANew);

		lblProjectDuration = new JLabel("Project Duration");
		lblProjectDuration.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProjectDuration.setBounds(10, 244, 115, 14);
		contentPane.add(lblProjectDuration);

		txtYearBy = new JTextField();
		txtYearBy.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		txtYearBy.setText("1 Year By Default");
		txtYearBy.setEditable(false);
		txtYearBy.setColumns(10);
		txtYearBy.setBounds(135, 241, 270, 20);
		contentPane.add(txtYearBy);

		for( Researcher researcher : ResearchersC)
			ClistModel.addElement(researcher.getId());
		CList = new JList<Integer>(ClistModel);
		CList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		CList.setBounds(430, 59, 139, 244);
		JScrollPane scrollPane = new JScrollPane(CList);
		scrollPane.setBounds(430, 59, 139, 244);
		contentPane.add(scrollPane);

		SList = new JList<Integer>();
		SList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		SList.setBounds(645, 59, 139, 241);
		JScrollPane scrollPane_1 = new JScrollPane(SList);
		scrollPane_1.setBounds(645, 59, 139, 241);
		contentPane.add(scrollPane_1);

		JButton AddANew = new JButton("Add A New Researcher");
		AddANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				NewResearcher frame = new NewResearcher(QNRFTest_1);
				frame.setVisible(true);


			}
		});
		AddANew.setFont(new Font("Tahoma", Font.BOLD, 12));
		AddANew.setBounds(10, 311, 395, 23);
		contentPane.add(AddANew);

		JLabel lblCompleteList = new JLabel("Complete ID list");
		lblCompleteList.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCompleteList.setBounds(464, 31, 101, 14);
		contentPane.add(lblCompleteList);

		JLabel lblSelectedList = new JLabel("Selected ID List");
		lblSelectedList.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectedList.setBounds(659, 31, 112, 14);
		contentPane.add(lblSelectedList);

		JLabel lblRatio = new JLabel("Ratio");
		lblRatio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRatio.setBounds(590, 56, 58, 14);
		contentPane.add(lblRatio);

		FRatio = new JTextField();
		FRatio.setText("0");
		FRatio.setEditable(false);
		FRatio.setBounds(579, 108, 56, 20);
		contentPane.add(FRatio);
		FRatio.setColumns(10);

		JLabel lblListOfResearchers = new JLabel("List of Researchers");
		lblListOfResearchers.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblListOfResearchers.setBounds(540, 11, 139, 14);
		contentPane.add(lblListOfResearchers);

		Creat = new JButton("Create");
		Creat.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				boolean check;
				if(ID.getText().matches("\\d+"))
				{
					if(Le.getText().matches("\\d+"))
					{
						int pfm = Integer.parseInt(Le.getText());
						check=false;

						for(Researcher Researchers :  ResearchersS)
							if(Researchers.getId()==pfm)
								if(Researchers instanceof Faculty)
								{check=true;break;}
						if(check)
						{
							for(Project project : QNRFTest_1.getProjects())
								if(Integer.parseInt(ID.getText()) ==project.getId())
									check=false;

							if(check){
								UREP UREP =new UREP ();
								UREP.setTitle(Title.getText());
								UREP.setId(Integer.parseInt(ID.getText()));
								UREP.setDuration(1);
								UREP.setStartDate(Calendar.getInstance());
								UREP.setStatus(Status.getText());
								
								for(Researcher Researchers :  ResearchersS)
								{
									UREP.getTeam().add(Researchers);
									if(Researchers.getId()==pfm)
										UREP.setPFM(Researchers);
									
								}
								QNRFTest_1.getProjects().add(UREP);

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
							Error.setText("Invalid PFM ID(NON Existing ID For Faculty");
					}
					else
						Error.setText("Invalid PFM ID(Type MisMatch");
				}
				else 
					Error.setText("Invalid Project ID(Type MisMatch");

			}
		});
		Creat.setFont(new Font("Tahoma", Font.BOLD, 12));
		Creat.setBounds(10, 345, 125, 23);
		contentPane.add(Creat);

		lblEnetrId = new JLabel("Enetr ID To Move");
		lblEnetrId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnetrId.setBounds(440, 311, 125, 14);
		contentPane.add(lblEnetrId);

		JButton Delete = new JButton("Remove");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ID2.getText().matches("\\d+"))
				{
				int i = Integer.parseInt(ID2.getText());
			int x=0;
			boolean check=false;
			for(; x<ResearchersS.size();x++)
				if(i == ResearchersS.get(x).getId())
				{check=true;break;}
			if(check)
			{
				int F=(((Integer.parseInt(FRatio.getText()))-1)*3);
				int S = (Integer.parseInt(SRatio.getText()));

				if(ResearchersS.get(x) instanceof UnderGraduate)
				{
					ResearchersC.add(ResearchersS.get(x));
					ResearchersS.remove(x);
					SRatio.setText(""+(S-1));
					Error.setText("Removed");
				}
				else if(ResearchersS.get(x) instanceof Faculty)
				{
					if(F >= S)
					{
						ResearchersC.add(ResearchersS.get(x));
						ResearchersS.remove(x);
						SRatio.setText(""+(S-1));
						Error.setText("Renoved");
					}
					else
						Error.setText("You Have To Delete More UnderGrads First");


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
		Delete.setBounds(641, 346, 143, 21);
		contentPane.add(Delete);

		ID2 = new JTextField();
		ID2.setColumns(10);
		ID2.setBounds(568, 309, 216, 20);
		contentPane.add(ID2);

		Cancel = new JButton("Cancel");
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClistModel.clear();
				SlistModel.clear();
				ResearchersC.clear();
				ResearchersS.clear();
				dispose();
			}
		});
		Cancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		Cancel.setBounds(280, 345, 125, 23);
		contentPane.add(Cancel);

		Add = new JButton("Add");
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ID2.getText().matches("\\d+"))
				{
				int i = Integer.parseInt(ID2.getText());
				int x=0;
				boolean check=false;
				for(; x<ResearchersC.size();x++)
					if(i == ResearchersC.get(x).getId())
					{check=true;break;}
				if(check)
				{
					int F=((Integer.parseInt(FRatio.getText()))*3);
					int S = (Integer.parseInt(SRatio.getText()));

					if(ResearchersC.get(x) instanceof UnderGraduate)
					{

						if(F == 0)
							Error.setText("Please Add A Faculty First preferably The PFM");
						else if(F > S)
						{
							SRatio.setText(""+(S+1));
							ResearchersS.add(ResearchersC.get(x));
							ResearchersC.remove(x);
							Error.setText("Added");

						}
						else
							Error.setText("Please Add One More Faculty First");
					}

					else if(ResearchersC.get(x) instanceof Faculty)
					{
						F=(Integer.parseInt(FRatio.getText()));
						FRatio.setText(""+(F+1));
						ResearchersS.add(ResearchersC.get(x));
						ResearchersC.remove(x);
						Error.setText("Added");

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
		Add.setBounds(430, 346, 143, 21);
		contentPane.add(Add);

		Error = new JTextField();
		Error.setEditable(false);
		Error.setColumns(10);
		Error.setBounds(10, 280, 395, 20);
		contentPane.add(Error);

		Refresh = new JButton("Refresh");
		Refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean Check1;
				for( Researcher researcher : QNRFTest_1.getUREP())
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
		Refresh.setBounds(145, 345, 125, 23);
		contentPane.add(Refresh);

		lblProjectStatus = new JLabel("Project Status");
		lblProjectStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProjectStatus.setBounds(10, 181, 139, 14);
		contentPane.add(lblProjectStatus);

		Status = new JTextField();
		Status.setColumns(10);
		Status.setBounds(169, 175, 236, 20);
		contentPane.add(Status);

		SRatio = new JTextField();
		SRatio.setText("0");
		SRatio.setEditable(false);
		SRatio.setColumns(10);
		SRatio.setBounds(579, 175, 56, 20);
		contentPane.add(SRatio);

		Ratio = new JTextField();
		Ratio.setEditable(false);
		Ratio.setText(" :");
		Ratio.setBounds(597, 139, 15, 20);
		contentPane.add(Ratio);
		Ratio.setColumns(10);
	}

}
