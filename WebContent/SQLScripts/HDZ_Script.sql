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
email varchar2(50) unique not null,
hashedpwd varchar2(200) not null,
salt varchar2(200),
firstname varchar2(100) not null,
lastname varchar2(100) not null,
bday varchar2(100) not null,
citizenflag varchar2(1),
citizen varchar2(100) not null,
visaflag varchar2(1),
visa varchar2(100) not null,
veteranflag varchar2(1),
veteran varchar2(100) not null,
drugtestflag varchar2(1),
drugtest varchar2(100) not null,
stdpanelflag varchar2(1),
stdpanel varchar2(100) not null,
dottestflag varchar2(1),
dottest varchar2(100) not null,
alcoholtestflag varchar2(1),
alcoholtest varchar2(100) not null

);


insert into HDZ_Applicant (applicantid, email, hashedpwd, firstname, lastname, bday, citizenflag, citizen, visaflag, visa, veteranflag, veteran, drugtestflag, drugtest, stdpanelflag, stdpanel, dottestflag, dottest, alcoholtestflag,alcoholtest) 
values (hdz_applicant_id_seq.nextval, 'sal@gmail.com', 'password', 'sal', 'snooze', '08/01/1992', null,'yes', null,'no', null,'yes', null,'yes',null,'yes',null,'yes',null,'yes');



create table HDZ_Education(
educationid integer primary key,
educationflag varchar2(1),
applicantid integer,
schoolname varchar2(200) not null,
degreecompleted varchar2(100),
datecompleted varchar2(100),
CONSTRAINT fk_HDZ_Education_applicantID FOREIGN KEY (applicantID) references HDZ_Applicant(applicantID)
);

insert into HDZ_Education (educationid,educationflag, applicantid, schoolname, degreecompleted, datecompleted ) 
values (hdz_education_id_seq.nextval,null,1, 'GWU', 'MS', '06/05/2016');

create table HDZ_jobhistory(
jobhistoryid integer primary key,
jobhistoryflag varchar2(1),
applicantid integer,
position varchar2(50) not null,
companyname varchar2(200) not null,
startdate varchar2(100) not null,
enddate varchar2(100),
description varchar2(100) not null,
CONSTRAINT fk_jobhistory_applicantID FOREIGN KEY (applicantID) references HDZ_applicant(applicantID)
);

insert into HDZ_jobhistory (jobhistoryid,jobhistoryflag,applicantID, position, companyname, startdate,enddate, description ) 
values (hdz_jobhistory_id_seq.nextval,null, 1,'Software Engineer', 'Facebook', '08/05/2010','01/07/2016','Java Programmer, Agile Development');


create table HDZ_reftable(
refid integer primary key,
refflag varchar2(1),
applicantid integer,
refname varchar2(50) not null,
refemail varchar2(200) not null,
refphone varchar2(200) not null,
refposition varchar2(200) not null,
CONSTRAINT fk_HDZ_reftable_applicantID FOREIGN KEY (applicantID) references HDZ_applicant(applicantID)
);

insert into HDZ_reftable (refid,refflag, applicantID,refname, refemail, refphone,refposition ) 
values (hdz_reftable_id_seq.nextval,null, 1,'Bob', 'bob@gmail.com', '2029940771','Senior Software Engineer');

create table HDZ_Jobs(
jobsid integer primary key,
position varchar2(50) not null,
description varchar2(200) not null
);

insert into HDZ_Jobs (jobsid, position, description)
values (hdz_jobs_id_seq.nextval, 'Software Engineer', 'Entry Level Java Programming and testing');

insert into HDZ_Jobs (jobsid, position, description)
values (hdz_jobs_id_seq.nextval, 'Hardware Engineer', 'ASIC CPU Design and Testing');

insert into HDZ_Jobs (jobsid, position, description)
values (hdz_jobs_id_seq.nextval, 'Quality Assurance', 'Software testing and configuration');

create table HDZ_application(
applicationid integer primary key,
applicantid integer not null,
codingtest varchar2(1) not null,
jobsid integer not null,
appstatus varchar2(50) not null,
CONSTRAINT fk_HDZ_application_applicantID FOREIGN KEY (applicantID) references HDZ_applicant(applicantID),
CONSTRAINT fk_HDZ_application_jobsID FOREIGN KEY (jobsID) references HDZ_jobs(jobsID)
);

insert into HDZ_application (applicationid, applicantID,codingtest, jobsID,appstatus)
values (hdz_application_id_seq.nextval, 1,'N', 1,'New');

create table HDZ_employee(
employeeid integer primary key,
empname varchar2(50) not null,
email varchar2(100) not null,
hashedpwd varchar2(200) not null,
salt varchar2(200),
position varchar2(100) not null
);

insert into HDZ_employee (employeeid, empname,email,hashedpwd,position)
values (hdz_employee_id_seq.nextval,'Dave','dave@gmail.com','password','HR Manager');

insert into HDZ_employee (employeeid, empname,email,hashedpwd,position)
values (hdz_employee_id_seq.nextval,'Sam','sam@gmail.com','password','Compliance Officer');

insert into HDZ_employee (employeeid, empname,email,hashedpwd,position)
values (hdz_employee_id_seq.nextval,'Juli','juli@gmail.com','password','HR Assistant');

insert into HDZ_employee (employeeid, empname,email,hashedpwd,position)
values (hdz_employee_id_seq.nextval,'Sue','sue@gmail.com','password','HR Specialist');

insert into HDZ_employee (employeeid, empname,email,hashedpwd,position)
values (hdz_employee_id_seq.nextval,'Dan','dan@gmail.com','password','Health Care Professional');

insert into HDZ_employee (employeeid, empname,email,hashedpwd,position)
values (hdz_employee_id_seq.nextval,'Alton','alton@gmail.com','password','Hiring Manager');

insert into HDZ_employee (employeeid, empname,email,hashedpwd,position)
values (hdz_employee_id_seq.nextval,'Ann','ann@gmail.com','password','Software Engineer');

insert into HDZ_employee (employeeid, empname,email,hashedpwd,position)
values (hdz_employee_id_seq.nextval,'Tim','tim@gmail.com','password','Technology analyst');

commit;

select * from HDZ_employee;
