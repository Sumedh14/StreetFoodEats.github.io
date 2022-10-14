package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.DeliveryAgent;
import com.demo.beans.User;
import com.demo.dao.DeliveryAgentDao;

@Service
public class DeliveryAgentServiceImpl implements DeliveryAgentService{

	@Autowired
	DeliveryAgentDao deliveryAgentDao;

	@Override
	public DeliveryAgent validateDeliveryAgentLogin(User user) {
		DeliveryAgent deliveryAgent = deliveryAgentDao.validate(user.getUserEmail(),user.getPassword());
		if(deliveryAgent != null) {
			return deliveryAgent;
		}
		else {
			return null;
		}
		
	}

	@Override
	public List<DeliveryAgent> displayAllDeliveryAgent() {
		
		return deliveryAgentDao.findAll();
	}

	@Override
	public DeliveryAgent addDeliveryAgent(DeliveryAgent deliveryAgent) {
		try {
			return deliveryAgentDao.save(deliveryAgent);
			}catch(IllegalArgumentException e){
				return null;
			}
		
	}

	@Override
	public void deleteDeliveryAgentById(int deliveryAgentId) {
		deliveryAgentDao.deleteById(deliveryAgentId);
		
	}

	@Override
	public DeliveryAgent updateById(DeliveryAgent deliveryAgent) {
		Optional<DeliveryAgent> deliveryAgent1=deliveryAgentDao.findById(deliveryAgent.getDeliveryAgentId());
		if(deliveryAgent1.isPresent()) {
			DeliveryAgent deliveryAgent2=deliveryAgent1.get();
			deliveryAgent2.setDeliveryAgentName(deliveryAgent.getDeliveryAgentName());
			deliveryAgent2.setDeliveryAgentEmail(deliveryAgent.getDeliveryAgentEmail());
			deliveryAgent2.setDeliveryAgentPassword(deliveryAgent.getDeliveryAgentPassword());
			deliveryAgent2.setDeliveryAgentAddress(deliveryAgent.getDeliveryAgentAddress());
			deliveryAgent2.setDeliveryAgentPhoneNo(deliveryAgent.getDeliveryAgentPhoneNo());
			return deliveryAgentDao.save(deliveryAgent2);	
		}
		else {
			return null;
		}
	}
	
}
