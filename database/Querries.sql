show databases;

use eventpool;
show tables;

-- query 1
select * from event where id in (select event_id from contribution c  where user_id=9);
-- query 2
select * from event where id not in (select event_id from contribution c  where user_id=11);
-- query 3
select count(c.event_id) as paid ,count(r.event_id) as refused 
from `user` u left join contribution c on u.id = c.user_id 
left join refused r on r.user_id = u.id 
group by u.id HAVING u.id = 15;
-- query 4
select sum(amount) from contribution where user_id=12;
-- query 5
select g.id,count(ug.user_id) as user_count,g.name,g.created_by,g.created_on from `group` g 
join user_group ug on g.id=ug.group_id join `user` u on u.id =g.created_by where u.id = 12 group by ug.group_id ;


use processflow;
show tables;


-- query 1

select p.name as process_name,s.name as stage_name, t.name as task_name,GROUP_CONCAT( c.name) as checklist_name  
from process p inner join process_stage_mapping psm on p.id=psm.process_id 
inner join stage s on psm.stage_id=s.id
inner join stage_task_mapping stm on s.id=stm.stage_id 
inner join task t on stm.task_id = t.id 
inner join task_checklist_mapping tcm on t.id=tcm.task_id 
inner join checklist c on tcm.checklist_id = c.id where p.id=1 group by s.name,t.name;


-- employee
use employee;
show tables;
select * from department;
select * from employee;
select * from project_employee_mapping;
select * from projects;

-- query 1 
select * from employee e inner join project_employee_mapping pem on e.id = pem.employee_id  inner join projects p on pem.project_id =p.id;

-- query 2
select * from employee e left  join project_employee_mapping pem on e.id = pem.employee_id  left  join projects p on pem.project_id =p.id;

-- query 3
select * from employee e left  join project_employee_mapping pem on e.id = pem.employee_id  left  join projects p on pem.project_id =p.id;

-- query 4
select id,name from projects union select id,name from department;













