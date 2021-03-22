package test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class NumbersGUI {

	
	JFrame frame = new JFrame("Library");
	LinkedList<Integer> list = new LinkedList<Integer>(); 	
	
	
	public NumbersGUI() {
		
		JPanel top = new JPanel();
		JTextArea textarea = new JTextArea();
		JPanel bot = new JPanel();
		
		JLabel enter = new JLabel("Enter number: ");
		JTextField numberHolder = new JTextField();
		numberHolder.setColumns(15);
		
		
		JButton add = new JButton("add");
		
		top.add(enter);
		top.add(numberHolder);
		top.add(add);
		
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				int num = Integer.parseInt(numberHolder.getText());
				
				boolean pass = true;
				
				
				for(int elm: list) {
					
					
					pass = (num!=elm);
					
					if(!pass) break;
				}
				if(pass) {
					list.add(num);
				}
				
				
				textarea.setText(list.toString());
				
				numberHolder.setText(null);
				
			}
			
		});
		
		
		
		JButton sort = new JButton("sort");
		JButton shuffle = new JButton("shuffle");
		JButton reverse = new JButton("reverse");
		
		bot.add(reverse);
		bot.add(shuffle);
		bot.add(sort);
		
		
		sort.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
	
				list.sort(null);
				
				textarea.setText(list.toString());
			}
			
		});
		
		
		reverse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				LinkedList<Integer> reverseList = new LinkedList<Integer>();
				
				
				
				
				int size =list.size();
				
				for(int i = 0; i<size; i++) {
					reverseList.add(list.getLast());
					
					list.remove(list.getLast());
				}
				
				list = reverseList;
				
				
				
				
				
				textarea.setText(list.toString());
			}
			
		});
		
		
		shuffle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				

				LinkedList<Integer> list1 = new LinkedList<Integer>();
				LinkedList<Integer> list2 = new LinkedList<Integer>();
				LinkedList<Integer> list3 = new LinkedList<Integer>();
				
				
				
				
				int size =list.size();
				
				for(int i = 0; i<size; i++) {
					
					int shuffler = (int) (Math.round(Math.random()*3));
					
					if(shuffler==0) {
						list1.add(list.getLast());
					}else if(shuffler==2) {
						list2.add(list.getLast());
					}else {
						list3.add(list.getLast());
					}
					list.remove(list.getLast());
				}
				
				
				size =list1.size();

				for (int i = 0; i < size; i++) {

					list.add(list1.getLast());

					list1.remove(list1.getLast());
				}

				size = list2.size();

				for (int i = 0; i < size; i++) {

					list.add(list2.getLast());

					list2.remove(list2.getLast());
				}

				size = list3.size();

				for (int i = 0; i < size; i++) {

					list.add(list3.getLast());

					list3.remove(list3.getLast());
				}
				
				
				
				
				textarea.setText(list.toString());
			}
			
		});
		
		
		//frame
		
		frame.setLayout(new BorderLayout());
		frame.add(textarea, BorderLayout.CENTER);
		frame.add(top, BorderLayout.NORTH);

		frame.add(bot, BorderLayout.SOUTH);
		
		frame.setSize(700, 700);
//		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	
	
	public static void main(String[] args) {

		
		SwingUtilities.invokeLater( new Runnable() {
			@Override
			public void run(){
				
				new NumbersGUI();
			}
		});
	}

}
