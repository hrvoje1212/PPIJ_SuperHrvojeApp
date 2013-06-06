package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JButton;

import com.restfb.types.Post;

import facebook.myFBComment;
import facebook.myFBPost;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpringLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;

public class Comments extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Comments frame = new Comments(new myFBPost(new Post()));
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
	public Comments(final myFBPost post) {
		
		Object[] data = Home.CLIENT.getCommentFromPost(post.self.getId()).toArray();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JTextArea textArea = new JTextArea();
		textArea.setText(post.self.getMessage());
		getContentPane().add(textArea, BorderLayout.NORTH);
		
		JList list = new JList(data);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				myFBComment comment = .get(list.locationToIndex(e.getPoint()));
//				textArea.setText(post.self.getMessage());
//				Comments frame = new Comments(post);
//				frame.setVisible(true);
			}
		});
		getContentPane().add(list, BorderLayout.WEST);
		
		JTextArea textArea_1 = new JTextArea();
		
		getContentPane().add(textArea_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Dodaj komentar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NewComment frame = new NewComment(post);
				frame.setVisible(true);
			}
		});
		getContentPane().add(btnNewButton, BorderLayout.EAST);

		
		
		
	}

}
