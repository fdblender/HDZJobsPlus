drop table HDZ_employee;
drop table HDZ_application;
drop table HDZ_jobhistory;
drop table HDZ_Education;
drop table HDZ_reftable;
drop table HDZ_jobs;
drop table HDZ_Applicant;


drop sequence hdz_employee_id_seq;
drop sequence hdz_application_id_seq;
drop sequence hdz_jobhistory_id_seq;
drop sequence hdz_education_id_seq;
drop sequence hdz_reftable_id_seq;
drop sequence hdz_jobs_id_seq;
drop sequence hdz_applicant_id_seq;

create sequence  hdz_applicant_id_seq start with 1 increment by 1 nocache;
create sequence  hdz_education_id_seq start with 1 increment by 1 nocache;
create sequence  hdz_jobhistory_id_seq start with 1 increment by 1 nocache;
create sequence  hdz_reftable_id_seq start with 1 increment by 1 nocache;
create sequence  hdz_jobs_id_seq start with 1 increment by 1 nocache;
create sequence  hdz_application_id_seq start with 1 increment by 1 nocache;
create sequence  hdz_employee_id_seq start with 1 increment by 1 nocache;

create table HDZ_Applicant (
applicantID integer primary key,
email varchar2(50) unique ,
hashedpwd varchar2(200) ,
salt varchar2(200),
firstname varchar2(100) ,
lastname varchar2(100) ,
bday varchar2(100) ,
citizenflag varchar2(1),
citizen varchar2(100) ,
visaflag varchar2(1),
visa varchar2(100) ,
veteranflag varchar2(1),
veteran varchar2(100) ,
drugtestflag varchar2(1),
drugtest varchar2(100) ,
stdpanelflag varchar2(1),
stdpanel varchar2(100) ,
dottestflag varchar2(1),
dottest varchar2(100) ,
alcoholtestflag varchar2(1),
alcoholtest varchar2(100) 

);


insert into HDZ_Applicant (applicantid, email, hashedpwd, salt, firstname, lastname, bday, citizenflag, citizen, visaflag, visa, veteranflag, veteran, drugtestflag, drugtest, stdpanelflag, stdpanel, dottestflag, dottest, alcoholtestflag,alcoholtest) 
values (hdz_applicant_id_seq.nextval, 'sal@gmail.com', '54daccaa47c824f9e30ab5a6d8850a1322ff76f09d571e6f75c351e62ca6ea92', '54daccaa47c824f9e30ab5a6d8850a1322ff76f09d571e6f75c351e62ca6ea92', 'sal', 'snooze', '08/01/1992', null,'yes', null,'no', null,'yes', null,'yes',null,'yes',null,'yes',null,'yes');

insert into HDZ_Applicant (applicantid, email, hashedpwd, salt, firstname, lastname, bday, citizenflag, citizen, visaflag, visa, veteranflag, veteran, drugtestflag, drugtest, stdpanelflag, stdpanel, dottestflag, dottest, alcoholtestflag,alcoholtest) 
values (hdz_applicant_id_seq.nextval, 'roy@gmail.com', '24c3c855e32fdf89f07f37c35f9cb60384af3ba8b4828607daa292bb0c63c6ee', '24c3c855e32fdf89f07f37c35f9cb60384af3ba8b4828607daa292bb0c63c6ee', 'roy', 'cook', '07/05/1988', null,'yes', null,'no', null,'yes', null,'yes',null,'yes',null,'yes',null,'yes');

insert into HDZ_Applicant (applicantid, email, hashedpwd, salt, firstname, lastname, bday, citizenflag, citizen, visaflag, visa, veteranflag, veteran, drugtestflag, drugtest, stdpanelflag, stdpanel, dottestflag, dottest, alcoholtestflag,alcoholtest) 
values (hdz_applicant_id_seq.nextval, 'jerry@gmail.com', 'e789626e67fe570204be7f81123fd31b4d6abdeabfc7a0e9a0f887bb17aa70ec', 'e789626e67fe570204be7f81123fd31b4d6abdeabfc7a0e9a0f887bb17aa70ec', 'jerry', 'wu', '03/09/1980', null,'no', null,'yes', null,'yes', null,'no',null,'no',null,'no',null,'no');

insert into HDZ_Applicant (applicantid, email, hashedpwd, salt, firstname, lastname, bday, citizenflag, citizen, visaflag, visa, veteranflag, veteran, drugtestflag, drugtest, stdpanelflag, stdpanel, dottestflag, dottest, alcoholtestflag,alcoholtest) 
values (hdz_applicant_id_seq.nextval, 'volker@gmail.com', 'b0c485f74e5e7bd3bbcc0dfc85641945db70c989b04a219133936feca6e04f22', 'hbGBcq+w1NHIdod8spbeVtlC9wrJFM2gzQfXgl4S8Ds=', 'volker', 'sorger', '08/06/1989', null,'yes', null,'no', null,'yes', null,'no',null,'no',null,'yes',null,'yes');

insert into HDZ_Applicant (applicantid, email, hashedpwd, salt, firstname, lastname, bday, citizenflag, citizen, visaflag, visa, veteranflag, veteran, drugtestflag, drugtest, stdpanelflag, stdpanel, dottestflag, dottest, alcoholtestflag,alcoholtest) 
values (hdz_applicant_id_seq.nextval, 'tommy@gmail.com', '44b812f2198040a98a6c9cab91813c1546e27695730ec150b9a75aa7691d98c3', 'oDIuWRN8mkhL4IbXs1rSY2rbbtEQuId0blDB9Z6M69Y=', 'robert', 'tommy', '06/07/1985', null,'no', null,'yes', null,'yes', null,'yes',null,'yes',null,'yes',null,'yes');

create table HDZ_Education(
educationid integer primary key,
educationflag varchar2(1),
applicantid integer,
schoolname varchar2(200) ,
degreecompleted varchar2(100),
datecompleted varchar2(100),
CONSTRAINT fk_HDZ_Education_applicantID FOREIGN KEY (applicantID) references HDZ_Applicant(applicantID)
);

insert into HDZ_Education (educationid,educationflag, applicantid, schoolname, degreecompleted, datecompleted ) 
values (hdz_education_id_seq.nextval,null,1, 'GWU', 'MS', '06/05/2016');

insert into HDZ_Education (educationid,educationflag, applicantid, schoolname, degreecompleted, datecompleted ) 
values (hdz_education_id_seq.nextval,null,2, 'GMU', 'BE', '06/20/2015');

insert into HDZ_Education (educationid,educationflag, applicantid, schoolname, degreecompleted, datecompleted ) 
values (hdz_education_id_seq.nextval,null,3, 'CSU', 'PHD', '05/15/2010');

insert into HDZ_Education (educationid,educationflag, applicantid, schoolname, degreecompleted, datecompleted ) 
values (hdz_education_id_seq.nextval,null,4, 'ASU', 'MS', '05/05/2014');

insert into HDZ_Education (educationid,educationflag, applicantid, schoolname, degreecompleted, datecompleted ) 
values (hdz_education_id_seq.nextval,null,5, 'UTD', 'PHD', '05/10/2013');

create table HDZ_jobhistory(
jobhistoryid integer primary key,
jobhistoryflag varchar2(1),
applicantid integer,
position varchar2(50) ,
companyname varchar2(200) ,
startdate varchar2(100) ,
enddate varchar2(100),
description varchar2(100) ,
CONSTRAINT fk_jobhistory_applicantID FOREIGN KEY (applicantID) references HDZ_applicant(applicantID)
);

insert into HDZ_jobhistory (jobhistoryid,jobhistoryflag,applicantID, position, companyname, startdate,enddate, description ) 
values (hdz_jobhistory_id_seq.nextval,null, 1,'Software Engineer', 'Facebook', '08/05/2010','01/07/2016','Java Programmer, Agile Development');

insert into HDZ_jobhistory (jobhistoryid,jobhistoryflag,applicantID, position, companyname, startdate,enddate, description ) 
values (hdz_jobhistory_id_seq.nextval,null, 1,'Business Analyst', 'IPS', '05/05/2013','01/07/2015','Agile, Waterfall methodology');

insert into HDZ_jobhistory (jobhistoryid,jobhistoryflag,applicantID, position, companyname, startdate,enddate, description ) 
values (hdz_jobhistory_id_seq.nextval,null, 1,'Hardware Engineer', 'Apple', '01/25/2010','01/20/2016','PCB design, Velilog, TCL,Perl');

insert into HDZ_jobhistory (jobhistoryid,jobhistoryflag,applicantID, position, companyname, startdate,enddate, description ) 
values (hdz_jobhistory_id_seq.nextval,null, 1,'Cyber Security Engineer', 'Amazon', '03/09/2000','01/07/2016','Java, networking');

insert into HDZ_jobhistory (jobhistoryid,jobhistoryflag,applicantID, position, companyname, startdate,enddate, description ) 
values (hdz_jobhistory_id_seq.nextval,null, 1,' Senior Software Engineer', 'Oracle', '08/05/2011','01/07/2015','Java Programmer,Adop');



create table HDZ_reftable(
refid integer primary key,
refflag varchar2(1),
applicantid integer,
refname varchar2(50) ,
refemail varchar2(200) ,
refphone varchar2(200) ,
refposition varchar2(200) ,
CONSTRAINT fk_HDZ_reftable_applicantID FOREIGN KEY (applicantID) references HDZ_applicant(applicantID)
);

insert into HDZ_reftable (refid,refflag, applicantID,refname, refemail, refphone,refposition ) 
values (hdz_reftable_id_seq.nextval,null, 1,'Bob', 'bob@gmail.com', '2029940771','Senior Software Engineer');

insert into HDZ_reftable (refid,refflag, applicantID,refname, refemail, refphone,refposition ) 
values (hdz_reftable_id_seq.nextval,null, 2,'jesica', 'jesica@gmail.com', '3019940771','Senior Software Engineer');

insert into HDZ_reftable (refid,refflag, applicantID,refname, refemail, refphone,refposition ) 
values (hdz_reftable_id_seq.nextval,null, 3,'rooney', 'rooney@gmail.com', '5987432160','Senior Software Engineer');

insert into HDZ_reftable (refid,refflag, applicantID,refname, refemail, refphone,refposition ) 
values (hdz_reftable_id_seq.nextval,null, 4,'he', 'he@gmail.com', '5467893212','Senior Software Engineer');

insert into HDZ_reftable (refid,refflag, applicantID,refname, refemail, refphone,refposition ) 
values (hdz_reftable_id_seq.nextval,null, 5,'su', 'su@gmail.com', '2015897844','Senior Software Engineer');

create table HDZ_Jobs(
jobsid integer primary key,
position varchar2(50) ,
description varchar2(200) 
);

insert into HDZ_Jobs (jobsid, position, description)
values (hdz_jobs_id_seq.nextval, 'Software Engineer', 'Entry Level Java Programming and testing');

insert into HDZ_Jobs (jobsid, position, description)
values (hdz_jobs_id_seq.nextval, 'Hardware Engineer', 'ASIC CPU Design and Testing');

insert into HDZ_Jobs (jobsid, position, description)
values (hdz_jobs_id_seq.nextval, 'Quality Assurance', 'Software testing and configuration');

insert into HDZ_Jobs (jobsid, position, description)
values (hdz_jobs_id_seq.nextval, 'Cyber security', 'Software development and networking ');

insert into HDZ_Jobs (jobsid, position, description)
values (hdz_jobs_id_seq.nextval, 'Senior Software Engineer', 'Java, Adop');

insert into HDZ_Jobs (jobsid, position, description)
values (hdz_jobs_id_seq.nextval, 'Entry level graduate', 'Java, Python');

create table HDZ_application(
applicationid integer primary key,
applicantid integer ,
codingtest varchar2(1) ,
jobsid integer ,
appstatus varchar2(50) ,
comments varchar2(500) ,
CONSTRAINT fk_HDZ_application_applicantID FOREIGN KEY (applicantID) references HDZ_applicant(applicantID),
CONSTRAINT fk_HDZ_application_jobsID FOREIGN KEY (jobsID) references HDZ_jobs(jobsID)
);

insert into HDZ_application (applicationid, applicantID,codingtest, jobsID,appstatus,comments)
values (hdz_application_id_seq.nextval, 1,'N', 1,'New',null);

insert into HDZ_application (applicationid, applicantID,codingtest, jobsID,appstatus,comments)
values (hdz_application_id_seq.nextval, 2,'N', 2,'New',null);

insert into HDZ_application (applicationid, applicantID,codingtest, jobsID,appstatus,comments)
values (hdz_application_id_seq.nextval, 3,'N', 3,'New',null);

insert into HDZ_application (applicationid, applicantID,codingtest, jobsID,appstatus,comments)
values (hdz_application_id_seq.nextval, 4,'N', 4,'New',null);

insert into HDZ_application (applicationid, applicantID,codingtest, jobsID,appstatus,comments)
values (hdz_application_id_seq.nextval, 5,'N', 5,'New',null);



create table HDZ_employee(
employeeid integer primary key,
empname varchar2(50) ,
email varchar2(100) ,
hashedpwd varchar2(200) ,
salt varchar2(200),
position varchar2(100) 
);

insert into HDZ_employee (employeeid, empname,email,hashedpwd, salt, position)
values (hdz_employee_id_seq.nextval,'Dave','dave@gmail.com','e95a5ad51f4af4ea83c652fbc74796ed413cff1fde20b01e29b7b749ad109d49', 'sFr6YJz/jKBZi8GPvtVz576kytszrhcj/kaSp9MZ2q0=', 'HR Manager');

insert into HDZ_employee (employeeid, empname,email,hashedpwd,salt, position)
values (hdz_employee_id_seq.nextval,'Sam','sam@gmail.com','ea46ff538d38fce90d9f6a177cb2c538e25f44a5deb47725115913ffc93ceaf2', 'W7BnXZhU/efVeOCaXEnfkI3L9s1vOfEZCYfE7+93D0k=','Compliance Officer');

insert into HDZ_employee (employeeid, empname,email,hashedpwd,salt, position)
values (hdz_employee_id_seq.nextval,'Juli','juli@gmail.com','8d9bd9192e2eed579d92ca4995289febcee969fa57979dde0feb5f6477427620', 'zYWAq2b39MEkGgcA1oXK5owfdtVFQad++2tK7futvAA=','HR Assistant');

insert into HDZ_employee (employeeid, empname,email,hashedpwd,salt, position)
values (hdz_employee_id_seq.nextval,'Sue','sue@gmail.com','34f78a77941dacb64b5010a3cd3971295982d9b6583fc8dbe770311c4f24b5b4', 'cFcwYn6sDNpz75L8qaLsqzZ2tqoz5BnqUdRw3JqYnNw=','HR Specialist');

insert into HDZ_employee (employeeid, empname,email,hashedpwd,salt, position)
values (hdz_employee_id_seq.nextval,'Dan','dan@gmail.com','f6833b84e13b10b6185323b9117c7f8352016b788b4bda9fe87f4b114d0c412a', 'V33qAk8La7ZncEff4K1ipai+xoJHk4MNK/iT8pUb840=','Health Care Professional');

insert into HDZ_employee (employeeid, empname,email,hashedpwd,salt, position)
values (hdz_employee_id_seq.nextval,'Alton','alton@gmail.com','b8baca6f17a499ed440162c8cce6fe6c10e1bdd64710611278645a60d68f2521', '3rcfjNzKUPmNsQH+avlc93xaxraDDYjigodbpBHDIx4=','Hiring Manager');

insert into HDZ_employee (employeeid, empname,email,hashedpwd,salt, position)
values (hdz_employee_id_seq.nextval,'Ann','ann@gmail.com','0bbb251acad14f46d04d12b26e574c77be42dc1a7f1e8591b21156bb3e61e8ea', 'zXBxr8AYFi2Tu5JsySHDhxWQ6H/ZSG4PBYDQeqXYAvA=','Software Engineer');

insert into HDZ_employee (employeeid, empname,email,hashedpwd,salt, position)
values (hdz_employee_id_seq.nextval,'Tim','tim@gmail.com','1374fdac46614f635ac1f88eff8f82ab38326edaf581f3c0692bfafd4def81fc', 'kKyCEuMFt3z/FkaGSa3wqaHvdNBFB2wbQcZsBhxmgT0=','Technology analyst');

commit;

select * from HDZ_employee;
