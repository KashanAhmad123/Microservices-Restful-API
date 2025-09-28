package com.example.demo;

import Exceptions.DepartmentNotMaintained;
import entity.department;
import org.h2.command.dml.MergeUsing;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import service.DepartmentService;
import service.DepartmentserviceImp;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceImpTest {

    @Mock
    DepartmentService departmentService;

    @InjectMocks
    DepartmentserviceImp departmentserviceImp;

    @Test
    public void fetchByIdTest() throws DepartmentNotMaintained {
        int departmentID= 22;
        department expectedDepartment= new department(22,"HR","Functional","112HJ0");

        when(departmentService.fetchdepbyId(departmentID)).thenReturn(expectedDepartment);
       department actualDepartment= departmentService.fetchdepbyId(departmentID);
        assertEquals(expectedDepartment.getDepartmentId(),actualDepartment.getDepartmentId());
         assertEquals(expectedDepartment.getDepartmentName(),actualDepartment.getDepartmentName());
         assertNotNull(actualDepartment);

    }

    @Test
    public  void fetch_By_InvalidID() throws DepartmentNotMaintained {

        long fail_ID = 0;
        when(departmentService.fetchdepbyId(fail_ID)).thenThrow(new DepartmentNotMaintained("Department not maintained " +fail_ID));
        assertThrows(DepartmentNotMaintained.class,
                ()->departmentService.fetchdepbyId(fail_ID));
    }

}