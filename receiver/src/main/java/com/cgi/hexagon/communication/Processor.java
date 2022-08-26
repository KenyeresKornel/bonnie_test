package com.cgi.hexagon.communication;

import com.cgi.hexagon.businessrules.Receiver;
import com.cgi.hexagon.businessrules.order.Order;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class Processor {

    Receiver receiver;

    public void getOrders(JsonObject json) {
        receiver.saveOrders(parseJSON(json));
    }

    public List<Order> parseJSON(JsonObject json) {
        return new ArrayList<Order>();
    }
}
