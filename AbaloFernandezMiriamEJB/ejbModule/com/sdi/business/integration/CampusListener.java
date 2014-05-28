package com.sdi.business.integration;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import com.sdi.business.UsuariosService;
import com.sdi.business.exception.BusinessException;
import com.sdi.infrastructure.Factories;

@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destination", propertyValue = "topic/togepi") })
public class CampusListener implements MessageListener {

	public void onMessage(Message msg) {
		try {
			process((MapMessage) msg);
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	private void process(MapMessage msg) throws BusinessException, JMSException {
		UsuariosService service = Factories.services.createUsuariosService();
		service.incrementCounter(msg.getString("id"));
	}
}
