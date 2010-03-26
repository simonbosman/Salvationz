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
import com.simonbosman.salvationz.shared.rpc.AddToNewsLetter;
import com.simonbosman.salvationz.shared.rpc.VoidResult;

/**
 * @author ubuntu
 *
 */
public class AddToNewsLetterHandler implements
		ActionHandler<AddToNewsLetter, VoidResult> {

	@Override
	public synchronized VoidResult execute(final AddToNewsLetter action,
			final ExecutionContext context) throws ActionException {

		Log.debug(action.getEmail());
		if (action.getEmail().equalsIgnoreCase("Emailadress")){
			return VoidResult.VOID;
		}

		final Properties props = new Properties();
		final Session session = Session.getDefaultInstance(props, null);

		final String msgBody = "mr. mail says: " + action.getName()
				+ " wil graag nieuws ontvangen op " + "emailadres "
				+ action.getEmail();

		try {

			final Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("simonbosman@gmail.com",
					"mr. mail"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					"simonbosman@hotmail.com", "mr. mail"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					"newsletter@salvationz.nl", "mr. mail"));
			message.setSubject("salvationz newsletter for " + action.getEmail());
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
	public Class<AddToNewsLetter> getActionType() {
		return AddToNewsLetter.class;
	}

	@Override
	public synchronized void rollback(final AddToNewsLetter arg0,
			final VoidResult arg1, final ExecutionContext arg2)
			throws ActionException {
		// TODO Auto-generated method stub

	}

}
