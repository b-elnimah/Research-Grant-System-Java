package pak2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;

import pak1.Faculty;
import pak1.Project;
import pak1.QNRFTest;
import pak1.Researcher;

import java.awt.Color;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
@SuppressWarnings("serial")
public class PaymentForAResearcher extends JFrame {

	private JPanel contentPane;
	private JTextField Payment;
	private JTextField ID;
	private JList<Integer> clist;
	private static ArrayList<Researcher> ResearchersC= new ArrayList<Researcher>();
	DefaultListModel<Integer> ClistModel=new DefaultListModel<Integer>();
	DefaultListModel<String> SlistModel=new DefaultListModel<String>();
	JTextArea List;


	public PaymentForAResearcher(final QNRFTest QNRFTest_1) {
		for(Researcher Researchers :  QNRFTest_1.getResearcher())
			ResearchersC.add(Researchers);
		setTitle("Payment For A Researcher");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Payment = new JTextField();
		Payment.setEditable(false);
		Payment.setBounds(472, 294, 102, 23);
		contentPane.add(Payment);
		Payment.setColumns(10);

		JButton btnPaymentForAll = new JButton("Payment");
		btnPaymentForAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double payment=0;

				String S= new String("");
				if(ID.getText().matches("\\d+"))
				{
					int id=Integer.parseInt(ID.getText());
					for(Project p: QNRFTest_1.getProjects() )
						for(Researcher r:  p.getTeam())
							if(id==r.getId())
							{ 
								S+=p.toString()+"\n"+r.toString()+"\nPayment= "+r.getPayment(p)+"\n\n";
								if(r instanceof Faculty)
									if(r.getPayment(p) >payment)
										payment=r.getPayment(p);
									else
									{}
								else
									payment=+r.getPayment(p);

							}
				}
				else
					S=("Invalid Id(Type MisMatch)");

				List.setText(S);
				Payment.setText(String.valueOf(payment));
			}
		});
		btnPaymentForAll.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPaymentForAll.setBounds(297, 294, 165, 23);
		contentPane.add(btnPaymentForAll);

		ID = new JTextField();
		ID.setColumns(10);
		ID.setBounds(167, 294, 124, 23);
		contentPane.add(ID);

		JLabel lblNewLabel = new JLabel("Enter Researcher ID:");
		lblNewLabel.setForeground(new Color(75, 0, 130));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(0, 290, 174, 27);
		contentPane.add(lblNewLabel);
		ClistModel.clear();
		for(Researcher r: ResearchersC )
			ClistModel.addElement(r.getId());
		clist = new JList<Integer>(ClistModel);
		clist.setBounds(10, 11, 155, 268);
		JScrollPane scrollPane = new JScrollPane(clist);
		scrollPane.setBounds(10, 11, 155, 268);
		contentPane.add(scrollPane);

		List = new JTextArea();
		List.setEditable(false);
		List.setBounds(175, 11, 399, 272);
		JScrollPane scrollPane_1 = new JScrollPane(List);
		scrollPane_1.setBounds(175, 11, 399, 272);
		contentPane.add(scrollPane_1);
	}
}
