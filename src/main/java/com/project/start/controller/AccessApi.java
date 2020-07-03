package com.project.start.controller;

import com.project.start.entities.GDS.OidsAccess.OidResponsible;
import com.project.start.entities.GDS.OidsAccess.TableView.AccessView;
import com.project.start.entities.PageDtoResults;
import com.project.start.services.OidAccessResponsibleService;
import com.project.start.services.OidAccessService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
public class AccessApi {

    private final OidAccessService service;
    private final OidAccessResponsibleService responsibleService;

    public AccessApi(OidAccessService service, OidAccessResponsibleService responsibleService) {
        this.service = service;
        this.responsibleService = responsibleService;
    }

    @GetMapping("dictionary/oids/access/responsible")
    public List<OidResponsible> getResponsible() {
        return this.responsibleService.getOidResponsible();
    }

    @GetMapping("dictionary/oids/access")
    public PageDtoResults<AccessView> getAccessList(
            @RequestParam("country") String country,
            @RequestParam("gds") String gds,
            @RequestParam("responsible") String responsible,
            @RequestParam("department") String department,
            @RequestParam("terminal") String terminal,
            @RequestParam("pcc") String pcc,
            @RequestParam("activeStatus") String activeStatus,
            @RequestParam("sortField") String sortField,
            @RequestParam("sortOrder") String sort,
            @RequestParam("pageNumber") Integer pNum,
            @RequestParam("pageSize") Integer pSize
    ) {
        return this.service.getAllAccessByCriteria(country, gds, responsible,
                department, terminal, pcc, activeStatus, sortField, sort, pNum, pSize);
    }

//    @GetMapping("dictionary/oids/accessbyoidid")
//    public Page<OidAccess> getAccessListById(
////            @RequestParam("OidId") Integer id,
////            @RequestParam("pageNumber") Integer pNum,
////            @RequestParam("pageSize") Integer pSize
//    ) {
//        Pageable page = PageRequest.of(1, 10, Sort.by("id").ascending());
//        return this.service.getListAccessByOid(470, page);
//    }

    //    @GetMapping("dictionary/oids/updatebyid")
//    public void updateAccess(
////            @RequestParam("oidId") Integer id,
////            @RequestParam("status") Integer status,
////            @RequestParam("resp") Integer resp
//    ) {
////        this.service.updateById(id,status,resp);
//        this.service.updateById(3, 3, 34);
//
//    }
//
//    @GetMapping("dictionary/oids/deletebyid")
//    public void deleteAccess(
////            @RequestParam("Id") Integer id
//    ) {
//        this.service.deleteById(2);
//    }
//
    @GetMapping("dictionary/oids/saveAccess")
    public void saveAccess(
//            @RequestParam("oidId") Integer oidid,
//            @RequestParam("access") String access,
//            @RequestParam("status") Integer status,
//            @RequestParam("resp") Integer resp
    ) {
        this.service.save(57, "CCVCC", 1, 34);
    }


//    @GetMapping("dictionary/oids/accessTest")
//    public List<OidAccess> test(
//            @RequestParam("country") String country
//
//    ) {
//        return this.accessRepository.testFind(country);
//    }

}
