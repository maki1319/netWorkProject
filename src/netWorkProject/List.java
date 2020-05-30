package netWorkProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTree;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class List extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List frame = new List();
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
	public List() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 342, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("\u597D\u53CB\u5217\u8868") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("\u6211\u7684\u597D\u53CB");
						node_1.add(new DefaultMutableTreeNode("maki"));
						node_1.add(new DefaultMutableTreeNode("kkk"));
						node_1.add(new DefaultMutableTreeNode("red"));
						node_1.add(new DefaultMutableTreeNode("www"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("\u9ED1\u540D\u5355");
						node_1.add(new DefaultMutableTreeNode("bas"));
						node_1.add(new DefaultMutableTreeNode("soc"));
						node_1.add(new DefaultMutableTreeNode("foo"));
						node_1.add(new DefaultMutableTreeNode("hoc"));
					add(node_1);
					add(new DefaultMutableTreeNode("\u7FA4\u804A"));
				}
			}
		));
		tree.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				if(e.getClickCount()==2&&e.getButton()==1){//判断当用户鼠标左键双击时应该执行代码
					DefaultMutableTreeNode  yourChoice=(DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();//通过jtree方法获取当前鼠标双击的是哪一个节点
				    if(((DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent()).isLeaf()) {
						JOptionPane.showMessageDialog(null, "将要和"+yourChoice+"聊天","java",JOptionPane.INFORMATION_MESSAGE);
						dispose();
						ClientTalkDialog client=new ClientTalkDialog();
						client.setVisible(true);
						
					}
						}
			}
		});
	
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(tree, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(48, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tree, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(66, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}


}
