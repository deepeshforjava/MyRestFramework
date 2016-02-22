package org.deepesh.rest.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.deepesh.rest.model.Company;
import org.deepesh.rest.utils.CompanyCustomException;

/**
 * @author dgupta
 *
 */
public class CompanyDaoImpl implements CompanyDao {

	static Map<String, Company> companiesMap = new HashMap<>();

	@Override
	public String addNewCompany(Company company) {
		
		if (companiesMap.containsKey(company.getName().toLowerCase())) {
			return company.getName() + " already present!";
		}
		company.setCompanyId(company.getName().toLowerCase());
		companiesMap.put(company.getName().toLowerCase(), company);
		return company.getName() + " added !";
	}

	@Override
	public List<Company> getAllcompanies() {

		if (companiesMap.isEmpty()) {
			addDefaultCompany();
		}
		return new ArrayList<Company>(companiesMap.values());
	}

	private void addDefaultCompany() {
		Company company = new Company("Google", "Google", "Mountain View", "California", "USA");
		List<String> beneficialOwners = new ArrayList<>();
		beneficialOwners.add("Larry Page");
		beneficialOwners.add("Sergey Brin");
		company.setBeneficialOwners(beneficialOwners);
		company.setEmail("contact@google.com");
		company.setPnoneNumber("415-234-9876");
		
		Company company2 = new Company("Amazon", "Amazon", "Seattle", "Washington", "USA");
		List<String> beneficialOwners2 = new ArrayList<>();
		beneficialOwners2.add("Jeff Bezos");
		company2.setBeneficialOwners(beneficialOwners2);
		company2.setEmail("contact@amazon.com");
		company2.setPnoneNumber("413-214-7870");
		
		companiesMap.put(company.getName().toLowerCase(), company);
		companiesMap.put(company2.getName().toLowerCase(), company2);
	}

	@Override
	public Company getCompanyDetails(String id) {
		return companiesMap.get(id.toLowerCase());
	}

	@Override
	public String updateCompany(Company company) throws CompanyCustomException {
		companiesMap.put(company.getName().toLowerCase(), company);
		return company.getName() + " updated";
	}

	@Override
	public boolean addOwner(String companyName, String owner) throws CompanyCustomException {
		return companiesMap.get(companyName.toLowerCase()).getBeneficialOwners().add(owner);
	}

}
