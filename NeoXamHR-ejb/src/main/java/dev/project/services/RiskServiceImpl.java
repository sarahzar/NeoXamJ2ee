package dev.project.services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.project.entities.Risk;

@Stateless
@LocalBean
public class RiskServiceImpl implements RiskServiceInterface {

	@PersistenceContext(unitName = "NeoXamHR-ejb")
	EntityManager em;

	// method to get risk by its code

	@Override
	public Risk getRiskById(String code) {
		return em.find(Risk.class, code);
	}

	// method to add new risk
	@Override
	public boolean AddRisk(Risk r) {
		if (this.getRiskById(r.getCode()) == null) {
			em.persist(r);
			return true;
		}
		return false;
	}

	// method to get Risk by its consecutive action
	@Override
	public List<Risk> getRiskByConsAct(String IdCAct) {
		return em.createQuery("SELECT r.* FROM RIsk r WHERE r.actionConsecutive_code=" + IdCAct + '"', Risk.class)
				.getResultList();
	}

	// method to get Risk by its preventive action
	@Override
	public List<Risk> getRiskByPrevAct(String IdPrAct) {
		return em.createQuery("SELECT r.* FROM RIsk r WHERE r.actionPreventive_code=" + IdPrAct + '"', Risk.class)
				.getResultList();
	}

	// method to get Risk by its code using query
	@Override
	public Risk GetRiskByCode(String code) {
		return (Risk) em.createQuery("select r.* from Risk r where r.code=" + code + '"', Risk.class);
	}

	// method to get all Risks in list format
	@Override
	public List<Risk> getAllRisks() {
		return em.createQuery("select r.* from Risk r", Risk.class).getResultList();
	}

	// method to update Risk
	@Override
	public boolean UpdateRisk(String Id, Risk R) {
		Risk OldOne = this.GetRiskByCode(Id);
		if (OldOne != null) {

			OldOne.setDescription(R.getDescription());
			OldOne.setFait(R.getFait());
			OldOne.setActionConsecutive(R.getActionConsecutive());
			OldOne.setActionPreventive(R.getActionPreventive());
			return true;
		}

		return false;
	}

	// method to Delete Risk
	@Override
	public boolean DeleteRisk(String Id) {
		Risk OldOne = this.getRiskById(Id);
		if (OldOne != null) {
			em.remove(OldOne);

			return true;
		}

		return false;
	}

}
