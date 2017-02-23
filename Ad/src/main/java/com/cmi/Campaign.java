package com.cmi;

public class Campaign {

	/* "partner_id": "unique_string_representing_partner',
		 "duration": "int_representing_campaign_duration_in_seconds_from_now"
		 "ad_content": "string_of_content_to_display_as_ad"
	*/
	
	
	String partner_id;
	public String getPartner_id() {
		return partner_id;
	}



	public 	void setPartner_id(String partner_id) {
		this.partner_id = partner_id;
	}



	public int getDuration() {
		return duration;
	}



	public void setDuration(int duration) {
		this.duration = duration;
	}



	public String getAd_content() {
		return ad_content;
	}



	public void setAd_content(String ad_content) {
		this.ad_content = ad_content;
	}



	int duration;
	String ad_content;

	

	@Override
	public String toString() {
		return "Campaign [Partner=" + partner_id + ", Ad Content=" + ad_content + "]"+",Duration=" + duration + "]";
	}

}
