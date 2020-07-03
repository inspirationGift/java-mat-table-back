package com.project.start.services;

import com.project.start.entities.GDS.GEO.Country;
import com.project.start.entities.GDS.GEO.Gds;
import com.project.start.entities.GDS.GEO.GdsCountry;
import com.project.start.entities.GDS.Oid.Oid;
import com.project.start.entities.GDS.Oid.OidDto;
import com.project.start.entities.GDS.Oid.OidEntities;
import com.project.start.entities.GDS.Oid.OidReasons;
import com.project.start.entities.PageDtoResults;
import com.project.start.repositories.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class OidService {

    private final OidRepository oidRepository;
    private final EntityManagerFactory entityManagerFactory;
    private final OidReasonRepository reasonRepository;
    private final OidEntitiesRepository entitiesRepository;
    private final CountryRepository countryRepository;
    private final GdsRepository gdsRepository;


    public OidService(OidRepository oidRepository, EntityManagerFactory entityManagerFactory, OidReasonRepository reasonRepository, OidEntitiesRepository entitiesRepository, CountryRepository countryRepository, GdsRepository gdsRepository) {
        this.oidRepository = oidRepository;
        this.entityManagerFactory = entityManagerFactory;
        this.reasonRepository = reasonRepository;
        this.entitiesRepository = entitiesRepository;
        this.countryRepository = countryRepository;
        this.gdsRepository = gdsRepository;
    }

    public List<Country> getCountries() {
        return this.countryRepository.findAll();
    }


    public List<Oid> getAllOids() {
        return this.oidRepository.findAll();
    }


    public List<GdsCountry> selectDistinctCountryAndGds() {

        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        Query query = entityManager.createNativeQuery(
                "SELECT distinct a.gdsId, a.countryId," +
                        "b.gdsCode,b.gdsName,c.CODE,c.COUNTRY " +
                        "FROM oids a " +
                        "left join  gdsList b on a.gdsId=b.id " +
                        "left join countrieslist c on a.countryId=c.id " +
                        "order by b.gdsCode,c.CODE asc");

        List<Object[]> res = query.getResultList();
        entityManager.close();

        List<GdsCountry> gdsCountryList = new ArrayList<>();

        for (Object[] objects : res) {

            GdsCountry gdsCountry = new GdsCountry();

            gdsCountry.setGdsId((Integer) objects[0]);
            gdsCountry.setCountryId((Integer) objects[1]);
            gdsCountry.setGdsCode((String) objects[2]);
            gdsCountry.setGdsName((String) objects[3]);
            gdsCountry.setCountryCode((String) objects[4]);
            gdsCountry.setCountryName((String) objects[5]);
            gdsCountryList.add(gdsCountry);
        }

        return gdsCountryList;
    }

    public List<OidReasons> selectReason() {
//        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
//        Query query = entityManager.createNativeQuery("select distinct a.id, a.reason from oidReasons a order by a.reason");
//        List<String> result = query.getResultList();
//        entityManager.close();
//        return result;
        return this.reasonRepository.findAll();
    }

    public List<OidEntities> selectEntities() {
        return this.entitiesRepository.findAll();
    }

    public PageDtoResults<OidDto> findByOptions(
            String country, String gds, Integer online, String active,
            String reason, String sortingField,
            String sortingDirection, Integer pageNumber, Integer pageSize
    ) {
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        List<OidDto> que = entityManager.createQuery(
                "SELECT new com.project.start.entities.GDS.Oid.OidDto( " +
                        "a.oid as oid," +
                        "a.iata as iata," +
                        "a.status as status," +
                        "case when a.status=1 then 'active' when a.status=2 then 'reserve' else 'deleted' end as statusName," +
                        "a.type as type," +
                        "a.comment as comment," +
                        "a.countryId as country," +
                        "b.countryCode as countryCode," +
                        "b.countryName as countryName," +
                        "a.gdsId as gds," +
                        "c.gdsCode as gdsCode," +
                        "c.gdsName as gdsName," +
                        "a.reasonId as reasonId," +
                        "d.reason as reason," +
                        "a.belongId as belongId," +
                        "e.entity as belong," +
                        "a.assignedId as assignId, " +
                        "f.entity as assign," +
                        "'' as action) " +
                        "FROM Oid a " +
                        "left join Country b on a.countryId=b.id " +
                        "left join Gds c on a.gdsId=c.id " +
                        "left join OidReasons d on a.reasonId=d.id " +
                        "left join OidEntities e on a.belongId=e.id " +
                        "left join OidEntities f on a.assignedId=f.id " +
                        "WHERE (:gds in('','any') or c.gdsCode = :gds) " +
                        "and (:country in('','any') or b.countryCode = :country) " +
                        "and (:online is null or a.type = :online) " +
                        "and (:active in('','any') or " +
                        "case when a.status=1 then 'active' when a.status=2 then 'reserve' else 'deleted' end = :active) " +
                        "and (:reason in('','any') or d.reason = :reason)" +
                        "order by " + sortingField + " " + sortingDirection, OidDto.class)
                .setParameter("country", country)
                .setParameter("gds", gds)
                .setParameter("reason", reason)
                .setParameter("online", online)
                .setParameter("active", active)
                .setFirstResult((pageNumber - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();

        PageDtoResults<OidDto> pageDtoResults = new PageDtoResults<>();
        pageDtoResults.setContent(que);

        Long pages = entityManager.createQuery(
                "SELECT " +
                        "count (a.oid) " +
                        "FROM Oid a " +
                        "left join Country b on a.countryId=b.id " +
                        "left join Gds c on a.gdsId=c.id " +
                        "left join OidReasons d on a.reasonId=d.id " +
                        "WHERE (:gds in('','any') or c.gdsCode = :gds) " +
                        "and (:country in('','any') or b.countryCode = :country) " +
                        "and (:online is null or a.type = :online) " +
                        "and (:active in('','any') or " +
                        "case when a.status=1 then 'active' when a.status=2 then 'reserve' else 'deleted' end = :active) " +
                        "and (:reason in('','any') or d.reason = :reason)", Long.class)
                .setParameter("country", country)
                .setParameter("gds", gds)
                .setParameter("reason", reason)
                .setParameter("active", active)
                .setParameter("online", online).getResultList().get(0);

        pageDtoResults.setTotalElements(pages);
        pageDtoResults.setTotalPages(pages / pageSize + 1);
        entityManager.close();
        return pageDtoResults;
    }

    public Boolean deleteOid(OidDto oid) {
        try {
            Oid myOid = this.oidRepository.findOidByOidAndGdsId(oid.getOid(), oid.getGds());
            myOid.setStatus(oid.getStatus());
            this.oidRepository.delete(myOid);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean saveOid(OidDto pcc) {
        Oid myOid = null;

        try {

            if (pcc.getAction().equals("update")) {
                myOid = this.oidRepository.findOidByOidAndGdsId(pcc.getOid(), pcc.getGds());
            } else if (pcc.getAction().equals("add")) {
                myOid = new Oid();
            } else {
                return false;
            }

            myOid.setOid(pcc.getOid());
            myOid.setIata(pcc.getIata());
            myOid.setType(pcc.getType());
            myOid.setStatus(pcc.getStatus());
            myOid.setComment(pcc.getComment());
            myOid.setGdsId(pcc.getGds());
            myOid.setCountryId(pcc.getCountry());
            myOid.setBelongId(pcc.getBelongId());
            myOid.setAssignedId(pcc.getAssignId());
            myOid.setReasonId(pcc.getReasonId());
            myOid.setIata(pcc.getIata());

            if (pcc.getCountry() == -1) {
                int id = this.countryRepository.saveAndFlush(new Country(pcc.getCountryCode(), pcc.getCountryName())).getId();
                myOid.setCountryId(id);

            }
            if (pcc.getBelongId() == -1) {
                int id = this.entitiesRepository.saveAndFlush(new OidEntities(pcc.getBelong())).getId();
                myOid.setBelongId(id);
                if (pcc.getBelong().equals(pcc.getAssign())) {
                    myOid.setAssignedId(id);
                    pcc.setAssignId(id);
                }
            }
            if (pcc.getAssignId() == -1) {
                int id = this.entitiesRepository.saveAndFlush(new OidEntities(pcc.getAssign())).getId();
                myOid.setAssignedId(id);
            }
            if (pcc.getReasonId() == -1) {
                int id = this.reasonRepository.saveAndFlush(new OidReasons(pcc.getReason())).getId();
                myOid.setReasonId(id);
            }

            if (pcc.getGds() == -1) {
                int id = this.gdsRepository.saveAndFlush(new Gds(pcc.getGdsCode(), pcc.getGdsName())).getId();
                myOid.setGdsId(id);
            }

            this.oidRepository.save(myOid);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
