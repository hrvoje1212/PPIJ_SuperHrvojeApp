package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;

import facebook.myFBPost;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewComment extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					NewComment frame = new NewComment();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewComment(final myFBPost post) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		final JTextPane textPane = new JTextPane();
		contentPane.add(textPane, BorderLayout.CENTER);
		
		JButton btnKomentiraj = new JButton("Komentiraj");
		btnKomentiraj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home.CLIENT.postComment(post.self.getId(), textPane.getText());
			}
		});
		contentPane.add(btnKomentiraj, BorderLayout.SOUTH);
	}

}
