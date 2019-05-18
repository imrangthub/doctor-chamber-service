package com.madbarsoft.doctorchamber.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.util.Response;


@Service
public class GroupService {

	 @Autowired
	 GroupRepository groupRepository;
	
	public Response list(GroupEntity reqObj) {
		return groupRepository.list(reqObj);
	}
	
	public GroupEntity findById(Long id) {
		return groupRepository.findById(id);
	}

	public Response save(GroupEntity group) {

		return groupRepository.save(group);
	}

	public Response update(GroupEntity group) {

		return groupRepository.update(group);
	}

	public Response remove(Long id) {

		return groupRepository.remove(id);
	}
	public Response delete(Long id) {

		return groupRepository.detele(id);
	}
	
}
