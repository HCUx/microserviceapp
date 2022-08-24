create
keyspace spring_cloud with replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

use
spring_cloud;

CREATE TABLE emp
(
    emp_id    int primary key,
    emp_name  text,
    emp_city  text,
    emp_sal   varint,
    emp_phone varint
);

select *
from emp;