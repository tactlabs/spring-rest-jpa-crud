package org.tact.base.rest;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tact.base.jpa.domain.FounderMeter;
import org.tact.base.respository.FounderMeterRepository;

@RestController
@RequestMapping(value = "/founder-meter")
public class FounderController {
	
	
	@Autowired
    private FounderMeterRepository ffRepository;
	
	/**
	 * 
	 * @return
	 * 
	 * possible urls:
	 * 		/founder-meter
	 * 		http://localhost:1878/founder-meter
	 */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public <T> T listUsers() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("one", "two");
        map.put("three", "four");
        map.put("five", "six");
        map.put("seven", "eight");
        
        return (T) map;
    }
    
    /**
     * 
     * @param liLink
     * @return
     * 
     * possible urls:
	 * 		/founder-meter/get/all/top/jpa
	 * 		http://localhost:1878/founder-meter/get/all/top/jpa
     */
    @GetMapping(value = "/get/all/top/jpa")
    public <T> T getAllFFounder() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        
        List<FounderMeter> fFounder = ffRepository.findAllByOrderByAuthMeterDesc();
        
        map.put("foundres", fFounder);        
        
        return (T) map;
    }
    
    /**
     * 
     * @param liLink
     * @return
     * 
     * possible urls:
     * 		/by/li-link/jpa
	 * 		/founder-meter/by/li-link/jpa
	 * 		http://localhost:1878/founder-meter/by/li-link/jpa
	 * 
     */
    @GetMapping(value = "/by/li-link/jpa")
    public <T> T getFFounderByLinkedInLinkJPA(
    		@RequestParam(value = "li_link")String liLink) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        
        FounderMeter fFounder = ffRepository.findByLinkedinLink(liLink);
        
        map.put("li_link", liLink);
        map.put("city", fFounder);
        
        return (T) map;
    }
    
    /**
     * 
     * @param authMeter
     * @return
     * 
     * possible urls:
     * 		/real-founders/jpa
	 * 		/founder-meter/real-founders/jpa
	 * 		http://localhost:1878/founder-meter/real-founders/jpa
     * 
     */
    @GetMapping(value = "/real-founders/jpa")
    public <T> T getFFounderByAuthMeterGreaterThan(
    		@RequestParam(value = "auth_meter", defaultValue = "5")Integer authMeter) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        
        List<FounderMeter> fFounder = ffRepository.findByAuthMeterGreaterThan(authMeter);
        
        map.put("real_founders", fFounder);        
        
        return (T) map;
    }
    
    /**
     * 
     * @param authMeter
     * @return
     * 
     * possible urls:
     * 		/real-founders/top/jpa
	 * 		/founder-meter/real-founders/top/jpa
	 * 		http://localhost:1878/founder-meter/real-founders/top/jpa
     */
    @GetMapping(value = "/real-founders/top/jpa")
    public <T> T getFFounderByAuthMeterGreaterThanTop(
    		@RequestParam(value = "auth_meter", defaultValue = "5")Integer authMeter) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        
        List<FounderMeter> fFounder = ffRepository.findByAuthMeterGreaterThanOrderByAuthMeterDesc(authMeter);
        
        map.put("real_founders", fFounder);        
        
        return (T) map;
    }
    
    
    /**
     * 
     * @return
     * 
     * possible urls:
     * 		/get/all/jpa
	 * 		/founder-meter/get/all/jpa
	 * 		http://localhost:1878/founder-meter/get/all/jpa
     */
    @GetMapping(value = "/get/all/jpa")
    public <T> T getAllFoundersJPA(
    		) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        
        List<FounderMeter> fFounderList = ffRepository.findAll();
        
        map.put("founders", fFounderList);        
        
        return (T) map;
    }
    
    /**
     * 
     * @param name
     * @param liLink
     * @param authMeter
     * @param adminComment
     * @return
     * 
     * possible urls:
     * 		/add
	 * 		/founder-meter/add
	 * 		http://localhost:1878/founder-meter/add
     * 
     */
    @PostMapping(value = "/add")
    public <T> T addFounder(
		@RequestParam(value = "name", required=false) String name,
		@RequestParam(value = "li_link") String liLink,
		@RequestParam(value = "auth_meter") Integer authMeter,
		@RequestParam(value = "admin_comment") String adminComment
    	) {
        
    	Map<String, Object> map = new LinkedHashMap<String, Object>();
    	
    	Map<String, Object> paramMap = new LinkedHashMap<String, Object>();
    	paramMap.put("NAME", name);
    	paramMap.put("LINKEDIN_LINK", liLink);
    	paramMap.put("AUTH_METER", authMeter);
    	paramMap.put("ADMIN_COMMENT", adminComment);
        
        // add
    	FounderMeter fMeter = new FounderMeter(name, liLink, authMeter, adminComment);
    	ffRepository.saveAndFlush(fMeter);
        
        map.put("apiresult", 0);
        map.put("apimessage", "ok");
        
        return (T) map;
    }
    
    /**
     * 
     * @param it
     * @param name
     * @param liLink
     * @param authMeter
     * @param adminComment
     * @return
     * 
     * possible urls:
     * 		/update
	 * 		/founder-meter/update
	 * 		http://localhost:1878/founder-meter/update
     */
    @PostMapping(value = "/update")
    public <T> T updateFounder(
    	@RequestParam(value = "id") Long id,
		@RequestParam(value = "name", required=false) String name,
		@RequestParam(value = "li_link", required=false) String liLink,
		@RequestParam(value = "auth_meter", required=false) Integer authMeter,
		@RequestParam(value = "admin_comment", required=false) String adminComment
    	) {
        
    	Map<String, Object> map = new LinkedHashMap<String, Object>();
    	
    	Map<String, Object> paramMap = new LinkedHashMap<String, Object>();
    	paramMap.put("ID", id);
    	paramMap.put("NAME", name);
    	paramMap.put("LINKEDIN_LINK", liLink);
    	paramMap.put("AUTH_METER", authMeter);
    	paramMap.put("ADMIN_COMMENT", adminComment);
        
        // update
        
        map.put("apiresult", 0);
        map.put("apimessage", "ok");
        
        return (T) map;
    }
}
