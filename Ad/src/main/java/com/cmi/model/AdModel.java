package com.cmi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;





import com.cmi.CampaignDecorator;
import com.cmi.Campaign;


public class AdModel {
	
	private Map<String, CampaignDecorator> partnerMap = new HashMap<String, CampaignDecorator>();
	
	public void addCampagin(CampaignDecorator camDec){
			partnerMap.put(camDec.getCampaign().getPartner_id(), camDec);
	}
	
	public CampaignDecorator getCampagin(String partnerId){
		
			return partnerMap.get(partnerId);
	}
	
	public ArrayList<Campaign> getAllCampagins(){
		ArrayList<Campaign> retVal = new ArrayList<Campaign>();
		for(String partnerId : partnerMap.keySet()){
			retVal.add(partnerMap.get(partnerId).getCampaign());
		}
		return retVal;
	}
	

}
