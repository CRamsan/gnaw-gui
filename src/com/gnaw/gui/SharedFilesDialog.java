package com.gnaw.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dialog.ModalityType;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;

import com.gnaw.gui.file.FileSystemModel;
import com.gnaw.models.SharedFile;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SharedFilesDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTree tree;
	private JPanel buttonPane;

	/**
	 * Create the dialog.
	 */
	public SharedFilesDialog(SharedFile root) {
		setBounds(100, 100, 264, 318);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			tree = new JTree(new FileSystemModel(root));
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(tree, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(tree, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(buttonPane, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
				.addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		getContentPane().setLayout(groupLayout);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setVisible(true);
	}

}
