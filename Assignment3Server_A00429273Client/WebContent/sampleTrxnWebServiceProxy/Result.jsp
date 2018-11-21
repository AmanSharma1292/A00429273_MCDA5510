<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleTrxnWebServiceProxyid" scope="session" class="com.mcds5510.service.TrxnWebServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleTrxnWebServiceProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleTrxnWebServiceProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleTrxnWebServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.mcds5510.service.TrxnWebService getTrxnWebService10mtemp = sampleTrxnWebServiceProxyid.getTrxnWebService();
if(getTrxnWebService10mtemp == null){
%>
<%=getTrxnWebService10mtemp %>
<%
}else{
        if(getTrxnWebService10mtemp!= null){
        String tempreturnp11 = getTrxnWebService10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        sampleTrxnWebServiceProxyid.test();
break;
case 16:
        gotMethod = true;
        String createdBy_2id=  request.getParameter("createdBy21");
            java.lang.String createdBy_2idTemp = null;
        if(!createdBy_2id.equals("")){
         createdBy_2idTemp  = createdBy_2id;
        }
        String cardType_3id=  request.getParameter("cardType23");
            java.lang.String cardType_3idTemp = null;
        if(!cardType_3id.equals("")){
         cardType_3idTemp  = cardType_3id;
        }
        String id_4id=  request.getParameter("id25");
            java.lang.String id_4idTemp = null;
        if(!id_4id.equals("")){
         id_4idTemp  = id_4id;
        }
        String quantity_5id=  request.getParameter("quantity27");
        int quantity_5idTemp  = Integer.parseInt(quantity_5id);
        String expDate_6id=  request.getParameter("expDate29");
            java.lang.String expDate_6idTemp = null;
        if(!expDate_6id.equals("")){
         expDate_6idTemp  = expDate_6id;
        }
        String nameOnCard_7id=  request.getParameter("nameOnCard31");
            java.lang.String nameOnCard_7idTemp = null;
        if(!nameOnCard_7id.equals("")){
         nameOnCard_7idTemp  = nameOnCard_7id;
        }
        String unitPrice_8id=  request.getParameter("unitPrice33");
        double unitPrice_8idTemp  = Double.parseDouble(unitPrice_8id);
        String totalPrice_9id=  request.getParameter("totalPrice35");
        double totalPrice_9idTemp  = Double.parseDouble(totalPrice_9id);
        String createdOn_10id=  request.getParameter("createdOn37");
            java.lang.String createdOn_10idTemp = null;
        if(!createdOn_10id.equals("")){
         createdOn_10idTemp  = createdOn_10id;
        }
        String cardNumber_11id=  request.getParameter("cardNumber39");
            java.lang.String cardNumber_11idTemp = null;
        if(!cardNumber_11id.equals("")){
         cardNumber_11idTemp  = cardNumber_11id;
        }
        %>
        <jsp:useBean id="com1mcds55101entity1Transaction_1id" scope="session" class="com.mcds5510.entity.Transaction" />
        <%
        com1mcds55101entity1Transaction_1id.setCreatedBy(createdBy_2idTemp);
        com1mcds55101entity1Transaction_1id.setCardType(cardType_3idTemp);
        com1mcds55101entity1Transaction_1id.setId(id_4idTemp);
        com1mcds55101entity1Transaction_1id.setQuantity(quantity_5idTemp);
        com1mcds55101entity1Transaction_1id.setExpDate(expDate_6idTemp);
        com1mcds55101entity1Transaction_1id.setNameOnCard(nameOnCard_7idTemp);
        com1mcds55101entity1Transaction_1id.setUnitPrice(unitPrice_8idTemp);
        com1mcds55101entity1Transaction_1id.setTotalPrice(totalPrice_9idTemp);
        com1mcds55101entity1Transaction_1id.setCreatedOn(createdOn_10idTemp);
        com1mcds55101entity1Transaction_1id.setCardNumber(cardNumber_11idTemp);
        sampleTrxnWebServiceProxyid.updateTrxns(com1mcds55101entity1Transaction_1id);
break;
case 41:
        gotMethod = true;
        String id_12id=  request.getParameter("id44");
            java.lang.String id_12idTemp = null;
        if(!id_12id.equals("")){
         id_12idTemp  = id_12id;
        }
        sampleTrxnWebServiceProxyid.removeTrxns(id_12idTemp);
break;
case 46:
        gotMethod = true;
        String createdBy_14id=  request.getParameter("createdBy71");
            java.lang.String createdBy_14idTemp = null;
        if(!createdBy_14id.equals("")){
         createdBy_14idTemp  = createdBy_14id;
        }
        String cardType_15id=  request.getParameter("cardType73");
            java.lang.String cardType_15idTemp = null;
        if(!cardType_15id.equals("")){
         cardType_15idTemp  = cardType_15id;
        }
        String id_16id=  request.getParameter("id75");
            java.lang.String id_16idTemp = null;
        if(!id_16id.equals("")){
         id_16idTemp  = id_16id;
        }
        String quantity_17id=  request.getParameter("quantity77");
        int quantity_17idTemp  = Integer.parseInt(quantity_17id);
        String expDate_18id=  request.getParameter("expDate79");
            java.lang.String expDate_18idTemp = null;
        if(!expDate_18id.equals("")){
         expDate_18idTemp  = expDate_18id;
        }
        String nameOnCard_19id=  request.getParameter("nameOnCard81");
            java.lang.String nameOnCard_19idTemp = null;
        if(!nameOnCard_19id.equals("")){
         nameOnCard_19idTemp  = nameOnCard_19id;
        }
        String unitPrice_20id=  request.getParameter("unitPrice83");
        double unitPrice_20idTemp  = Double.parseDouble(unitPrice_20id);
        String totalPrice_21id=  request.getParameter("totalPrice85");
        double totalPrice_21idTemp  = Double.parseDouble(totalPrice_21id);
        String createdOn_22id=  request.getParameter("createdOn87");
            java.lang.String createdOn_22idTemp = null;
        if(!createdOn_22id.equals("")){
         createdOn_22idTemp  = createdOn_22id;
        }
        String cardNumber_23id=  request.getParameter("cardNumber89");
            java.lang.String cardNumber_23idTemp = null;
        if(!cardNumber_23id.equals("")){
         cardNumber_23idTemp  = cardNumber_23id;
        }
        %>
        <jsp:useBean id="com1mcds55101entity1Transaction_13id" scope="session" class="com.mcds5510.entity.Transaction" />
        <%
        com1mcds55101entity1Transaction_13id.setCreatedBy(createdBy_14idTemp);
        com1mcds55101entity1Transaction_13id.setCardType(cardType_15idTemp);
        com1mcds55101entity1Transaction_13id.setId(id_16idTemp);
        com1mcds55101entity1Transaction_13id.setQuantity(quantity_17idTemp);
        com1mcds55101entity1Transaction_13id.setExpDate(expDate_18idTemp);
        com1mcds55101entity1Transaction_13id.setNameOnCard(nameOnCard_19idTemp);
        com1mcds55101entity1Transaction_13id.setUnitPrice(unitPrice_20idTemp);
        com1mcds55101entity1Transaction_13id.setTotalPrice(totalPrice_21idTemp);
        com1mcds55101entity1Transaction_13id.setCreatedOn(createdOn_22idTemp);
        com1mcds55101entity1Transaction_13id.setCardNumber(cardNumber_23idTemp);
        com.mcds5510.entity.Transaction resetTrxn46mtemp = sampleTrxnWebServiceProxyid.resetTrxn(com1mcds55101entity1Transaction_13id);
if(resetTrxn46mtemp == null){
%>
<%=resetTrxn46mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">createdBy:</TD>
<TD>
<%
if(resetTrxn46mtemp != null){
java.lang.String typecreatedBy49 = resetTrxn46mtemp.getCreatedBy();
        String tempResultcreatedBy49 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecreatedBy49));
        %>
        <%= tempResultcreatedBy49 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cardType:</TD>
<TD>
<%
if(resetTrxn46mtemp != null){
java.lang.String typecardType51 = resetTrxn46mtemp.getCardType();
        String tempResultcardType51 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecardType51));
        %>
        <%= tempResultcardType51 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(resetTrxn46mtemp != null){
java.lang.String typeid53 = resetTrxn46mtemp.getId();
        String tempResultid53 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeid53));
        %>
        <%= tempResultid53 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">quantity:</TD>
<TD>
<%
if(resetTrxn46mtemp != null){
%>
<%=resetTrxn46mtemp.getQuantity()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">expDate:</TD>
<TD>
<%
if(resetTrxn46mtemp != null){
java.lang.String typeexpDate57 = resetTrxn46mtemp.getExpDate();
        String tempResultexpDate57 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeexpDate57));
        %>
        <%= tempResultexpDate57 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nameOnCard:</TD>
<TD>
<%
if(resetTrxn46mtemp != null){
java.lang.String typenameOnCard59 = resetTrxn46mtemp.getNameOnCard();
        String tempResultnameOnCard59 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenameOnCard59));
        %>
        <%= tempResultnameOnCard59 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">unitPrice:</TD>
<TD>
<%
if(resetTrxn46mtemp != null){
%>
<%=resetTrxn46mtemp.getUnitPrice()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">totalPrice:</TD>
<TD>
<%
if(resetTrxn46mtemp != null){
%>
<%=resetTrxn46mtemp.getTotalPrice()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">createdOn:</TD>
<TD>
<%
if(resetTrxn46mtemp != null){
java.lang.String typecreatedOn65 = resetTrxn46mtemp.getCreatedOn();
        String tempResultcreatedOn65 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecreatedOn65));
        %>
        <%= tempResultcreatedOn65 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cardNumber:</TD>
<TD>
<%
if(resetTrxn46mtemp != null){
java.lang.String typecardNumber67 = resetTrxn46mtemp.getCardNumber();
        String tempResultcardNumber67 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecardNumber67));
        %>
        <%= tempResultcardNumber67 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 91:
        gotMethod = true;
        String id_24id=  request.getParameter("id94");
            java.lang.String id_24idTemp = null;
        if(!id_24id.equals("")){
         id_24idTemp  = id_24id;
        }
        sampleTrxnWebServiceProxyid.getSingleTrxn(id_24idTemp);
break;
case 96:
        gotMethod = true;
        String createdBy_26id=  request.getParameter("createdBy101");
            java.lang.String createdBy_26idTemp = null;
        if(!createdBy_26id.equals("")){
         createdBy_26idTemp  = createdBy_26id;
        }
        String cardType_27id=  request.getParameter("cardType103");
            java.lang.String cardType_27idTemp = null;
        if(!cardType_27id.equals("")){
         cardType_27idTemp  = cardType_27id;
        }
        String id_28id=  request.getParameter("id105");
            java.lang.String id_28idTemp = null;
        if(!id_28id.equals("")){
         id_28idTemp  = id_28id;
        }
        String quantity_29id=  request.getParameter("quantity107");
        int quantity_29idTemp  = Integer.parseInt(quantity_29id);
        String expDate_30id=  request.getParameter("expDate109");
            java.lang.String expDate_30idTemp = null;
        if(!expDate_30id.equals("")){
         expDate_30idTemp  = expDate_30id;
        }
        String nameOnCard_31id=  request.getParameter("nameOnCard111");
            java.lang.String nameOnCard_31idTemp = null;
        if(!nameOnCard_31id.equals("")){
         nameOnCard_31idTemp  = nameOnCard_31id;
        }
        String unitPrice_32id=  request.getParameter("unitPrice113");
        double unitPrice_32idTemp  = Double.parseDouble(unitPrice_32id);
        String totalPrice_33id=  request.getParameter("totalPrice115");
        double totalPrice_33idTemp  = Double.parseDouble(totalPrice_33id);
        String createdOn_34id=  request.getParameter("createdOn117");
            java.lang.String createdOn_34idTemp = null;
        if(!createdOn_34id.equals("")){
         createdOn_34idTemp  = createdOn_34id;
        }
        String cardNumber_35id=  request.getParameter("cardNumber119");
            java.lang.String cardNumber_35idTemp = null;
        if(!cardNumber_35id.equals("")){
         cardNumber_35idTemp  = cardNumber_35id;
        }
        %>
        <jsp:useBean id="com1mcds55101entity1Transaction_25id" scope="session" class="com.mcds5510.entity.Transaction" />
        <%
        com1mcds55101entity1Transaction_25id.setCreatedBy(createdBy_26idTemp);
        com1mcds55101entity1Transaction_25id.setCardType(cardType_27idTemp);
        com1mcds55101entity1Transaction_25id.setId(id_28idTemp);
        com1mcds55101entity1Transaction_25id.setQuantity(quantity_29idTemp);
        com1mcds55101entity1Transaction_25id.setExpDate(expDate_30idTemp);
        com1mcds55101entity1Transaction_25id.setNameOnCard(nameOnCard_31idTemp);
        com1mcds55101entity1Transaction_25id.setUnitPrice(unitPrice_32idTemp);
        com1mcds55101entity1Transaction_25id.setTotalPrice(totalPrice_33idTemp);
        com1mcds55101entity1Transaction_25id.setCreatedOn(createdOn_34idTemp);
        com1mcds55101entity1Transaction_25id.setCardNumber(cardNumber_35idTemp);
        sampleTrxnWebServiceProxyid.createTrxns(com1mcds55101entity1Transaction_25id);
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>