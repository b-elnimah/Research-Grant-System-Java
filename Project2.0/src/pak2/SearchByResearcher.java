package pak2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pak1.QNRFTest;
import pak1.Researcher;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.JTextArea;



@SuppressWarnings("serial")
public class SearchByResearcher extends JFrame {
	

	private JPanel contentPane;
	DefaultListModel <Integer> ClistModel=new DefaultListModel<Integer>();
	DefaultListModel <String> SlistModel=new DefaultListModel<String>();
	private JTextField ID;
	JTextArea SList;

	public SearchByResearcher(final QNRFTest QNRFTest) {
		setTitle("Search By Researcher{");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		for(Researcher Researchers :  QNRFTest.getResearcher())
			ClistModel.addElement(Researchers.getId());

		JList<Integer> CList = new JList<Integer>(ClistModel);
		CList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		CList.setBounds(10, 11, 134, 330);
		JScrollPane scrollPane_1 = new JScrollPane(CList);
		scrollPane_1.setBounds(10, 11, 134, 330);
		contentPane.add(scrollPane_1);

		JButton Search = new JButton("Search");
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SlistModel.clear();
				String S= new String("");

				if(ID.getText().matches("\\d+"))
				{
					int id = Integer.parseInt(ID.getText());
					boolean cheak=true;
					for(Researcher Researchers :  QNRFTest.getResearcher())
						if(id == Researchers.getId())
						{
							cheak=false;
							
							for(int i=0; i<QNRFTest.getProjects().size();i++)
							{
								for(int j=0; j<QNRFTest.getProjects().get(i).getTeam().size();j++)
								{
									if(QNRFTest.getProjects().get(i).getTeam().get(j).getId()==Researchers.getId())
									{
										S+=(QNRFTest.getProjects().get(i).toString()+"\n\n");
									
									}
								}
							}

							break;
						}

					if(cheak)
					{
						S+=("ID Invalid(Non Found)");	

					}
				}
				else
					S+=("ID Invalid(Type MisMatch");
				SList.setText(S);


			}
		});
		Search.setBounds(10, 418, 134, 23);
		contentPane.add(Search);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(154, 11, 360, 430);
		
		contentPane.add(scrollPane);
		
		 SList = new JTextArea();
		scrollPane.setViewportView(SList);

		JLabel lblEnterId = new JLabel("Enter ID");
		lblEnterId.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblEnterId.setBounds(10, 362, 134, 14);
		contentPane.add(lblEnterId);

		ID = new JTextField();
		ID.setBounds(10, 387, 134, 20);
		contentPane.add(ID);
		ID.setColumns(10);
	}

}
