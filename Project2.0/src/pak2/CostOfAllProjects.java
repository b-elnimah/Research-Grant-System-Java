package pak2;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;




import pak1.QNRFTest;

import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class CostOfAllProjects extends JFrame {

	private JPanel contentPane;
	DefaultListModel<String> ClistModel=new DefaultListModel<String>();
	
	
	
	public CostOfAllProjects(final QNRFTest QNRFTest) {
		setResizable(false);
		setTitle("Display personnel cost of all projects");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea Clist = new JTextArea(QNRFTest.CostOfAllProjects());
		Clist.setEditable(false);
		Clist.setBounds(10, 11, 414, 280);
		
		JScrollPane scrollPane_1 = new JScrollPane(Clist);
		scrollPane_1.setBounds(10, 11, 474, 400);
		scrollPane_1.setVisible(true);
		contentPane.add(scrollPane_1);
		
		ClistModel.addElement(QNRFTest.CostOfAllProjects());
	}
}
