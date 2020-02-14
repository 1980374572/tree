package io.bnn.testweek3.controller;

import io.bnn.testweek3.dto.out.DepartmentNode;
import io.bnn.testweek3.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/getTree")
    public List<DepartmentNode> getTree(
            @RequestParam(required = false,defaultValue = "0")Integer departmentId
    ){
        List<DepartmentNode> departmentNodeList = departmentService.selectChildren(departmentId);
        return departmentNodeList;
    }
}
