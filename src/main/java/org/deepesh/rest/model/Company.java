/**
 * 
 */
package org.deepesh.rest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dgupta
 *
 */
public class Company extends AbstracEntity implements Serializable{

	
	private static final long serialVersionUID = -2174008822790672145L;
	
	private String  companyId;
	private String  name;
	private String  address;
	private String  city;
	private String  country;
	private String  email;
	private String  pnoneNumber;
	private List<String>  beneficialOwners;
	
	
	
	public Company() {
		super();
	}
	
	public Company(String companyId, String name, String address, String city, String country) {
		super();
		this.companyId = companyId;
		this.name = name;
		this.address = address;
		this.city = city;
		this.country = country;
	}
	

	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPnoneNumber() {
		return pnoneNumber;
	}
	public void setPnoneNumber(String pnoneNumber) {
		this.pnoneNumber = pnoneNumber;
	}
	public List<String> getBeneficialOwners() {
		if ( beneficialOwners == null )
			beneficialOwners = new ArrayList<String>();
		return beneficialOwners;
	}

	public void setBeneficialOwners(List<String> beneficialOwners) {
		this.beneficialOwners = beneficialOwners;
	}
	

}
