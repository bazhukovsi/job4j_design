package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {
    @Test
    public void whenAddAndFindThenRoleNameIsIT() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "IT"));
        Role result = role.findById("1");
        assertThat(result.getRole(), is("IT"));
    }

    @Test
    public void whenAddAndFindThenRoleIsNull() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "IT"));
        Role result = role.findById("10");
        assertNull(result);
    }

    @Test
    public void whenAddDuplicateAndFindRoleNameIsIT() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "IT"));
        role.add(new Role("1", "PR"));
        Role result = role.findById("1");
        assertThat(result.getRole(), is("IT"));
    }

    @Test
    public void whenReplaceThenRoleNameIsIT() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "IT"));
        role.replace("1", new Role("1", "PR"));
        Role result = role.findById("1");
        assertThat(result.getRole(), is("PR"));
    }

    @Test
    public void whenNoReplaceRoleThenNoChangeRolename() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "IT"));
        role.replace("10", new Role("10", "PR"));
        Role result = role.findById("1");
        assertThat(result.getRole(), is("IT"));
    }

    @Test
    public void whenDeleteRoleThenRoleIsNull() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "IT"));
        role.delete("1");
        Role result = role.findById("1");
        assertNull(result);
    }

    @Test
    public void whenNoDeleteUserThenUsernameIsPetr() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "IT"));
        role.delete("10");
        Role result = role.findById("1");
        assertThat(result.getRole(), is("IT"));
    }

}