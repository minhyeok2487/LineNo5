package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame {

	public static void main(String[] args) {
		JFrame jframe=new JFrame();
		
		JPanel jpanel=new JPanel();
		JPanel btnpanel=new JPanel();
		
		JLabel jlabel=new JLabel("asdasd");
		
		JButton btn1=new JButton("click me!!");
		JButton btn2=new JButton("exit");
		
		JTextArea jta=new JTextArea();
		JTextField jtf=new JTextField(200);
		
		jpanel.setLayout(new BorderLayout());
		
		btnpanel.add(btn1);
		btnpanel.add(btn2);
		
		jpanel.add(jta,BorderLayout.CENTER);
		jpanel.add(jlabel,BorderLayout.NORTH);
		jpanel.add(btnpanel,BorderLayout.WEST);
		
//		jpanel.add(new JLabel("가나다라"));//패널에 라벨 추가
		
		jframe.add(jpanel);//프레임에 패널 추가
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				jta.append("get out!!");
				jlabel.setText(jta.getText());
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		jframe.setResizable(false);//프레임 크기 고정 시키기
		jframe.setVisible(true);
		jframe.setSize(540,440);
		jframe.setLocationRelativeTo(null);//프레임 가운데 출력하기
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
