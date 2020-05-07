package pak2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.JSeparator;

import java.awt.Color;

import javax.swing.ButtonGroup;

import pak1.QNRFTest;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class QNRF extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton rdbtnNewRadioButton;
	JRadioButton rdbtnNewRadioButton_1;
	NewUREP newUREP;
	NewNPRP newNPRP;
	QNRFTest QNRFTest_1;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QNRF frame = new QNRF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QNRF(QNRFTest QNRFTest) {
		QNRFTest_1= QNRFTest;
		setResizable(false);
		setFont(new Font("Tahoma", Font.BOLD, 14));
		setTitle("QNRF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add A New Project");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				if(rdbtnNewRadioButton.isSelected()){
				
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								NewUREP frame = new NewUREP(QNRFTest_1);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				
				
				
				}
				if(rdbtnNewRadioButton_1.isSelected()){
				
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								NewNPRP frame = new NewNPRP(QNRFTest_1);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				
				
				
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(10, 59, 295, 36);
		contentPane.add(btnNewButton);
		
		JButton btnAddANew = new JButton("Add A New Researcher");
		btnAddANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							NewResearcher frame = new NewResearcher(QNRFTest_1);
							frame.setVisible(true);
					
				
			}
		});
		btnAddANew.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddANew.setBounds(10, 113, 295, 36);
		contentPane.add(btnAddANew);
		
		JButton btnSearchByResearcher = new JButton("Search By Researcher");
		btnSearchByResearcher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SearchByResearcher frame = new SearchByResearcher(QNRFTest_1);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnSearchByResearcher.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearchByResearcher.setBounds(10, 174, 295, 36);
		contentPane.add(btnSearchByResearcher);
		
		JButton btnDisplayPersonnelCost = new JButton("Display personnel cost of a project");
		btnDisplayPersonnelCost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CostOfAProject frame = new CostOfAProject(  QNRFTest_1);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnDisplayPersonnelCost.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDisplayPersonnelCost.setBounds(10, 234, 295, 36);
		contentPane.add(btnDisplayPersonnelCost);
		
		JButton btnLl = new JButton("Display personnel cost of all projects");
		btnLl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CostOfAllProjects frame = new CostOfAllProjects(QNRFTest_1);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnLl.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLl.setBounds(10, 295, 295, 36);
		contentPane.add(btnLl);
		
		JButton btnCalculatePaymentFor = new JButton("Calculate payment for a researcher");
		btnCalculatePaymentFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PaymentForAResearcher frame = new PaymentForAResearcher(QNRFTest_1);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnCalculatePaymentFor.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCalculatePaymentFor.setBounds(10, 355, 295, 36);
		contentPane.add(btnCalculatePaymentFor);
		
		rdbtnNewRadioButton = new JRadioButton("New UREP Project");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnNewRadioButton.setBounds(10, 29, 148, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("New NPRP Project");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnNewRadioButton_1.setBounds(160, 29, 145, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 102, 295, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 161, 295, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 221, 295, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 281, 295, 2);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 342, 295, 2);
		contentPane.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 402, 295, 2);
		contentPane.add(separator_5);
		
		JButton Save = new JButton("Save Changes");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				QNRFTest_1.SaveFiles();
			}
		});
		Save.setFont(new Font("Tahoma", Font.BOLD, 14));
		Save.setBounds(10, 415, 295, 36);
		contentPane.add(Save);
	}
}
