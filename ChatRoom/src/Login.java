import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame {
	private JTextField user, pass;
	private JPanel u, p, b;
	private Container c;
	private JLabel ID, password;
	private JButton login, register;
	static String accountName;

	public Login() {
		super("��¼");
		Constant.mapPass.put(123, "123");
		Constant.mapUser.put(123, "wu");
		c = getContentPane();
		u = new JPanel();
		p = new JPanel();
		b = new JPanel();
		u.setLayout(new BorderLayout());
		p.setLayout(new BorderLayout());
		ID = new JLabel("�˺�");
		user = new JTextField();
		u.add(ID, BorderLayout.WEST);
		u.add(user, BorderLayout.CENTER);

		password = new JLabel("����");
		pass = new JTextField();

		p.add(password, BorderLayout.WEST);
		p.add(pass, BorderLayout.CENTER);
		login = new JButton("��¼");
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				int accountId = Integer.parseInt(user.getText());
				accountName=Constant.mapUser.get(accountId);
				System.out.println(accountName);
				if (!Constant.mapPass.containsKey(accountId)) {
					JOptionPane.showMessageDialog(c, "���˺���δע�ᣡ", "����", JOptionPane.ERROR_MESSAGE);
				} else if (!Constant.mapPass.get(accountId).equals(pass.getText())) {
					JOptionPane.showMessageDialog(c, "�˺������벻һ�£�", "����", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(c, "�û�"+accountName+"��½�ɹ���");
					
					Thread t=new Thread(){
						public void run() {
							Client c=new Client();
							
						}
					};
					t.start();
				}
                 }catch(NumberFormatException ex){
                	 JOptionPane.showMessageDialog(c, "�����������˺ţ�", "����", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		register = new JButton("ע��");
		register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Register r = new Register();

			}
		});
		b.add(login);
		b.add(register);

		c.add(u, BorderLayout.NORTH);
		c.add(p, BorderLayout.CENTER);
		c.add(b, BorderLayout.SOUTH);
		setSize(250, 120);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public static void main(String[] args) {
		Login a = new Login();
	}

}
