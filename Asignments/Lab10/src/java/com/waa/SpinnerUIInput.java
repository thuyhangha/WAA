/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waa;

import java.io.IOException;
import java.util.Map;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

/**
 *
 * @author hangha
 */
@FacesComponent(createTag = true, namespace = "http://corejsf.com",
        tagName = "spinner", value = "com.corejsf.Spinner")
public class SpinnerUIInput extends UIInput{
    

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        String clientId = getClientId(context);

        // encodeInputField(writer, clientId);
        // encodeDecrementButton(writer, clientId);
        // encodeIncrementButton(writer, clientId);
    }

    @Override
    public void encodeEnd(FacesContext context) throws IOException {
        String clientId = getClientId(context);
        char sep = UINamingContainer.getSeparatorChar(context);
        encodeInputField(context, clientId + sep + "inputfield");
        encodeDecrementButton(context, clientId);
        encodeIncrementButton(context, clientId);
    }

    private void encodeInputField(FacesContext context, String clientId) throws IOException {
        ResponseWriter writer = context.getResponseWriter();

        if (clientId.contains("month")) {
            writer.writeText("Month", null);
        } else if (clientId.contains("year")) {
            writer.writeText("Year", null);
        } else {
            writer.writeText("Unknow Field", null);
        }

        writer.startElement("input", this);
        writer.writeAttribute("name", clientId, null);
        writer.writeAttribute("id", clientId, null);
        writer.writeAttribute("type", "text", null);

        Object v = getValue();
        if (v != null) {
            writer.writeAttribute("value", v, "value");
        }

        Object size = getAttributes().get("size");
        if (size != null) {
            writer.writeAttribute("size", size, "size");
        }

        writer.endElement("input");
    }

    private void encodeDecrementButton(FacesContext context, String clientId) throws
            IOException {
        ResponseWriter writer = context.getResponseWriter();
        char sep = UINamingContainer.getSeparatorChar(context);
        writer.startElement("input", this);
        writer.writeAttribute("type", "submit", null);
        writer.writeAttribute("name", clientId + sep + "inputfield" + sep + "LESS", null); // clientId + LESS
        writer.writeAttribute("value", "<", "value");
        writer.endElement("input");
    }

    private void encodeIncrementButton(FacesContext context, String clientId) throws
            IOException {
        ResponseWriter writer = context.getResponseWriter();
        char sep = UINamingContainer.getSeparatorChar(context);
        writer.startElement("input", this);
        writer.writeAttribute("type", "submit", null);
        writer.writeAttribute("name", clientId + sep + "inputfield" + sep + "MORE", null); // clientId + MORE
        writer.writeAttribute("value", ">", "value");
        writer.endElement("input");
    }

    @Override
    public void decode(FacesContext context) {
        Map<String, String> requestMap
                = context.getExternalContext().getRequestParameterMap();
        /* get JSF generated component id */
        String clientId = getClientId(context);
        char sep = UINamingContainer.getSeparatorChar(context);
        int increment;
        /* detect which button < or > was clicked */
        if (requestMap.containsKey(clientId + sep + "inputfield" + sep + "MORE")) {
            increment = 1; //clientId + MORE
        } else if (requestMap.containsKey(clientId + sep + "inputfield" + sep + "LESS")) {
            increment = -1;//clientId + LESS
        } else {
            increment = 0;
        }

        try {
            /* get request value for this component */
            int submittedValue = Integer.parseInt((String) requestMap.get(clientId + sep + "inputfield"));

            int newValue = getIncrementedValue(submittedValue, increment);
            Integer minimum = toInteger(getAttributes().get("minimum"));
            Integer maximum = toInteger(getAttributes().get("maximum"));
            if (newValue > maximum) {
                newValue = maximum;
            }
            if (newValue < minimum) {
                newValue = minimum;
            }
            setSubmittedValue("" + newValue); //make it a String
        } catch (NumberFormatException ex) {
            // let the converter take care of bad input, but we still have
            // to set the submitted value, or the converter won't have
            // any input to deal with
            setSubmittedValue((String) requestMap.get(clientId));
        }
    }

    /* adds increment to value and takes into account min and max */
    private int getIncrementedValue(int submittedValue, int increment) {
        Integer minimum = toInteger(getAttributes().get("minimum"));
        Integer maximum = toInteger(getAttributes().get("maximum"));
        int newValue = submittedValue + increment;

        if ((minimum == null || newValue >= minimum)
                && (maximum == null || newValue <= maximum)) {
            return newValue;
        } else {
            return submittedValue;
        }
    }

    /* value of minimum or maximum attributes could be set as String literal or by a value
expression, which might return a Number */
    private static Integer toInteger(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Number) {
            return ((Number) value).intValue();
        }
        if (value instanceof String) {
            return Integer.parseInt((String) value);
        }
        throw new IllegalArgumentException("Cannot convert " + value);
    }

}
