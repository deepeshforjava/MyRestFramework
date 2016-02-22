package org.deepesh.rest.Controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.deepesh.rest.model.Company;
import org.deepesh.rest.model.Message;
import org.deepesh.rest.service.CompanyService;
import org.deepesh.rest.service.CompanyServiceImpl;

/**
 * @author dgupta
 *
 */
@Path("/companies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompanyController {

	CompanyService companyService = new CompanyServiceImpl();

	
	/** Get all Companies.
	 * @return List
	 */
	@GET
	public List<Company> getAllCompanies() {
		return companyService.getAllcompanies();
	}

	/** Get Company details by company Id.
	 * @param companyName
	 * @return Company
	 */
	@GET
	@Path("/{companyName}")
	public Object getCompanyDetails(@PathParam("companyName") final String companyName) {
		Company company = companyService.getCompanyDetails(companyName);
		if (company == null) {
			return "Company not found, Please provide valid Id...";
		}
		return companyService.getCompanyDetails(companyName);
	}

	/** Creates new Company
	 * @param company
	 * @return Message
	 */
	@POST
	public Message createCompany(final Company company) {
		Message message = new Message();
		message.setMessage(companyService.addNewCompany(company));
		return message;
	}

	/** Updates particular Company
	 * @param company
	 * @return Message
	 */
	@PUT
	@Path("/update")
	public Message updateCompany(Company company) {
		final Message message = new Message();
		message.setMessage(companyService.updateCompany(company));
		return message;
	}

	
	@PUT
	@Path("/addOwner")
	public Message addCompanyOwner(Company company, @MatrixParam("owner") String owner) {
		Message message = new Message();
		message.setMessage(companyService.addOwner(company.getName(), owner));
		return message;
	}
}
