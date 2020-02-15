package io.bnn.testweek3.controller;

import io.bnn.testweek3.dao.DepartmentMapper;
import io.bnn.testweek3.dto.in.DepartmentCreateInDTO;
import io.bnn.testweek3.dto.in.DepartmentUpdateInDTO;
import io.bnn.testweek3.dto.out.DepartmentNode;
import io.bnn.testweek3.po.Department;
import io.bnn.testweek3.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentMapper departmentMapper;

    @GetMapping("/getTree")
    public List<DepartmentNode> getTree(
            @RequestParam(required = false,defaultValue = "0")Integer departmentId
    ){
        List<DepartmentNode> departmentNodeList = departmentService.selectChildren(departmentId);
        return departmentNodeList;
    }


    @GetMapping("/getById")
    public Department getById(@RequestParam Integer departmentId){
        Department department = departmentMapper.selectByPrimaryKey(departmentId);
        return department;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody DepartmentCreateInDTO departmentCreateInDTO){
        Department department = new Department();
        department.setName(departmentCreateInDTO.getName());
        department.setParentId(departmentCreateInDTO.getParentId());
        department.setSortOrder(departmentCreateInDTO.getSortOrder());
        departmentMapper.insertSelective(department);
        return department.getDepartmentId();
    }

    @PostMapping("/update")
    public void update(@RequestBody DepartmentUpdateInDTO departmentUpdateInDTO){
        Department department = new Department();
        department.setDepartmentId(departmentUpdateInDTO.getDepartmentId());
        department.setName(departmentUpdateInDTO.getName());
        department.setSortOrder(departmentUpdateInDTO.getSortOrder());
        departmentMapper.updateByPrimaryKeySelective(department);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer departmentId) throws Exception {
        List<DepartmentNode> departmentNodes = departmentMapper.selectChildren(departmentId);
        int size = departmentNodes.size();
        if (size > 0){
            throw new Exception("size greater than 0, cannot delete");
        }
        departmentMapper.deleteByPrimaryKey(departmentId);
    }

}
