# Write your MySQL query statement belo
Select name,unique_id
from Employees

left join EmployeeUNI
ON Employees.id=EmployeeUNI.id