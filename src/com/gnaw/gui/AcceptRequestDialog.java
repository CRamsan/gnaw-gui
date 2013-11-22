package com.gnaw.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dialog.ModalityType;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.gnaw.GnawApplication;
import com.gnaw.request.Request;
import com.gnaw.response.Response;

public class AcceptRequestDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public AcceptRequestDialog(final GnawApplication application, final Request request) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel label = new JLabel(request.getProfile());

		JLabel label_1 = new JLabel(request.getFileName());

		JLabel lblDoYouWant = new JLabel("Do you want to accetp this file?");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPanel
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								gl_contentPanel
										.createParallelGroup(Alignment.LEADING)
										.addComponent(label)
										.addComponent(label_1)
										.addComponent(lblDoYouWant))
						.addContainerGap(354, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPanel.createSequentialGroup().addContainerGap()
						.addComponent(label)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(label_1).addGap(18)
						.addComponent(lblDoYouWant)
						.addContainerGap(179, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Accept");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						application.sendOfferResponse(request.getAddress(), true, request.getFileName(), request.getToken());
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Decline");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						application.sendOfferResponse(request.getAddress(), false, null, null);
					}
				});
				buttonPane.add(cancelButton);
			}
		}
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setVisible(true);
	}
}
