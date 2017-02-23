package com.cmi;
import java.util.Date;

import com.cmi.Campaign;


public class CampaignDecorator {
	
	private Campaign campaign;
	
	private Date creationDate;
	
	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public CampaignDecorator(Campaign cam,Date date){
		campaign= cam;
		creationDate = date;
	}

}
