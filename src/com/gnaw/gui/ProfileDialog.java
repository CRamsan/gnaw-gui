package com.gnaw.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.gnaw.Profile;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class ProfileDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel label;
	private JComponent parent;
	private JLabel lblName;
	private JPanel buttonPane;
	private JButton okButton;

	/**
	 * Create the dialog.
	 */
	public ProfileDialog(Profile profile) {
		setResizable(false);
		setBounds(100, 100, 464, 120);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			lblName = new JLabel("Name:");
		}
		{
			label = new JLabel("");
		}
		this.label.setText(profile.getName());
		{
			buttonPane = new JPanel();
			{
				okButton = new JButton("OK");
				okButton.setVerticalAlignment(SwingConstants.BOTTOM);
				okButton.setHorizontalAlignment(SwingConstants.TRAILING);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
		}
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout
				.createParallelGroup(Alignment.LEADING)
				.addComponent(buttonPane, GroupLayout.DEFAULT_SIZE, 512,
						Short.MAX_VALUE)
				.addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, 460,
						Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				groupLayout
						.createSequentialGroup()
						.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 99,
								Short.MAX_VALUE)
						.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)));
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPanel.add(lblName);
		contentPanel.add(label);
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		buttonPane.add(okButton);
		getContentPane().setLayout(groupLayout);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
	}
}
