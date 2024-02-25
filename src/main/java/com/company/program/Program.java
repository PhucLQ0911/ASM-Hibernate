package com.company.program;

import com.company.entity.*;
import com.company.repository.*;

import java.util.List;

public class Program {
    public static void main(String[] args) {
//        DepartmentProgram();
//        PositionProgram();
//        AccountProgram();
//        GroupProgram();
        GroupAccountProgram();
    }


    public static void DepartmentProgram() {
        DepartmentRepository departmentRepository = new DepartmentRepository();

        System.out.println("**************** GET ALL DEPARTMENTS ****************");
        List<Department> departments = departmentRepository.getAllDepartment();
        for (Department department : departments) {
            System.out.println(department.getId() + " - " + department.getName());
            for (Account account : department.getAccounts()) {
                System.out.println(account.getFullname());
            }
        }

//        System.out.println("**************** GET DEPARTMENT BY ID ****************");
//        Department departmentGetById = departmentRepository.getDepartmentById(1);
//        System.out.println(departmentGetById.getId() + " - " + departmentGetById.getName());

//        System.out.println("**************** GET DEPARTMENT BY NAME ****************");
//        Department departmentGetByName = departmentRepository.getDepartmentByName("Sercurity");
//        System.out.println(departmentGetByName.getId() + " - " + departmentGetByName.getName());

//        System.out.println("**************** CREATE DEPARTMENT ****************");
//        Department departmentCreate = new Department();
//        departmentCreate.setName("New Department");
//        departmentRepository.createDepartment(departmentCreate);

//        System.out.println("**************** UPDATE DEPARTMENT ****************");
//        departmentRepository.updateDepartment("New Update", 21);

//        System.out.println("**************** DELETE DEPARTMENT ****************");
//        departmentRepository.deleteDepartmentById(21);

//        System.out.println("***********CHECK DEPARTMENT EXISTS BY ID***********");
//        System.out.println(departmentRepository.isDepartmentExitsById(1));
//
//        System.out.println("***********CHECK DEPARTMENT EXISTS BY NAME***********");
//        System.out.println(departmentRepository.isDepartmentExitsByName("Security"));
    }

    public static void PositionProgram() {
        PositionRepository positionRepository = new PositionRepository();
        System.out.println("**************** GET ALL POSITIONS ****************");
        List<Position> positions = positionRepository.getAllPositions();
        for (Position position : positions) {
            System.out.println(position.getId() + " - " + position.getName());
            for (Account account : position.getAccounts()) {
                System.out.println(account.getUsername());
            }
        }
    }

    public static void AccountProgram() {
        AccountRepository accountRepository = new AccountRepository();
        DepartmentRepository departmentRepository = new DepartmentRepository();
        PositionRepository positionRepository = new PositionRepository();
        System.out.println("**************** GET ALL ACCOUNTS ****************");
        List<Account> accounts = accountRepository.getAllAccounts();
        for (Account account : accounts) {
            System.out.println("Account : [ " + "Id: " + account.getId() + " - " + "Email: " + account.getEmail() + " - " + "Fullname: " + account.getFullname() + " - " + "Department name : " + account.getDepartment().getName() + " - " + "Position name : " + account.getPosition().getName() + " - " + "Created date : " + account.getCreatedDate() + " ]");
        }

//        System.out.println("**************** CREATE ACCOUNT ****************");
//        Department department = departmentRepository.getDepartmentById(1);
//        Position position = positionRepository.getPositionById(1);
//        Account accountCreate = new Account();
//        accountCreate.setEmail("newaccount@gmail.com");
//        accountCreate.setUsername("NewAccount");
//        accountCreate.setFullname("New Account");
//        accountCreate.setDepartment(department);
//        accountCreate.setPosition(position);
//        accountRepository.createAccount(accountCreate);

    }

    public static void GroupProgram() {
        GroupRepository groupRepository = new GroupRepository();
        AccountRepository accountRepository = new AccountRepository();

        System.out.println("**************** GET ALL GROUPS ****************");
        List<Group> groups = groupRepository.getAllGroups();
        for (Group group : groups) {
            System.out.println(group.getId() + " - " + group.getName() + " - " + group.getCreator().getFullname() + " - " + group.getCreatedDate());
        }

//        Account accountCreateGroup = accountRepository.getAccountById(1);
//        System.out.println("**************** CREATE GROUPS ****************");
//        Group groupCreate = new Group();
//        groupCreate.setName("New Create Group");
//        groupCreate.setAccount(accountCreateGroup);
//        groupRepository.createdGroup(groupCreate);
    }

    public static void GroupAccountProgram() {
        GroupAccountRepository groupAccountRepository = new GroupAccountRepository();

        System.out.println("**************** GET ALL GROUP ACCOUNT ****************");
        List<GroupAccount> groupAccounts = groupAccountRepository.getAllGroupAccounts();

        for (GroupAccount groupAccount : groupAccounts) {
            System.out.println("Account: " + groupAccount.getAccount().getFullname());
            System.out.println("Group: " + groupAccount.getGroup().getName());
            System.out.println("JoinedDate: " + groupAccount.getJoinDate());
            System.out.println("-----------------------");
        }
    }
}
