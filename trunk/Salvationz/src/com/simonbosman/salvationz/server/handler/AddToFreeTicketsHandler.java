package com.simonbosman.salvationz.server.handler;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

import com.allen_sauer.gwt.log.client.Log;
import com.simonbosman.salvationz.shared.rpc.AddToFreeTickets;
import com.simonbosman.salvationz.shared.rpc.VoidResult;

/**
 * @author ubuntu
 *
 */
public class AddToFreeTicketsHandler implements
		ActionHandler<AddToFreeTickets, VoidResult> {

	@Override
	public VoidResult execute(final AddToFreeTickets action,
			final ExecutionContext context) throws ActionException {
		if (action.getEmail().equalsIgnoreCase("Emailadress")) {
			return VoidResult.VOID;
		}

		final Properties props = new Properties();
		final Session session = Session.getDefaultInstance(props, null);

		final String msgBody = "mr. mail says: "
				+ "Salvationz bezoeker met emailadres " + action.getEmail()
				+ " wil graag een free ticket winnen. ";

		try {

			final Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("simonbosman@gmail.com",
					"mr. mail"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					"simonbosman@hotmail.com", "mr. mail"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					"freetickets@salvationz.nl", "mr. mail"));
			message.setSubject("salvationz freeticket for " + action.getEmail());
			message.setText(msgBody);
			Transport.send(message);

		} catch (final AddressException e) {
			e.printStackTrace();
			Log.error("Wrong emailadress", e);
		} catch (final MessagingException e) {
			e.printStackTrace();
			Log.error("Wrong message", e);
		} catch (final UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.error("Wrong encoding", e);
		}

		return VoidResult.VOID;

	}

	@Override
	public Class<AddToFreeTickets> getActionType() {
		return AddToFreeTickets.class;
	}

	@Override
	public void rollback(final AddToFreeTickets arg0, final VoidResult arg1,
			final ExecutionContext arg2) throws ActionException {
		// TODO Auto-generated method stub

	}

}
