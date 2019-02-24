package xms;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.tempuri.Sms;
import org.tempuri.SmsSoap;
import org.tempuri.XmsRequestResponse;

import javax.xml.ws.BindingProvider;

public class SmsSender {

    private String username = null;
    private String pass = null;

    public SmsSender() {
    }

    public SmsSender(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }

    public Boolean sendSms(String mobile, String message) {
        Element rootElement = new Element("xmsrequest");
        Document doc = new Document(rootElement);
        doc.setRootElement(rootElement);

        Element firstname = new Element("userid");
        firstname.addContent(username);
        rootElement.addContent(firstname);

        Element password = new Element("password");
        password.addContent(pass);
        rootElement.addContent(password);

        Element action = new Element("action");
        action.addContent("smssend");
        rootElement.addContent(action);

        Element body = new Element("body");
        body.addContent(new Element("type").setText("oto"));
        Element recipient = new Element("recipient");
        recipient.setAttribute(new Attribute("mobile", mobile));
        recipient.setAttribute(new Attribute("originator", "50005780"));
        recipient.addContent(message);
        body.addContent(recipient);
        rootElement.addContent(body);

        XMLOutputter outter = new XMLOutputter();
        outter.setFormat(Format.getPrettyFormat());

        System.out.println();
        SmsSoap smsSoap = new Sms().getPort(SmsSoap.class);
        ((BindingProvider) smsSoap).getRequestContext()
                .put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://ws.smartsms.ir/sms.asmx?wsdl");
        XmsRequestResponse xmsRequestResponse = new XmsRequestResponse();
        xmsRequestResponse.setXmsRequestResult(smsSoap.xmsRequest(outter.outputString(doc).toString().replaceAll("\\<\\?xml(.+?)\\?\\>", "").trim()));

        if (xmsRequestResponse.getXmsRequestResult().toString().contains("ok")) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
