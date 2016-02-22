package org.deepesh.rest.service;

import java.util.List;

import org.deepesh.rest.model.Company;
import org.deepesh.rest.utils.CompanyCustomException;

/**
 * @author dgupta
 *
 */
public interface CompanyService {

	public String addNewCompany(Company Company) throws CompanyCustomException;

	public List<Company> getAllcompanies() throws CompanyCustomException;

	public Company getCompanyDetails(String id) throws CompanyCustomException;

	public String updateCompany(Company Company) throws CompanyCustomException;

	public String addOwner(String companyName, String owner)
			throws CompanyCustomException;

}
