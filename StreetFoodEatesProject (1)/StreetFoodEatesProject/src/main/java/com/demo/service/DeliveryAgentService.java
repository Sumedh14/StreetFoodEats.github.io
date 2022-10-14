package com.demo.service;

import java.util.List;

import com.demo.beans.DeliveryAgent;
import com.demo.beans.User;

public interface DeliveryAgentService {

	DeliveryAgent validateDeliveryAgentLogin(User user);

	List<DeliveryAgent> displayAllDeliveryAgent();

	DeliveryAgent addDeliveryAgent(DeliveryAgent deliveryAgent);

	void deleteDeliveryAgentById(int deliveryAgentId);

	DeliveryAgent updateById(DeliveryAgent deliveryAgent);

}
