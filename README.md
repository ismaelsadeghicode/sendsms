# sendsms

### SendMessage with wsdl

- Request
'''
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:tem="http://tempuri.org/">
   <soap:Header/>
   <soap:Body>
      <tem:XmsRequest>
         <tem:requestData><![CDATA[<xmsrequest>
<userid>****</userid>
<password>****</password>
<action>****</action>
<body>
<type>oto</type>
<recipient mobile="****"  originator="****">****r</recipient>
</body>
</xmsrequest>]]></tem:requestData>
      </tem:XmsRequest>
   </soap:Body>
</soap:Envelope>
''''

Response:
'''
<?xml version="1.0" encoding="utf-8"?>
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
    <soap:Body>
        <XmsRequestResponse xmlns="http://tempuri.org/">
            <XmsRequestResult xsi:type="xsd:string">&lt;xmsresponse&gt;
				&lt;userid&gt;****&lt;/userid&gt;
				&lt;action&gt;****d&lt;/action&gt;
				&lt;code id="0"&gt;ok&lt;/code&gt;
				&lt;body&gt;&lt;recipient mobile="****" ml="1" doerid="0" status="40"&gt;****&lt;/recipient&gt;&lt;/body&gt;
			&lt;/xmsresponse&gt;</XmsRequestResult>
        </XmsRequestResponse>
    </soap:Body>
</soap:Envelope>

'''
