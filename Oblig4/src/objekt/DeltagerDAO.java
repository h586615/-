package objekt;

import java.util.List;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DeltagerDAO {

	@PersistenceContext(name = "deltagerPU")
	private EntityManager em;

	public List<Deltager> hentAlleDeltagere() {
		return em.createQuery("SELECT b FROM Deltager b", Deltager.class).getResultList();
	}

	public Deltager hentBruker(String mobil) {
		return em.find(Deltager.class, mobil);
	}

	public void lagreNyBruker(Deltager nyDeltaker) {
		em.persist(nyDeltaker);
	}
}
