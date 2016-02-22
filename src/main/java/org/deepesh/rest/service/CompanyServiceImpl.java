package org.deepesh.rest.service;

import java.util.List;

import org.deepesh.rest.dao.CompanyDao;
import org.deepesh.rest.dao.CompanyDaoImpl;
import org.deepesh.rest.model.Company;
import org.deepesh.rest.utils.CompanyCustomException;

/**
 * @author dgupta
 *
 */
public class CompanyServiceImpl implements CompanyService {

	CompanyDao companyDao = new CompanyDaoImpl();

	@Override
	public String addNewCompany(Company Company) {
		return companyDao.addNewCompany(Company);
	}

	@Override
	public Company getCompanyDetails(String id) {
		return companyDao.getCompanyDetails(id);
	}

	@Override
	public List<Company> getAllcompanies() {
		return companyDao.getAllcompanies();
	}

	@Override
	public String updateCompany(Company company) throws CompanyCustomException {
		return companyDao.updateCompany(company);
	}

	@Override
	public String addOwner(String companyName, String owner)
			throws CompanyCustomException {

		if (companyDao.getCompanyDetails(companyName) != null) {
			return companyDao.addOwner(companyName, owner) ? owner
					+ " Added to " + companyName : "Error adding Owner";
		}
		return " Company Not found to add owner";
	}

}
