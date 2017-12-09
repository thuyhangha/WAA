/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author hangha
 */
@ManagedBean
@RequestScoped
public class FlightManagedBean {

    /**
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * @return the departureDate
     */
    public String getDepartureDate() {
        return departureDate;
    }

    /**
     * @param departureDate the departureDate to set
     */
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * @return the returnDate
     */
    public String getReturnDate() {
        return returnDate;
    }

    /**
     * @param returnDate the returnDate to set
     */
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * @return the ticketType
     */
    public String getTicketType() {
        return ticketType;
    }

    /**
     * @param ticketType the ticketType to set
     */
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    /**
     * @return the options
     */
    public String[] getOptions() {
        return options;
    }

    /**
     * @param options the options to set
     */
    public void setOptions(String[] options) {
        this.options = options;
    }
    private String from;
    private String to;
    private String departureDate;
    private String returnDate;
    private String ticketType;
    private String[] options;
    /**
     * Creates a new instance of FlightManagedBean
     */
    public FlightManagedBean() {
        this.from = "Paris";
        this.to = "Boston";
        this.departureDate = "12/09/2008";
        this.returnDate = "29/09/2008";
        this.ticketType="Round trip";

        this.options = new String[] {"First class", "No stopover"};
    }
    
    public String submit() {
        return "success";
    }
    
    public String optionsString;
    public String getOptionsString() {
        String result = "";
        for(int i=0; i<this.options.length; i++) {
            if(i == this.options.length -1)
                result = result + this.options[i];
            else 
                result = result + this.options[i] + ", ";            
        }
        return result;
    }
}
