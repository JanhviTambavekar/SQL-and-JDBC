
 SELECT MAX('SALARY'),MIN('SALARY'),SUM('SALARY') FROM EMPLOYEE 
 WHERE SALARY BETWEEN (100000 AND 50000) AND  DESIGNATION NOT IN ('TESTING');
 
 
 SELECT MAX(SALARY),SUM(SALARY),'designation' FROM MANAGMENT WHERE 'HOD' IS NOT NULL AND EMP_ID IN(1,5) GROUP BY designation;

 SELECT  COUNT* FROM MANAGMENT WHERE DEPT ='IT' AND EMP_ID=3 AND COMMISSION IS NOT NULL  GROUP BY DEPT ;
 
 
 
 select sal*12 from employee where empid=1;
 