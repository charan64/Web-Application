package com.cmi.rest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cmi.CampaignDecorator;
import com.cmi.Campaign;
import com.cmi.model.AdModel;
import com.cmi.exceptions.AdException;

@Path("/")
public class AdService {
	private static AdModel dao = new AdModel();;

	/**
	 * http://localhost:8080/ad/12
	 * 
	 * @return Campaign on success, "Campaign, 12, is not found" on failure
	 */

	@GET
	@Path("/{partner_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Campaign getCampaignJSON(@PathParam("partner_id") String partnerID) {
		CampaignDecorator campaignDec = dao.getCampagin(partnerID);
		if(campaignDec == null){
			throw new AdException(" No Campaign found with partner Id : "+ partnerID);
		} 
		if(! validateTime(campaignDec)){
			throw new AdException(" Active time is elapsed for partner : "+ partnerID);

		}
		return campaignDec.getCampaign();

	}

	private boolean validateTime(CampaignDecorator campaignDec) {
		boolean retVal = true;
		Date currentTime = (new Date());
		Calendar calender = Calendar.getInstance();
		calender.setTimeInMillis(campaignDec.getCreationDate().getTime());
		calender.add(Calendar.SECOND, campaignDec.getCampaign().getDuration());
		Date  validityDate=calender.getTime();
		if(validityDate.before(currentTime)){
			retVal = false;
		}
		return retVal;
	}
	

	/**
	 * http://localhost:8080/ad/
	 * expect data : {} 
	 * @return
	 */
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCampaignInJSON(Campaign campaign) {
		dao.addCampagin(new CampaignDecorator(campaign,new Date()));
		String result = "Campaign : [ "+ campaign+" ] is saved " ;
		return Response.status(201).entity(result).type(MediaType.TEXT_PLAIN).build();

	}
	
	

	/**
	 * http://localhost:8080/ad/all
	 * 
	 * @return
	 */
	@GET
	@Path("/all")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Campaign> getAllCampaigns() {
		return new ArrayList<Campaign>(dao.getAllCampagins());
	}

}