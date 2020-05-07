package pak2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

import pak1.Project;
import pak1.QNRFTest;
import pak1.Researcher;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JTextArea;

@SuppressWarnings({ "serial", "unused" })
public class CostOfAProject extends JFrame {

	private JPanel contentPane;
	private JTextField ID;
	private JList<Integer> Projects;
	DefaultListModel<Integer> ClistModel=new DefaultListModel<Integer>();
	DefaultListModel<String> SlistModel=new DefaultListModel<String>();
	private JTextArea Output;


	public CostOfAProject(final QNRFTest QNRFTest) {
		setResizable(false);
		setTitle("Display personnel cost of a project");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 692, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Display");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ID.getText().matches("\\d+"))
				{
					String S= new String("");
					boolean Check1=false;
					int x=0,i = Integer.parseInt(ID.getText());
					for(; x<QNRFTest.getProjects().size();x++)
						if(QNRFTest.getProjects().get(x).getId() == i)
						{Check1=true;break;}
					if(Check1)
					{
						S+=(QNRFTest.getProjects().get(x).toString()+"\n");
						for(Researcher researchers : QNRFTest.getProjects().get(x).getTeam())
						{
							S+=(researchers.toString()+"Payment :"+researchers.getPayment(QNRFTest.getProjects().get(x))+"\n\n");

						}


					}
					else 
						S+=("Invalid ID");

					Output.setText(S);

				}
				else
					Output.setText("Enter ID");
					
			}
		});
		btnNewButton.setForeground(Color.MAGENTA);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(345, 10, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Enter The ID Of Project:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(21, 14, 135, 14);
		contentPane.add(lblNewLabel);

		ID = new JTextField();
		ID.setBounds(166, 11, 169, 20);
		contentPane.add(ID);
		ID.setColumns(10);
		ClistModel.clear();
		for( Project project : QNRFTest.getProjects())
			ClistModel.addElement(project.getId());
		Projects = new JList<Integer>(ClistModel);
		Projects.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Projects.setBounds(10, 42, 117, 358);
		JScrollPane scrollPane = new JScrollPane(Projects);
		scrollPane.setBounds(10, 42, 117, 358);
		scrollPane.setVisible(true);
		contentPane.add(scrollPane);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(137, 39, 539, 373);
		scrollPane_1.setVisible(true);
		contentPane.add(scrollPane_1);

		Output = new JTextArea();
		scrollPane_1.setViewportView(Output);


	}

}
