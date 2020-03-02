package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.Department;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.util.ReflectionTestUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertSame;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentJdbcDaoImplMockTest {

    @InjectMocks
    private DepartmentJdbcDaoImpl departmentDao;

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Captor
    private ArgumentCaptor<RowMapper<Department>> mapper;

    @AfterEach
    void after() {
        verifyNoMoreInteractions(namedParameterJdbcTemplate);
    }

    @Test
    public void getDepartments() throws SQLException {

        int id = 5;
        String name = "Name";

        Department department = new Department();
        ResultSet rs = mock(ResultSet.class);

        String sql = "select";
        ReflectionTestUtils.setField(departmentDao,"SELECT_ALL", sql );

        when(namedParameterJdbcTemplate.query(anyString(), any(RowMapper.class)))
                .thenReturn(Collections.singletonList(department));

        when(rs.getInt(anyString())).thenReturn(id);
        when(rs.getString(anyString())).thenReturn(name);

        List<Department> departments = departmentDao.getDepartments();
        assertNotNull(departments);

        Department dep = departments.get(0);
        assertNotNull(dep);
        assertSame(dep, department);

        assertEquals(1, departments.size());
        verify(namedParameterJdbcTemplate).query(eq(sql), mapper.capture());

        RowMapper<Department> rowMapper = mapper.getValue();
        assertNotNull(rowMapper);
        Department result = rowMapper.mapRow(rs,0);
        assertNotNull(result);
        assertEquals(id, result.getDepartmentId().intValue());
        assertEquals(name, result.getDepartmentName());
    }

    @Test
    public void getDepartmentById() {
    }

    @Test
    public void addDepartment() {
    }

    @Test
    public void updateDepartment() {
    }

    @Test
    public void deleteDepartment() {
    }
}
