package com.madbarsoft.doctorchamber.note;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madbarsoft.doctorchamber.diagnosis.DiagnosisEntity;
import com.madbarsoft.doctorchamber.util.Def;
import com.madbarsoft.doctorchamber.util.Response;

/**
 * @author Md. Jahurul Islam
 *
 */
@Service
public class NoteService {
	
	@Autowired
	NoteRepository roteRepository;
	
	public Response gridList(HttpServletRequest request) {
		return roteRepository.gridList(request);
	}
	
	public Response list(NoteEntity reqObj) {
		return roteRepository.list(reqObj);
	}

	public Response save(NoteEntity note) {

		return roteRepository.save(note);
	}

	public Response update(NoteEntity note) {

		return roteRepository.update(note);
	}

	public Response remove(Long id) {

		return roteRepository.remove(id);
	}
	public Response delete(Long id) {

		return roteRepository.detele(id);
	}
}
