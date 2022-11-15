package com.project.helpesk.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
class RoleTest {
    int id=1;
    String name = "Parth";
    
    @Test
    public void testGetterSetter() {
    Role role= new Role(id, name);
    role.setId(id);
    role.setName(name);
    assertEquals(1, role.getId());
    assertEquals(name, role.getName());
}

}