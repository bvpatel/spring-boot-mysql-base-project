package me.socialid.contactManagement.resource;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.socialid.contactManagement.contact.domain.Name;
import me.socialid.contactManagement.repository.NameRepository;

@RestController
@RequestMapping("/name")
public class NameResource {

	@Autowired
	NameRepository nameRepository;

	@RequestMapping(method = RequestMethod.POST)
	Response addName(@RequestBody Name name) {
		nameRepository.save(name);
		return Response.ok().build();
	}
}
