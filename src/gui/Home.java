package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import com.restfb.types.Post;
import com.restfb.types.User;

import facebook.FBClient;
import facebook.myFBPost;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Home {

	private JFrame frame;
	private JLabel txtUser;
	private User user;
	public static FBClient CLIENT;
	private JList komentari;
	private JTextArea textArea;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		CLIENT = new FBClient();
		user = CLIENT.getUser("me");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 671, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Object [] data;
		final List<myFBPost> myposts = new ArrayList<>();
		
		for(List<Post> pl : CLIENT.getPostConnection("PPIJFER"))
			for(Post post : pl){
				myposts.add(new myFBPost(post));
			}
			
		data = myposts.toArray();
		final JList statusi = new JList(data);
		statusi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myFBPost post = myposts.get(statusi.locationToIndex(e.getPoint()));
				textArea.setText(post.self.getMessage());
				Comments frame = new Comments(post);
				frame.setVisible(true);
			}
		});

		
		JScrollPane sp = new JScrollPane(statusi);
		frame.getContentPane().add(sp, BorderLayout.WEST);
		
		txtUser = new JLabel();
		txtUser.setText(user.getName());
		frame.getContentPane().add(txtUser, BorderLayout.NORTH);
		
		textArea = new JTextArea();
		frame.getContentPane().add(textArea, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("Napisi novi status");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NewStatus frame = new NewStatus();
				frame.setVisible(true);
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.CENTER);
		
	}

}
