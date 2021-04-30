--1 Uebung
--1
SELECT first_name, last_name, departments.DEPARTMENT_NAME, departments.department_id
FROM employees, departments;
--oder
SELECT first_name, last_name, departments.DEPARTMENT_NAME, departments.department_id
FROM employees CROSS JOIN departments;
--2 Übung
--1
SELECT l.LOCATION_ID, l.STREET_ADDRESS, l.CITY, c.COUNTRY_NAME
FROM LOCATIONS l NATURAL JOIN countries c;
--2
SELECT last_name, department_id, department_name
FROM employees NATURAL JOIN departments;
--3
select last_name, job_id, d.department_id, d.department_name
from employees e join departments d
on(e.DEPARTMENT_ID = d.DEPARTMENT_ID)
join locations l
on (d.LOCATION_ID = l.LOCATION_ID and l.CITY = 'Toronto');
--4
select e.last_name "Angestelleter", e.employee_id "Angestellter#", m.LAST_NAME "Manager", m.EMPLOYEE_ID "Manager#"
from employees e JOIN employees m
ON (e.MANAGER_ID = m.EMPLOYEE_ID);
--5
select e.last_name "Angestelleter", e.employee_id "Angestellter#", m.LAST_NAME "Manager", m.EMPLOYEE_ID "Manager#"
from employees e LEFT OUTER JOIN employees m
ON (e.MANAGER_ID = m.EMPLOYEE_ID);
--6
select e.LAST_NAME, e.HIRE_DATE
from employees e JOIN employees m
ON (e.HIRE_DATE > m.HIRE_DATE AND m.LAST_NAME = 'Davies');
--7
select e.LAST_NAME, e.HIRE_DATE, m.HIRE_DATE
from employees e JOIN employees m
ON (e.HIRE_DATE < m.HIRE_DATE AND e.MANAGER_ID = m.EMPLOYEE_ID);
--3 Uebung
--1
select location_id from locations
except
select location_id from departments;
--2
select department_id from employees
except
select department_id from employees
where job_id = 'ST_CLERK';
--3
select DEPARTMENT_ID, last_name
from employees
union
select DEPARTMENT_ID, DEPARTMENT_NAME
from departments;
--4
select d.department_name, r.REGION_NAME
from departments d join locations l on d.LOCATION_ID = l.LOCATION_ID 
    join countries c on l.COUNTRY_ID = c.COUNTRY_ID
    join regions r on c.REGION_ID = r.REGION_ID AND r.REGION_NAME IN ('Europe','Americas');

