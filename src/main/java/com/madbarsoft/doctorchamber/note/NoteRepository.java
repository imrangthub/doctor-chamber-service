package com.madbarsoft.doctorchamber.note;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.madbarsoft.doctorchamber.base.BaseRepository;
import com.madbarsoft.doctorchamber.pagination.DataTableRequest;
import com.madbarsoft.doctorchamber.pagination.DataTableResults;
import com.madbarsoft.doctorchamber.util.Response;

/**
 * @author Md. Jahurul Islam
 *
 */
@Repository
@Transactional
public class NoteRepository extends BaseRepository {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response gridList(HttpServletRequest request) {

		String doctorNo = request.getParameter("doctorNo");
		DataTableResults<NoteEntity> dataTableResults = null;
		Response response = new Response();
		NoteEntity noteEntity = new NoteEntity();
		if (!doctorNo.isEmpty()) {
			noteEntity.setDoctorNo(Long.parseLong(doctorNo));
		}
		DataTableRequest dataTableInRQ = new DataTableRequest(request);
		Long totalRowCount = totalCount(noteEntity);

		List gridList = new ArrayList<>();
		response = baseList(typedQuery(noteEntity, dataTableInRQ));

		if (response.isSuccess()) {
			if (response.getItems() != null) {
				gridList = response.getItems();
			}
			dataTableResults = dataTableResults(dataTableInRQ, gridList, gridList, totalRowCount);
		}
		response.setItems(null);
		response.setObj(dataTableResults);
		return response;
	}

	public Response save(NoteEntity note) {
		return baseOnlySave(note);
	}

	public Response update(NoteEntity note) {
		NoteEntity obj = findById(note.getId());
		if (obj != null) {
			obj.setNoteName(note.getNoteName());
			obj.setNoteDescription(note.getNoteDescription());
			obj.setDoctorNo(note.getDoctorNo());
			obj.setModifiedDate(new Date());
			obj.setModifiedBy("Jahurul");
			return baseUpdate(obj);
		}

		return getErrorResponse("Record not Found !!");
	}

	public Response detele(Long id) {
		NoteEntity note = findById(id);
		return baseDelete(note);
	}

	public Response remove(Long id) {
		NoteEntity note = findById(id);
		note.setActiveStatus(3);
		return baseRemove(note);
	}

	public Response list() {
		return baseList(criteriaQuery(new NoteEntity()));
	}

	public Response list(NoteEntity reqObj) {
		return baseList(criteriaQuery(reqObj));
	}

	public NoteEntity findById(Long id) {
		NoteEntity noteEntity = new NoteEntity();
		noteEntity.setId(id);
		Response response = baseFindById(criteriaQuery(noteEntity));
		if (response.isSuccess()) {
			return (NoteEntity) response.getObj();
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(NoteEntity filter) {
		init();

		List<Predicate> p = new ArrayList<Predicate>();
		p = criteriaCodtion(filter, null, null);

		if (!CollectionUtils.isEmpty(p)) {
			Predicate[] pArray = p.toArray(new Predicate[] {});
			Predicate predicate = builder.and(pArray);
			criteria.where(predicate);
		}
		return criteria;
	}

	@SuppressWarnings({ "rawtypes" })
	private <T> TypedQuery typedQuery(NoteEntity filter, DataTableRequest<T> dataTableInRQ) {
		init();

		List<Predicate> pArrayJoin = new ArrayList<Predicate>();
		List<Predicate> pConjunction = criteriaCodtion(filter, null, null);
		List<Predicate> pDisJunction = dataTablefilter(dataTableInRQ);

		Predicate predicateAND = null;
		Predicate predicateOR = null;

		if (!CollectionUtils.isEmpty(pConjunction)) {
			Predicate[] pArray = pConjunction.toArray(new Predicate[] {});
			predicateAND = builder.and(pArray);
		}

		if (!CollectionUtils.isEmpty(pDisJunction)) {
			Predicate[] pArray = pDisJunction.toArray(new Predicate[] {});
			predicateOR = builder.or(pArray);
		}
		if (predicateAND != null) {
			pArrayJoin.add(predicateAND);

		}

		if (predicateOR != null) {
			pArrayJoin.add(predicateOR);

		}

		criteria.where(pArrayJoin.toArray(new Predicate[0]));

		return baseTypedQuery(criteria, dataTableInRQ);
	}

	private Long totalCount(NoteEntity filter) {
		CriteriaBuilder builder = criteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = longCriteriaQuery(builder);
		Root<NoteEntity> root = from(NoteEntity.class, criteriaQuery);
		return totalCount(builder, criteriaQuery, root, criteriaCodtion(filter, builder, root));

	}

	@SuppressWarnings({ "unchecked" })
	private List<Predicate> criteriaCodtion(NoteEntity filter, CriteriaBuilder builder, Root<NoteEntity> root) {

		if (builder == null) {
			builder = super.builder;
		}
		if (root == null) {
			root = super.root;
		}

		List<Predicate> p = new ArrayList<Predicate>();

		if (filter != null) {
			if (filter.getActiveStatus() > 0) {
				Predicate condition = builder.equal(root.get("activeStatus"), filter.getActiveStatus());
				p.add(condition);
			}
			if (filter.getId() != null && filter.getId() > 0) {
				Predicate condition = builder.equal(root.get("id"), filter.getId());
				p.add(condition);
			}
			if (filter.getNoteName() != null && !filter.getNoteName().isEmpty()) {
				Predicate condition = builder.like(root.get("noteName"), filter.getNoteName());
				p.add(condition);
			}
			if (filter.getDoctorNo() != null && filter.getDoctorNo() > 0) {
				Predicate condition = builder.or(builder.equal(root.get("doctorNo"), filter.getDoctorNo()),
						builder.isNull(root.get("doctorNo")));
				p.add(condition);
			}
		}

		return p;
	}

	private void init() {
		initEntityManagerBuilderCriteriaQueryRoot(NoteEntity.class);
		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;
	}

}
