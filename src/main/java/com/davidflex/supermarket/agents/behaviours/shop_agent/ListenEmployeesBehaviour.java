package com.davidflex.supermarket.agents.behaviours.shop_agent;

import com.davidflex.supermarket.agents.shop.ShopAgent;
import com.davidflex.supermarket.ontologies.company.elements.RegisterWarehouse;
import jade.content.lang.Codec;
import jade.content.onto.OntologyException;
import jade.content.onto.basic.Action;
import jade.content.onto.basic.Done;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Listen to Warehouses and Drones messages.
 * Used by ShopAgent.
 */
public class ListenEmployeesBehaviour extends CyclicBehaviour {

    private static final Logger logger = LoggerFactory.getLogger(ListenEmployeesBehaviour.class);

    private MessageTemplate mtOnto;

    public ListenEmployeesBehaviour(Agent a) {
        super(a);
        mtOnto = MessageTemplate.MatchOntology(((ShopAgent) getAgent()).getCompanyOntology().getName());
    }

    @Override
    public void action() {
        ACLMessage msg = getAgent().receive(mtOnto);
        if (msg != null) {
            try {
                Action a = (Action) getAgent().getContentManager().extractContent(msg);
                if (a.getAction() instanceof RegisterWarehouse) {
                    // Register warehouse
                    logger.info("Registering warehouse: " + msg.getSender().getLocalName());
                    RegisterWarehouse rw = (RegisterWarehouse) a.getAction();
                    ((ShopAgent) getAgent()).registerWarehouse(rw.getWarehouse());
                    sendDone(msg.getSender(), a);
                } else {
                    logger.error("Wrong message received.");
                }
            } catch (Codec.CodecException | OntologyException e) {
                logger.error("Error at extracting message", e);
            }
        } else {
            block();
        }
    }

    /**
     * Sends list of available products to the customer.
     */
    private void sendDone(AID employee, Action action) {
        try {
            // Prepare message
            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
            msg.setSender(getAgent().getAID());
            msg.addReceiver(employee);
            msg.setLanguage(((ShopAgent) getAgent()).getCodec().getName());
            msg.setOntology(((ShopAgent) getAgent()).getCompanyOntology().getName());
            // Fill the content
            Done d = new Done(action);
            getAgent().getContentManager().fillContent(msg, d);
            // Send message
            getAgent().send(msg);
        } catch (Codec.CodecException | OntologyException e) {
            logger.error("Error filling msg.", e);
        }
    }
}
