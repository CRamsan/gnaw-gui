package com.gnaw.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import com.gnaw.GnawApplication;
import com.gnaw.interfaces.TransmissionProgressInterface;
import com.gnaw.request.Request;
import com.gnaw.request.Request.Action;
import com.gnaw.response.Response;

public class ProgressDialogSender extends JDialog implements
		TransmissionProgressInterface {

	private final JPanel contentPanel = new JPanel();
	private JProgressBar progressBar;

	/**
	 * Create the dialog.
	 */
	public ProgressDialogSender(Request request, GnawApplication application) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		if (request.getAction().equals(Action.ACCEPT)) {
			progressBar = new JProgressBar();
			GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
			gl_contentPanel
					.setHorizontalGroup(gl_contentPanel.createParallelGroup(
							Alignment.LEADING).addGroup(
							gl_contentPanel
									.createSequentialGroup()
									.addContainerGap()
									.addComponent(progressBar,
											GroupLayout.DEFAULT_SIZE, 412,
											Short.MAX_VALUE).addContainerGap()));
			gl_contentPanel.setVerticalGroup(gl_contentPanel
					.createParallelGroup(Alignment.LEADING).addGroup(
							gl_contentPanel
									.createSequentialGroup()
									.addContainerGap()
									.addComponent(progressBar,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addContainerGap(204, Short.MAX_VALUE)));
			contentPanel.setLayout(gl_contentPanel);

			application.sendPushRequest(request.getAddress(),
					request.getToken(), this);

		} else {
			JLabel lblTheUserRejected = new JLabel("The user rejected the file");
			contentPanel.add(lblTheUserRejected);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void setProgress(int status) {
		progressBar.setValue(status);
	}
}
