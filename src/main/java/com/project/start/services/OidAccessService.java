package com.project.start.services;

import com.project.start.entities.GDS.OidsAccess.OidAccess;
import com.project.start.entities.GDS.OidsAccess.TableView.AccessView;
import com.project.start.entities.PageDtoResults;
import com.project.start.repositories.OidAccessRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


@Service
public class OidAccessService {

    private final OidAccessRepository repository;
    private final EntityManagerFactory entityManagerFactory;


    public OidAccessService(OidAccessRepository repository, EntityManagerFactory entityManagerFactory) {
        this.repository = repository;
        this.entityManagerFactory = entityManagerFactory;
    }

    public Page<OidAccess> getListAccess(Pageable page) {
        return repository.findAll(page);
    }


    public PageDtoResults<AccessView> getAllAccessByCriteria(
            String country,
            String gds,
            String responsible,
            String department,
            String terminal,
            String pcc,
            String activeStatus,
            String sortingField,
            String sortingDirection,
            Integer pageNumber,
            Integer pageSize
    ) {
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        List<AccessView> que = entityManager.createQuery(
                "SELECT  new " +
                        "com.project.start.entities.GDS.OidsAccess.TableView.AccessView " +
                        "(a.terminal as terminal," +
                        "a.statusActive as statusActive," +
                        "case  when a.statusActive=1 then 'active' when a.statusActive=2 then 'reserve' else 'deleted' end as statusName," +
                        "a.rDate as rDate," +
                        "b.oid as oid," +
                        "d.gdsCode as gdsCode," +
                        "d.gdsName as gdsName," +
                        "e.countryCode as countryCode," +
                        "e.countryName as countryName," +
                        "c.responsible as responsible," +
                        "c.department as department," +
                        "c.description  as description) " +
                        "FROM OidAccess a " +
                        "left join Oid b on a.oid_id=b.id " +
                        "left join OidResponsible c on a.responsible_id=c.id " +
                        "left join Gds d on b.gdsId=d.id " +
                        "left join Country e on b.countryId=e.id " +
                        "WHERE (:country in('','any') or e.countryCode = :country) " +
                        "and (:gds in('','any') or d.gdsCode = :gds)" +
                        "and (:responsible in('','any') or c.responsible= :responsible)" +
                        "and (:department in('','any') or c.department= :department)" +
                        "and (:terminal in('','any') or locate(:terminal,a.terminal)>0)" +
                        "and (:pcc in('','any') or locate(:pcc,b.oid)>0)" +
                        "and (:activeStatus in('','any') or " +
                        "case  when a.statusActive=1 then 'active' when a.statusActive=2 then 'reserve' else 'deleted' end = :activeStatus) " +
                        "order by " + sortingField + " " + sortingDirection, AccessView.class)
                .setParameter("country", country)
                .setParameter("gds", gds)
                .setParameter("responsible", responsible)
                .setParameter("department", department)
                .setParameter("terminal", terminal)
                .setParameter("pcc", pcc)
                .setParameter("activeStatus", activeStatus)
                .setFirstResult((pageNumber - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();

        PageDtoResults<AccessView> pageDtoResults = new PageDtoResults<>();
        pageDtoResults.setContent(que);

        Long pages = entityManager.createQuery(
                "SELECT " +
                        "count (a.terminal) " +
                        "FROM OidAccess a " +
                        "left join Oid b on a.oid_id=b.id " +
                        "left join OidResponsible c on a.responsible_id=c.id " +
                        "left join Gds d on b.gdsId=d.id " +
                        "left join Country e on b.countryId=e.id " +
                        "WHERE (:country in('','any') or e.countryCode = :country) " +
                        "and (:gds in('','any') or d.gdsCode = :gds)" +
                        "and (:responsible in('','any') or c.responsible= :responsible)" +
                        "and (:department in('','any') or c.department= :department)" +
                        "and (:terminal in('','any') or locate(:terminal,a.terminal)>0)" +
                        "and (:pcc in('','any') or locate(:pcc,b.oid)>0)" +
                        "and (:activeStatus in('','any') or " +
                        "case  when a.statusActive=1 then 'active' when a.statusActive=2 then 'reserve' else 'deleted' end = :activeStatus)", Long.class)
                .setParameter("country", country)
                .setParameter("gds", gds)
                .setParameter("responsible", responsible)
                .setParameter("department", department)
                .setParameter("terminal", terminal)
                .setParameter("pcc", pcc)
                .setParameter("activeStatus", activeStatus).getResultList().get(0);

        pageDtoResults.setTotalElements(pages);
        pageDtoResults.setTotalPages(pages / pageSize + 1);
        entityManager.close();
        return pageDtoResults;
    }

    //    public Page<OidAccess> getListAccessByOid(Integer id, Pageable page) {
//        return repository.findAllByOidId(id, page);
//    }
//
//
//    public String getDate() {
//        LocalDateTime localDateTime = LocalDateTime.now();
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        return localDateTime.format(dateTimeFormatter);
//    }
//
//    public void deleteById(Integer id) {
//        repository.deleteById(id);
//    }
//
//    public void updateById(Integer id, Integer status, Integer resp) {
//        OidAccess oidAccess = repository.findOneById(id);
////        oidAccess.setStatus(status);
////        oidAccess.setResponsible_id(resp);
////        oidAccess.setRefresh(getDate());
//        repository.save(oidAccess);
//    }
//
    public void save(Integer oidId, String access, Integer status, Integer resp) {
        OidAccess oidAccess = new OidAccess();
//        oidAccess.setOidId(oidId);
//        oidAccess.setAccess(access);
//        oidAccess.setStatus(status);
//        oidAccess.setResponsible_id(resp);
//        oidAccess.setRefresh(getDate());
        repository.save(oidAccess);
    }


}
