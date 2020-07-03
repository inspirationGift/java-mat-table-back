package com.project.start.controller;

import com.project.start.entities.GDS.GEO.Country;
import com.project.start.entities.GDS.GEO.GdsCountry;
import com.project.start.entities.GDS.Oid.Oid;
import com.project.start.entities.GDS.Oid.OidDto;
import com.project.start.entities.GDS.Oid.OidEntities;
import com.project.start.entities.GDS.Oid.OidReasons;
import com.project.start.entities.PageDtoResults;
import com.project.start.services.OidService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class OidApi {

    private final OidService oidService;

    public OidApi(OidService oidService) {
        this.oidService = oidService;
    }

    @GetMapping({"/oids"})
    public List<Oid> getOids() {
        return this.oidService.getAllOids();
    }

    @GetMapping("dictionary/countrylist")
    public List<Country> getCountries() {
        return this.oidService.getCountries();
    }

    @GetMapping("dictionary/oids/cn")
    public List<GdsCountry> getDistinctDropDown() {
        return this.oidService.selectDistinctCountryAndGds();
    }

    @GetMapping("dictionary/oids/entity")
    public List<OidEntities> detOidEntity() {
        return this.oidService.selectEntities();
    }

    @GetMapping("dictionary/oids/reason")
    public List<OidReasons> getReason() {
        return this.oidService.selectReason();
    }

    @GetMapping({"dictionary/oids"})
    public @ResponseBody
    PageDtoResults<OidDto> getSortableOid(@RequestParam("country") String country,
                                          @RequestParam("gds") String gds,
                                          @RequestParam("online") Integer online,
                                          @RequestParam("reason") String reason,
                                          @RequestParam("active") String active,
                                          @RequestParam("field") String sortField,
                                          @RequestParam("sortOrder") String sortDirection,
                                          @RequestParam("pageNumber") Integer pNum,
                                          @RequestParam("pageSize") Integer pSize

    ) {
        return this.oidService.findByOptions(country, gds, online, active,
                reason, sortField, sortDirection, pNum, pSize);
    }

    @PostMapping("dictionary/oids/update")
    public @ResponseBody
    Boolean updateOidStatus(@RequestBody OidDto pcc) {
        return this.oidService.deleteOid(pcc);
    }


    @PostMapping("dictionary/oids/save")
    public @ResponseBody
    Boolean saveOid(@RequestBody OidDto pcc) {
        return this.oidService.saveOid(pcc);
    }
}

