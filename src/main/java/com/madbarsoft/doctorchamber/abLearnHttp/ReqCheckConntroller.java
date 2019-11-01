package com.madbarsoft.doctorchamber.abLearnHttp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madbarsoft.doctorchamber.consultation.ConsultationEntity;
import com.madbarsoft.doctorchamber.util.Response;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/req-check")
public class ReqCheckConntroller {

	@PostMapping("/create")
	public Response create(@RequestBody EmployeeDto empObj) {
		Response resObj = new Response();

		System.out.println("ON CREATE# " + empObj);
		resObj.setObj(empObj);
		return resObj;
	}

	@GetMapping("/list")
	public Response simpleGet(HttpServletRequest request) {
		Response resObj = new Response();

		System.out.println("GET#      HTTP_METHOD     # " + request.getMethod());
		System.out.println("GET#      CONTENT_TYPE    # " + request.getContentType());
		System.out.println("GET#      REQ_URL         # " + request.getRequestURL());
		System.out.println("GET#      REQ_URI         # " + request.getRequestURI());

		System.out.println("GET#      LOCAL_ADDR      # " + request.getLocalAddr());
		System.out.println("GET#      LOCAL_NAME      # " + request.getLocalName());
		System.out.println("GET#      LOCAL_PORT      # " + request.getLocalPort());

		System.out.println("GET#      SERVELET_CONTAX # " + request.getServletContext());

		System.out.println("GET#      HEDER_VAL1      # " + request.getHeader("simple-Msg"));

		System.out.println("GET#      PARAM_NAME      # " + request.getParameter("name"));
		System.out.println("GET#      PARAM_ID        # " + request.getParameter("id"));

		String myAuthToken = request.getHeader("my-auth-token");
		if (myAuthToken != null) {
			if (myAuthToken.equals("12345")) {
				System.out.println("GET#      USER_LOGIN_STATUS        # Login in");
			} else {
				System.out.println("GET#      USER_LOGIN_STATUS        # Not Login in");
			}
		} else {
			System.out.println("GET#      USER_LOGIN_STATUS        # Bed Request");
		}

		return resObj;
	}

	@PostMapping("/list")
	public Response simplePost(HttpServletRequest request) {
		Response resObj = new Response();

		System.out.println("POST#      HTTP_METHOD     # " + request.getMethod());
		System.out.println("POST#      CONTENT_TYPE    # " + request.getContentType());
		System.out.println("POST#      REQ_URL         # " + request.getRequestURL());
		System.out.println("POST#      REQ_URI         # " + request.getRequestURI());

		System.out.println("POST#      LOCAL_ADDR      # " + request.getLocalAddr());
		System.out.println("POST#      LOCAL_NAME      # " + request.getLocalName());
		System.out.println("POST#      LOCAL_PORT      # " + request.getLocalPort());

		System.out.println("POST#      SERVELET_CONTAX # " + request.getServletContext());

		System.out.println("POST#      HEDER_VAL1      # " + request.getHeader("simple-Msg"));

		System.out.println("POST#      PARAM_NAME      # " + request.getParameter("name"));
		System.out.println("POST#      PARAM_ID        # " + request.getParameter("id"));

		String myAuthToken = request.getHeader("my-auth-token");
		if (myAuthToken != null) {
			if (myAuthToken.equals("12345")) {
				System.out.println("POST#      USER_LOGIN_STATUS        # Login in");
			} else {
				System.out.println("POST#      USER_LOGIN_STATUS        # Not Login in");
			}
		} else {
			System.out.println("POST#      USER_LOGIN_STATUS        # Bed Request");
		}

		return resObj;
	}

}
